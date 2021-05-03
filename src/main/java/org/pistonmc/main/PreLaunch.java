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