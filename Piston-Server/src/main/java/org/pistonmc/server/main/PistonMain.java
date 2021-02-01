package org.pistonmc.server.main;

import joptsimple.OptionParser;
import net.minecraft.server.Main;

public class PistonMain {
    public static void main(String[] args) {
        OptionParser parser = new OptionParser();
        Main.main(null);
    }
    private static void initLog4jProperties() {
    }
}