package org.pistonmc.build.task

import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class ApplyPatchesTask extends DefaultTask {
    @Input
    Directory inputPatchesDir
    @OutputDirectory
    Directory outputSourceDir
    @TaskAction
    void execute() {
    }
}
