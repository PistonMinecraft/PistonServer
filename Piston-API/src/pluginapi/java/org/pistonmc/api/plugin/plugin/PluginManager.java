package org.pistonmc.api.plugin.plugin;

import org.pistonmc.api.plugin.Server;

public interface PluginManager {
    boolean loadPistonPlugin(String mainClass);

    boolean registerEventListener();

    boolean loadPlugin(PistonPlugin plugin);

    boolean loadPlugin(String plugin);

    boolean unloadPlugin(PistonPlugin plugin);

    boolean unloadPlugin(String plugin);

    Server getServer();
}