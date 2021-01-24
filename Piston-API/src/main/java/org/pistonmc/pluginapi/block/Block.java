package org.pistonmc.pluginapi.block;

import org.pistonmc.pluginapi.location.Location;

public interface Block {
    void setBlockType(BlockType blockType);
    BlockType getBlockType();
    Location getBlockLocation();
    boolean hasColor();
    BlockColor getColor();
}
