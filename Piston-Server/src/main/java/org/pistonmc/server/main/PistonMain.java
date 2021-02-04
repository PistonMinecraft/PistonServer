package org.pistonmc.server.main;

import joptsimple.*;
import net.minecraft.SharedConstants;
import net.minecraft.server.Main;

public class PistonMain {
    public static void main(String[] args) {
        OptionParser parser = new OptionParser();

        OptionSpecBuilder noguiO = parser.accepts("nogui");
        OptionSpecBuilder initSettingsO = parser.accepts("initSettings", "Initializes 'server.properties' and 'eula.txt', then quits");
        OptionSpecBuilder demoO = parser.accepts("demo");
        OptionSpecBuilder bonusChestO = parser.accepts("bonusChest");
        OptionSpecBuilder forceUpgradeO = parser.accepts("forceUpgrade");
        OptionSpecBuilder eraseCacheO = parser.accepts("eraseCache");
        OptionSpecBuilder safeModeO = parser.accepts("safeMode", "Loads level with vanilla datapack only");
        AbstractOptionSpec<Void> helpO = parser.accepts("help").forHelp();
        ArgumentAcceptingOptionSpec<String> singleplayerO = parser.accepts("singleplayer").withRequiredArg();
        ArgumentAcceptingOptionSpec<String> universeO = parser.accepts("universe").withRequiredArg().defaultsTo(".");
        ArgumentAcceptingOptionSpec<String> worldO = parser.accepts("world").withRequiredArg();
        ArgumentAcceptingOptionSpec<Integer> portO = parser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(-1);
        ArgumentAcceptingOptionSpec<String> serverIdO = parser.accepts("serverId").withRequiredArg(); // All vanilla options

        OptionSpecBuilder versionO = parser.accepts("version", "Prints server version");
        NonOptionArgumentSpec<String> nonOptions = parser.nonOptions();

        OptionSet options = parser.parse(args);
        if(options.has(helpO)) {
            parser.printHelpOn(System.err);
        } else if(options.has(versionO)) {
            System.out.println("Piston Minecraft Server v" + SharedConstants.getCurrentVersion().getName() + " - " +
                    PistonMain.class.getPackage().getImplementationVersion());
        } else {
            Main.main(null);
        }
    }
    private static void initLog4jProperties() {
    }
}