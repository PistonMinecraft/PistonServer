package org.pistonmc.api.modding.mod;

import java.io.File;

public interface PistonModManager {
    boolean loadPistonMod(String mainClass);

    /**
     * You can load PistonMod before LoadEvent
     * @param jarFile
     * @return
     */
    boolean loadPistonMod(File jarFile);

    PistonMod getPistonMod(String name);
}
