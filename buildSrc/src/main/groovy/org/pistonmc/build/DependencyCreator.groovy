package org.pistonmc.build

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.*
import org.gradle.work.Incremental
import org.gradle.work.InputChanges

import java.nio.file.Path

abstract class IncrementalGenProcessedVanillaServerJarTask extends DefaultTask {
    private final Path PISTON_DIR = project.buildDir.toPath().resolve("pistonmc")
    @Incremental
    @PathSensitive(PathSensitivity.ABSOLUTE)
    @InputFile
    final Path inputPath = PISTON_DIR.resolve("server.jar")

    @OutputFile
    final Path outputPath = PISTON_DIR.resolve("server_processed.jar")

    @TaskAction
    void execute(InputChanges changes) {
        changes.getFileChanges(project.files(inputPath))
    }
}

class DependencyCreator implements Plugin<Project> {
    @Override
    void apply(Project project) {
        File processDir = new File(project.getBuildDir(), "pistonmc")
        processDir.mkdir()
    }
}
