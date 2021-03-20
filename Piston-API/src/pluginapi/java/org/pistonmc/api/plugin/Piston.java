package org.pistonmc.api.plugin;

public class Piston {
    private static Server server;

    public static Server getServer() {
        return server;
    }

    public static void setServer(Server server) {
        Piston.server = server;
    }
}