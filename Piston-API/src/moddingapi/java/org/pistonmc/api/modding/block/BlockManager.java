package org.pistonmc.api.modding.block;


import org.pistonmc.api.modding.mod.PistonMod;

import java.util.ArrayList;
import java.util.List;


public interface BlockManager {
    List<PistonBlock> blocks = new ArrayList<PistonBlock>();

    PistonBlock getByName(String blockName);

    boolean registerBlock(PistonBlock pistonBlock);

    List<PistonBlock> getByPistonMod(PistonMod pistonMod);
}
