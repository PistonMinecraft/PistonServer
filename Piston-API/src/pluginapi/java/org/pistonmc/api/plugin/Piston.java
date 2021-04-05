package org.pistonmc.api.plugin;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Piston {
    private static @Nullable Server server;

    public static @Nullable Server getServer() {
        return server;
    }

    public static void setServer(@NonNull Server server) {
        Piston.server = server;
    }
}