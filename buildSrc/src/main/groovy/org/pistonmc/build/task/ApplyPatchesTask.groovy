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
        Files.list(inputPatchesDir).filter {it.toString().endsWith('.patch')}.withCloseable {
            it.forEach {
                Path p = inputPatchesDir.relativize(it)
                String path = p.toString().substring(0, p.toString().lastIndexOf('.java.patch')).replace('.', '/') + '.java'
                FileUtil.ensureDirectoryExist(outputSourceDir.resolve(path).getParent())
                Files.write(outputSourceDir.resolve(path), DiffUtils.patch(Files.readAllLines(originalBase.resolve(path)),
                        UnifiedDiffUtils.parseUnifiedDiff(Files.readAllLines(it))))
            }
        }
    }
}
