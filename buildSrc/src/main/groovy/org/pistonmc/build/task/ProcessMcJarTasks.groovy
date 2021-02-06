package org.pistonmc.build.task

import cn.maxpixel.mcdecompiler.Deobfuscator
import cn.maxpixel.mcdecompiler.Info
import cn.maxpixel.mcdecompiler.Properties
import cn.maxpixel.mcdecompiler.deobfuscator.ProguardDeobfuscator
import cn.maxpixel.mcdecompiler.util.FileUtil
import cn.maxpixel.mcdecompiler.util.NetworkUtil
import cn.maxpixel.mcdecompiler.util.VersionManifest
import com.google.gson.JsonObject
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

class GenProcessedVanillaServerJarTask extends DefaultTask {
    private final Path PISTON_DIR = project.buildDir.toPath().resolve('pistonmc')
    @InputFile
    Path getInputPath() {
        return PISTON_DIR.resolve('server.jar')
    }
    @InputFile
    Path getMappingPath() {
        return PISTON_DIR.resolve('mappings.txt')
    }
    @Input
    boolean forceProcess

    @OutputFile
    Path getOutputPath() {
        return PISTON_DIR.resolve('server_processed.jar')
    }

    @TaskAction
    void execute() {
        String mcVersion = project.rootProject.ext.MC_VERSION
        Path tempPath = PISTON_DIR.resolve('md-temp')
        Properties.put(Properties.Key.TEMP_DIR, tempPath)
        FileUtil.ensureDirectoryExist(mappingPath.getParent())
        if(!forceProcess && Files.exists(outputPath)) return
        checkFile(inputPath, VersionManifest.getVersion(mcVersion).get('downloads').asJsonObject.get('server').asJsonObject)
        checkFile(mappingPath, VersionManifest.getVersion(mcVersion).get('downloads').asJsonObject.get('server_mappings').asJsonObject)
        logger.info('Trying processing jar...')
        try {
            Files.deleteIfExists(outputPath)
        } catch(IOException ignored) {
            logger.info('Process failed. Maybe your IDE locked the previously processed jar')
            return
        }
        FileUtil.deleteDirectory(tempPath)
        FileUtil.ensureDirectoryExist(tempPath)
        new ProguardDeobfuscator(mappingPath.toString()).deobfuscate(inputPath, outputPath)
        logger.info('Processed complete.')
    }
    void checkFile(Path inputPath, JsonObject obj) {
        if(Files.exists(inputPath)) {
            byte[] b = Files.readAllBytes(inputPath)
            if(!(b.digest('SHA-1') == obj.get('sha1').asString && b.length == obj.get('size').asInt)) {
                logger.error('File doesn\'t match hash or size, redownloading...')
                Files.delete(inputPath)
            }
        }
        if(Files.notExists(inputPath)) {
            NetworkUtil.newBuilder(obj.get("url").getAsString()).connect().withCloseable {
                logger.info('Downloading...')
                Files.copy(it.asStream(), inputPath, StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }
}
class GenDecompiledSourcesTask extends DefaultTask {
    private final Path PISTON_DIR = project.buildDir.toPath().resolve('pistonmc')
    @Input
    boolean forceGen = false
    Path getOutput() {
        return PISTON_DIR.resolve('mc-sources')
    }
    @TaskAction
    void execute() {
        if(forceGen) {
            Files.deleteIfExists(output)
        } else if(Files.exists(output) && Files.list(output).withCloseable {it.count() > 1}) {
            return
        }
        Properties.put(Properties.Key.TEMP_DIR, PISTON_DIR.resolve('md-temp'))
        Properties.put(Properties.Key.OUTPUT_DIR, PISTON_DIR)
        Properties.put(Properties.Key.OUTPUT_DECOMPILED_NAME, 'mc-sources')
        Deobfuscator deobfuscator = new Deobfuscator(new ProguardDeobfuscator(PISTON_DIR.resolve('mappings.txt').toString()))
        deobfuscator.decompile(Info.DecompilerType.FERNFLOWER)
        FileUtil.deleteDirectory(Properties.get(Properties.Key.TEMP_DIR))
    }
}