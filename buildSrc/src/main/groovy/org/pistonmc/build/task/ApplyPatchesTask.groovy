package org.pistonmc.build.task


import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path

class ApplyPatchesTask extends DefaultTask {
    @Input
    Path inputPatchesDir
    @OutputDirectory
    Path outputSourceDir
    @TaskAction
    void execute() {
        GenDecompiledSourcesTask task = new GenDecompiledSourcesTask()
        dependsOn task
        project.exec {

        }
    }
}
