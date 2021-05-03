/*
 * PistonServer. A high performance, multi-API support Minecraft server.
 * Copyright (C) 2019-2021 PistonMC Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.pistonmc.build.task

import cn.maxpixel.mcdecompiler.Deobfuscator
import cn.maxpixel.mcdecompiler.Info
import cn.maxpixel.mcdecompiler.Properties
import cn.maxpixel.mcdecompiler.util.NetworkUtil
import cn.maxpixel.mcdecompiler.util.VersionManifest
import com.google.gson.JsonObject
import groovy.transform.PackageScope
import net.minecraftforge.accesstransformer.TransformerProcessor
import org.gradle.api.DefaultTask
import org.gradle.api.UncheckedIOException
import org.gradle.api.file.Directory
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFile
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.*
import org.pistonmc.build.PistonBuild

import static org.pistonmc.build.util.FileUtil.*

@PackageScope abstract class ProcessMcJarTask extends DefaultTask {
    @Internal final JsonObject downloads = VersionManifest.getVersion(project.MC_VERSION).get('downloads').asJsonObject

    @Input
    boolean force

    @InputFile
    abstract RegularFileProperty getInput()

    @InputFile
    abstract RegularFileProperty getMapping()

    @InputFiles
    abstract ListProperty<RegularFile> getAccessTransformers()

    @OutputFile
    abstract RegularFileProperty getOutput()

    @OutputDirectory
    abstract DirectoryProperty getDecompileOutput()

    ProcessMcJarTask() {
        PistonBuild build = PistonBuild.INSTANCE
        input.convention(build.PISTON_DIR.file('server.jar'))
        mapping.convention(build.PISTON_DIR.file('mappings.txt'))
        output.convention(build.PISTON_DIR.file('server_processed.jar'))
        decompileOutput.convention(build.PISTON_DIR.dir('mc-sources'))
        Properties.put(Properties.Key.TEMP_DIR, build.PISTON_DIR.dir('md-temp').asFile.toPath())
        Properties.put(Properties.Key.DOWNLOAD_DIR, build.PISTON_DIR.dir('downloads').asFile.toPath())
        Properties.put(Properties.Key.REGEN_VAR_NAME, true)
    }

    void checkFile(RegularFileProperty input, JsonObject artifact) {
        File f = getFile(input)
        if(f.exists()) {
            byte[] b = f.readBytes()
            if(!(b.digest('SHA-1') == artifact.get('sha1').asString && b.length == artifact.get('size').asInt)) {
                logger.error('File doesn\'t match hash or size, redownloading...')
                project.delete(input)
            }
        }
        if(!f.exists()) {
            NetworkUtil.newBuilder(artifact.get("url").getAsString()).connect().withCloseable {
                logger.info('Downloading...')
                createFileIfNotExists(f).append(it.asStream())
            }
        }
    }

    @TaskAction
    void execute() {
        Directory dir = PistonBuild.INSTANCE.PISTON_DIR.dir('md-temp')
        if(!force && exists(output) && exists(decompileOutput) && project.files(output).files.size() > 1000) return
        logger.info('Processing jar...')
        if(exists(output)) {
            try {
                project.delete(output)
            } catch(UncheckedIOException ignored) {
                logger.error('Process failed. Maybe your IDE locked the previously processed jar')
            }
            return
        }
        project.delete(dir)
        project.delete(decompileOutput)
        project.mkdir(dir)
        RegularFile processed = dir.file('deobfuscated.jar')
        Deobfuscator deobfuscator = new Deobfuscator(project.MC_VERSION, getFile(mapping).path)
        deobfuscator.deobfuscate(getAsPath(input), getAsPath(processed))
        if(accessTransformers.isPresent() && !accessTransformers.get().isEmpty()) {
            def list = ['--inJar', processed.asFile.absolutePath, '--outJar', getFile(output).absolutePath]
            accessTransformers.get().forEach({
                list.add('--atFile')
                list.add(it.asFile.absolutePath)
            })
            TransformerProcessor.main(list.toArray() as String[])
        } else project.copy {
            from(processed)
            into(output)
        }

        deobfuscator.decompile(Info.DecompilerType.FORGEFLOWER, getAsPath(output), getAsPath(decompileOutput))
        logger.info('Processed complete.')
    }
}

abstract class ProcessServerJarTask extends ProcessMcJarTask {
    ProcessServerJarTask() {
        checkFile(input, downloads.get('server').asJsonObject)
        checkFile(mapping, downloads.get('server_mappings').asJsonObject)
    }
}