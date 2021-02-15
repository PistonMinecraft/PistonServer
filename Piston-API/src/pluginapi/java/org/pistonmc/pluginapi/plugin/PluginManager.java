package org.pistonmc.pluginapi.plugin;

import org.pistonmc.pluginapi.Server;

public interface PluginManager {
    boolean loadPistonPlugin(String mainClass);

    boolean registerEventListener();

    boolean loadPlugin(PistonPlugin plugin);

    boolean loadPlugin(String plugin);

    boolean unloadPlugin(PistonPlugin plugin);

    boolean unloadPlugin(String plugin);

    Server getServer();
}