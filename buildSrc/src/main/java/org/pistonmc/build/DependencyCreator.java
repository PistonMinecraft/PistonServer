package org.pistonmc.build;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtraPropertiesExtension;
import org.pistonmc.build.util.DependencyUtil;

import java.io.File;

public class DependencyCreator implements Plugin<Project> {
    private static File PROCESS_DIR;
    @Override
    public void apply(Project project) {
        PROCESS_DIR = new File(project.getBuildDir(), "pistonmc");
        PROCESS_DIR.mkdir();
        project.getDependencies().add("implementation", project.files(DependencyUtil.genDependencyFromMinecraftJson((String)
                project.getRootProject().getExtensions().getByType(ExtraPropertiesExtension.class).get("MC_VERSION"), PROCESS_DIR)));
    }
}