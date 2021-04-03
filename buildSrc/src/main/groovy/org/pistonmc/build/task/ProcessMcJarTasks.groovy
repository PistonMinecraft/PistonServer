package org.pistonmc.build.task

import cn.maxpixel.mcdecompiler.Deobfuscator
import cn.maxpixel.mcdecompiler.Info
import cn.maxpixel.mcdecompiler.Properties
import cn.maxpixel.mcdecompiler.deobfuscator.ProguardDeobfuscator
import cn.maxpixel.mcdecompiler.util.FileUtil
import cn.maxpixel.mcdecompiler.util.NetworkUtil
import cn.maxpixel.mcdecompiler.util.VersionManifest
import com.google.gson.JsonObject
import net.minecraftforge.accesstransformer.TransformerProcessor
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

class GenProcessedVanillaServerJarTask extends DefaultTask {
    private final String MC_VERSION = project.rootProject.ext.MC_VERSION

    private final Path PISTON_DIR
    {
        Files.createDirectories(PISTON_DIR = project.buildDir.toPath().resolve('pistonmc'))
    }

    @InputFile
    Path getInputPath() {
        Path ip = PISTON_DIR.resolve('server.jar')
        checkFile(ip, VersionManifest.getVersion(MC_VERSION).get('downloads').asJsonObject.get('server').asJsonObject)
        return ip
    }

    @InputFile
    Path getMappingPath() {
        Path mp = PISTON_DIR.resolve('mappings.txt')
        checkFile(mp, VersionManifest.getVersion(MC_VERSION).get('downloads').asJsonObject.get('server_mappings').asJsonObject)
        return mp
    }

    @Input
    boolean forceProcess

    @InputFiles
    List<Path> accessTransformers

    @OutputFile
    Path getOutputPath() {
        return PISTON_DIR.resolve('server_processed.jar')
    }

    @TaskAction
    void execute() {
        Path tempPath = PISTON_DIR.resolve('md-temp')
        Properties.put(Properties.Key.TEMP_DIR, tempPath)
        Properties.put(Properties.Key.REGEN_VAR_NAME, true)
        if(!forceProcess && Files.exists(outputPath)) return
        logger.info('Processing jar...')
        try {
            Files.deleteIfExists(outputPath)
        } catch(IOException ignored) {
            logger.info('Process failed. Maybe your IDE locked the previously processed jar')
            return
        }
        FileUtil.deleteDirectory(tempPath)
        FileUtil.ensureDirectoryExist(tempPath)
        Path deobfuscatedPath = tempPath.resolve("deobfuscated.jar")
        new ProguardDeobfuscator(mappingPath.toString()).deobfuscate(inputPath, deobfuscatedPath)
        if(accessTransformers != null && !accessTransformers.isEmpty()) {
            def list = ['--inJar', deobfuscatedPath.toAbsolutePath().toString(), '--outJar', outputPath.toAbsolutePath().toString()]
            accessTransformers.forEach({
                list.add('--atFile')
                list.add(it.toAbsolutePath().toString())
            })
            TransformerProcessor.main(list.toArray() as String[])
        }
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

    @InputFile
    Path inputJar

    @OutputDirectory
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
        Properties.put(Properties.Key.DOWNLOAD_DIR, PISTON_DIR.resolve('downloads'))
        Files.copy(Properties.get(Properties.Key.TEMP_DIR).resolve("fernflower_abstract_parameter_names.txt"), PISTON_DIR.resolve("ffapn"))
        Deobfuscator deobfuscator = new Deobfuscator(project.rootProject.ext.MC_VERSION, PISTON_DIR.resolve('mappings.txt').toString())
        Files.move(PISTON_DIR.resolve("ffapn"), Properties.get(Properties.Key.TEMP_DIR).resolve("fernflower_abstract_parameter_names.txt"))
        deobfuscator.decompile(Info.DecompilerType.FORGEFLOWER, inputJar, getOutput())
        FileUtil.deleteDirectory(Properties.get(Properties.Key.TEMP_DIR))
    }
}