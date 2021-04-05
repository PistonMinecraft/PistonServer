package org.pistonmc.api.plugin.plugin;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.pistonmc.api.plugin.Server;

public interface PluginManager {
    boolean loadPistonPlugin(@NonNull String mainClass);

    boolean registerEventListener();

    boolean loadPlugin(@NonNull PistonPlugin plugin);

    boolean loadPlugin(@NonNull String plugin);

    boolean unloadPlugin(@NonNull PistonPlugin plugin);

    boolean unloadPlugin(@NonNull String plugin);

    @NonNull Server getServer();
}