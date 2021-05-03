/*
 * PistonServer. A high performance, multi-API support Minecraft server.
 * Copyright (C) 2019-2021 PistonMC Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.pistonmc.server.main;

import cpw.mods.modlauncher.api.ILaunchHandlerService;
import cpw.mods.modlauncher.api.ITransformingClassLoader;
import cpw.mods.modlauncher.api.ITransformingClassLoaderBuilder;
import joptsimple.*;
import net.minecraft.SharedConstants;
import net.minecraft.server.Main;
import org.pistonmc.RuntimeProperties;
import org.pistonmc.main.PistonEnvironment;

import java.net.Proxy;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class PistonServerLaunchHandler implements ILaunchHandlerService {
    @Override
    public String name() {
        return "pistonserver";
    }

    @Override
    public void configureTransformationClassLoader(ITransformingClassLoaderBuilder builder) {
    }

    @Override
    public Callable<Void> launchService(String[] arguments, ITransformingClassLoader launchClassLoader) {
        launchClassLoader.addTargetPackageFilter(PistonEnvironment.skippedPackagesFilter);
        return () -> {
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

            OptionSet options = parser.parse(arguments);
            if(options.has(helpO)) {
                parser.printHelpOn(System.err);
            } else if(options.has(versionO)) {
                System.out.println("Piston Minecraft Server v" + SharedConstants.getCurrentVersion().getName() + " - " +
                        getClass().getPackage().getImplementationVersion());
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
            return null;
        };
    }

    @Override
    public Path[] getPaths() {
        return new Path[] { Paths.get(getClass().protectionDomain.codeSource.location.toURI()) };
    }
}