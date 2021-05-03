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

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.function.Predicate;

public class PistonEnvironment {
    private static final ObjectArrayList<String> SKIP_PREFIXES = new ObjectArrayList<>();
    static {
        SKIP_PREFIXES.add("joptsimple.");
        SKIP_PREFIXES.add("org.lwjgl.");
        SKIP_PREFIXES.add("com.mojang.guava.");
        SKIP_PREFIXES.add("com.google.");
        SKIP_PREFIXES.add("org.apache.commons.");
        SKIP_PREFIXES.add("io.netty.");
        SKIP_PREFIXES.add("org.apache.logging.log4j.");
        SKIP_PREFIXES.add("org.apache.maven.");
        SKIP_PREFIXES.add("org.apache.http.");
        SKIP_PREFIXES.add("paulscode.sound.");
        SKIP_PREFIXES.add("com.ibm.icu.");
        SKIP_PREFIXES.add("sun.");
        SKIP_PREFIXES.add("gnu.trove.");
        SKIP_PREFIXES.add("com.electronwill.nightconfig.");
        SKIP_PREFIXES.add("net.minecraftforge.fml.loading.");
        SKIP_PREFIXES.add("net.minecraftforge.fml.language.");
        SKIP_PREFIXES.add("net.minecraftforge.eventbus.");
        SKIP_PREFIXES.add("net.minecraftforge.api.");
        SKIP_PREFIXES.add("com.mojang.util.QueueLogAppender"); // Thanks Forge :)

        SKIP_PREFIXES.add("org.pistonmc.server.main.");
        SKIP_PREFIXES.add("org.pistonmc.main.");
        SKIP_PREFIXES.add("org.pistonmc.RuntimeProperties");
        SKIP_PREFIXES.add("org.pistonmc.server.main.");
    }

    public static Predicate<String> getSkippedPackagesFilter() {
        return pkg -> SKIP_PREFIXES.stream().noneMatch(pkg::startsWith);
    }
}