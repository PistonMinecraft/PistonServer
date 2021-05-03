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

package org.pistonmc.build

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.file.ProjectLayout
import org.pistonmc.build.extension.MinecraftProcessPluginExtension
import org.pistonmc.build.task.ApplyPatchesTask
import org.pistonmc.build.task.GenPatchesTask
import org.pistonmc.build.task.ProcessServerJarTask

import javax.inject.Inject

class PistonBuild implements Plugin<Project> {
    static PistonBuild INSTANCE
    static final String CHARSET = 'UTF-8'
    final Directory PISTON_DIR

    @Inject
    PistonBuild(ProjectLayout layout) {
        INSTANCE = this
        PISTON_DIR = layout.buildDirectory.dir('pistonmc').get()
    }

    @Override
    void apply(Project project) {
        registerMinecraftProcessTasks(project, project.extensions.create('minecraftProcess', MinecraftProcessPluginExtension))
    }

    private static void registerMinecraftProcessTasks(Project project, MinecraftProcessPluginExtension mcProcessExtension) {
        project.tasks.register('genProcessedServerJar', ProcessServerJarTask) {
            it.accessTransformers = mcProcessExtension.accessTransformers
        }

        project.tasks.register('genPatches', GenPatchesTask) {
            it.inputSources = mcProcessExtension.minecraftSources
            it.outputPatches = mcProcessExtension.minecraftPatches
        }

        project.tasks.register('applyPatches', ApplyPatchesTask) {
            it.inputPatches = mcProcessExtension.minecraftPatches
            it.outputSources = mcProcessExtension.minecraftSources
        }
    }
}