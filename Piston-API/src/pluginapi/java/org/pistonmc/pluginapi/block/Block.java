package org.pistonmc.pluginapi.block;

import org.pistonmc.pluginapi.location.Location;

public interface Block {
    BlockType getBlockType();
    Location getBlockLocation();
    boolean hasColor();
    BlockColor getColor();
}
