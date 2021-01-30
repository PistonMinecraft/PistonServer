package org.pistonmc.build.task

import cn.maxpixel.mcdecompiler.Info
import cn.maxpixel.mcdecompiler.Properties
import cn.maxpixel.mcdecompiler.deobfuscator.ProguardDeobfuscator
import cn.maxpixel.mcdecompiler.util.FileUtil
import cn.maxpixel.mcdecompiler.util.NetworkUtil
import cn.maxpixel.mcdecompiler.util.VersionManifest
import com.google.gson.JsonObject
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

class GenProcessedVanillaServerJarTask extends DefaultTask {
    private final Path PISTON_DIR = project.buildDir.toPath().resolve('pistonmc')

    @Input
    boolean forceProcess

    @TaskAction
    File execute() {
        String mcVersion = project.rootProject.ext.MC_VERSION
        Properties.put(Properties.Key.TEMP_DIR, PISTON_DIR.resolve('md-temp'))
        Path inputPath = PISTON_DIR.resolve('server.jar')
        Path mappingPath = PISTON_DIR.resolve(Properties.getDownloadedProguardMappingPath(mcVersion, Info.SideType.SERVER))
        FileUtil.ensureDirectoryExist(mappingPath.getParent())
        Path outputPath = PISTON_DIR.resolve('server_processed.jar')
        if(!forceProcess && Files.exists(outputPath)) return outputPath.toFile()
        checkFile(inputPath, VersionManifest.getVersion(mcVersion).get('downloads').asJsonObject.get('server').asJsonObject)
        checkFile(mappingPath, VersionManifest.getVersion(mcVersion).get('downloads').asJsonObject.get('server_mappings').asJsonObject)
        logger.info('Trying processing jar...')
        try {
            Files.deleteIfExists(outputPath)
        } catch(IOException ignored) {
            logger.info('Process failed. Maybe your IDE locked the previously processed jar')
            return outputPath.toFile()
        }
        ProguardDeobfuscator deobfuscator = new ProguardDeobfuscator(mappingPath.toString())
        deobfuscator.deobfuscate(inputPath, outputPath)
        logger.info('Processed complete.')
        return outputPath.toFile()
    }
    void checkFile(Path inputPath, JsonObject obj) {
        if(Files.exists(inputPath)) {
            byte[] b = Files.readAllBytes(inputPath)
            if(!(b.digest('SHA-1') == obj.get('sha1').asString && b.length == obj.get('size').asInt)) {
                logger.error('Unmapped jar doesn\'t match hash or size, redownloading...')
                Files.delete(inputPath)
            }
        }
        if(Files.notExists(inputPath)) {
            NetworkUtil.newBuilder(obj.get("url").getAsString()).connect().withCloseable {
                logger.info('Downloading jar...')
                Files.copy(it.asStream(), inputPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}