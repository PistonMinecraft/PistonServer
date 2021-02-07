package org.pistonmc.build.task

import cn.maxpixel.mcdecompiler.util.FileUtil
import com.github.difflib.DiffUtils
import com.github.difflib.UnifiedDiffUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files
import java.nio.file.Path

class GenPatchesTask extends DefaultTask {
    @InputDirectory
    Path inputSourcesDir
    @OutputDirectory
    Path outputPatchesDir
    @TaskAction
    void execute() {
        GenDecompiledSourcesTask task = dependsOn.find { it instanceof GenDecompiledSourcesTask } as GenDecompiledSourcesTask
        if(task == null) throw new Exception("Must depend on a GenDecompiledSourcesTask to be sure that decompiled sources are generated")
        Path decompiledSources = task.output
        if(Files.exists(inputSourcesDir)) {
            Path sourceRoot = inputSourcesDir.getParent().getParent()
            Files.walk(inputSourcesDir).filter{Files.isRegularFile(it) }.withCloseable {
                it.forEach {
                    Path relativizePath = sourceRoot.relativize(it)
                    List<String> originalLines = Files.readAllLines(decompiledSources.resolve(relativizePath))
                    String fileName = relativizePath.toString().replace(System.getProperty('file.separator'), '.')
                    Files.write(outputPatchesDir.resolve(fileName + '.patch'), UnifiedDiffUtils.generateUnifiedDiff('a/' + relativizePath.toString().replace('\\', '/'),
                            'b/' + relativizePath.toString().replace('\\', '/'), originalLines, DiffUtils.diff(originalLines, Files.readAllLines(it)), 5))
                }
            }
        }
    }
}

class ApplyPatchesTask extends DefaultTask {
    @InputDirectory
    Path inputPatchesDir
    @OutputDirectory
    Path outputSourceDir
    @TaskAction
    void execute() {
        GenDecompiledSourcesTask task = dependsOn.find { it instanceof GenDecompiledSourcesTask } as GenDecompiledSourcesTask
        if(task == null) throw new Exception("Must depend on a GenDecompiledSourcesTask to be sure that decompiled sources are generated")
        Path originalBase = task.output
        logger.info('Applying patches')
        Files.list(inputPatchesDir).filter {it.toString().endsWith('.patch')}.withCloseable {
            it.forEach {
                logger.info('Applying ' + it + '...')
                Path p = inputPatchesDir.relativize(it)
                String path = p.toString().substring(0, p.toString().lastIndexOf('.java.patch')).replace('.', '/') + '.java'
                FileUtil.ensureDirectoryExist(outputSourceDir.resolve(path).getParent())
                Files.write(outputSourceDir.resolve(path), DiffUtils.patch(Files.readAllLines(originalBase.resolve(path)),
                        UnifiedDiffUtils.parseUnifiedDiff(Files.readAllLines(it))))
            }
        }
    }
}
