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
//        SKIP_PREFIXES.add("");
    }

    public static Predicate<String> getSkippedPackagesFilter() {
        return pkg -> SKIP_PREFIXES.stream().noneMatch(pkg::startsWith);
    }
}