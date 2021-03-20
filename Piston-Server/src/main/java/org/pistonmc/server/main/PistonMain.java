package org.pistonmc.server.main;

import joptsimple.*;
import net.minecraft.SharedConstants;
import net.minecraft.server.Main;
import org.pistonmc.server.RuntimeProperties;

import java.net.Proxy;

public class PistonMain {
    static {
       System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }
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
        ArgumentAcceptingOptionSpec<Proxy> proxyO = parser.accepts("proxy", "The network proxy to use").withRequiredArg().ofType(Proxy.class).defaultsTo(Proxy.NO_PROXY);
        OptionSpecBuilder nojlineO = parser.accepts("nojline", "Disable jline");
        OptionSpecBuilder noconsoleO = parser.accepts("noconsole");
        NonOptionArgumentSpec<String> nonOptions = parser.nonOptions();

        OptionSet options = parser.parse(args);
        if(options.has(helpO)) {
            parser.printHelpOn(System.err);
        } else if(options.has(versionO)) {
            System.out.println("Piston Minecraft Server v" + SharedConstants.getCurrentVersion().getName() + " - " +
                    PistonMain.class.getPackage().getImplementationVersion());
        } else {
            RuntimeProperties.put(RuntimeProperties.Key.GLOBAL_PROXY, options.valueOf(proxyO));
            if(options.has(nojlineO)) {
                RuntimeProperties.setSystemProperty(RuntimeProperties.SystemPropKey.BooleanPropKey.TERMINAL_JLINE, false);
            }
            if(options.has(noconsoleO)) {
                RuntimeProperties.setSystemProperty(RuntimeProperties.SystemPropKey.BooleanPropKey.TERMINAL_JLINE, false);
                RuntimeProperties.put(RuntimeProperties.Key.CONSOLE, false);
            }
            Main.main(options.has(noguiO), options.has(initSettingsO), options.has(demoO), options.has(bonusChestO),
                    options.has(forceUpgradeO), options.has(eraseCacheO), options.has(safeModeO), options.valueOf(singleplayerO),
                    options.valueOf(universeO), options.valueOf(worldO), options.valueOf(portO), options.valueOf(serverIdO),
                    options.valuesOf(nonOptions));
        }
    }
}