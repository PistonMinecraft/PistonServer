package org.pistonmc.main;

import cpw.mods.modlauncher.Launcher;
import org.pistonmc.RuntimeProperties;

public class PreLaunch {
    static {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }
    public static void main(String[] args) {
        String[] pre = RuntimeProperties.get(RuntimeProperties.Key.SERVER_LAUNCH_ARGS);
        String[] launchArgs = new String[args.length + pre.length];
        System.arraycopy(args, 0, launchArgs, 0, args.length);
        System.arraycopy(pre, 0, launchArgs, args.length, pre.length);
        Launcher.main(launchArgs);
    }
}