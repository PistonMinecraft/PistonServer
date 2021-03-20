package org.pistonmc.api.plugin.block;

import org.pistonmc.api.plugin.location.Location;
import org.pistonmc.api.plugin.DyeColor;

public interface Block {
    BlockType getBlockType();
    Location getBlockLocation();
    boolean hasColor();
    DyeColor getColor();
}