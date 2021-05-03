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

import com.github.difflib.DiffUtils
import com.github.difflib.UnifiedDiffUtils
import groovy.transform.PackageScope
import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileVisitDetails
import org.gradle.api.tasks.*

import static org.pistonmc.build.PistonBuild.CHARSET
import static org.pistonmc.build.util.FileUtil.createFileIfNotExists
import static org.pistonmc.build.util.FileUtil.getFile

@PackageScope abstract class PatchTask extends DefaultTask {
    @Internal final ProcessMcJarTask task

    PatchTask() {
        TaskCollection<ProcessMcJarTask> tasks = project.tasks.withType(ProcessMcJarTask)
        dependsOn tasks
        task = tasks.iterator().next()
    }
}

abstract class GenPatchesTask extends PatchTask {
    @InputDirectory
    abstract DirectoryProperty getInputSources()

    @OutputDirectory
    abstract DirectoryProperty getOutputPatches()

    @TaskAction
    void execute() {
        Directory decompiledSources = task.decompileOutput.locationOnly.get()
        if(inputSources.asFile.get().exists()) {
            inputSources.asFileTree.matching {
                include 'net/minecraft/'
            }.visit { FileVisitDetails details ->
                if(!details.directory) {
                    String relativePathString = details.relativePath.pathString
                    File originalFile = decompiledSources.file(relativePathString).asFile
                    List<String> originalLines = originalFile.exists() ? originalFile.readLines(CHARSET) : Collections.<String>emptyList()
                    createFileIfNotExists(getFile(outputPatches.file(relativePathString.replace('/', '.') + '.patch')))
                            .withWriter(CHARSET) {
                        UnifiedDiffUtils.generateUnifiedDiff('a/' + relativePathString, 'b/' + relativePathString, originalLines,
                                DiffUtils.diff(originalLines, details.file.readLines(CHARSET)), 5).forEach(it::writeLine)
                    }
                }
            }
        }
    }
}

abstract class ApplyPatchesTask extends PatchTask {
    @InputDirectory
    abstract DirectoryProperty getInputPatches()

    @OutputDirectory
    abstract DirectoryProperty getOutputSources()

    @TaskAction
    void execute() {
        Directory decompiledSources = task.decompileOutput.locationOnly.get()
        logger.info('Applying patches')
        inputPatches.asFileTree.matching {
            include '**/*.patch'
        }.visit { FileVisitDetails details ->
            String fileName = details.name
            logger.info('Applying {} ...', fileName)
            String path = fileName.substring(0, fileName.lastIndexOf('.java.patch')).replace('.', '/').concat('.java')
            createFileIfNotExists(getFile(outputSources.file(path))).withWriter('UTF-8') {
                DiffUtils.patch(decompiledSources.file(path).asFile.readLines('UTF-8'),
                        UnifiedDiffUtils.parseUnifiedDiff(details.file.readLines('UTF-8'))).forEach(it::writeLine)
            }
        }
    }
}
