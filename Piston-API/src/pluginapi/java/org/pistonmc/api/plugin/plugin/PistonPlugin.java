package org.pistonmc.api.plugin.plugin;

import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class PistonPlugin {
    private @Nullable PluginManager pluginManager;

    public void onLoad() {}

    public void onEnable() {}

    public void onDisable() {}

    protected @Nullable PluginManager getPluginManager() {
        return pluginManager;
    }
}