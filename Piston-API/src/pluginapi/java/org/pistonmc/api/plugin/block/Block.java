package org.pistonmc.api.plugin.block;

import org.pistonmc.api.plugin.DyeColor;
import org.pistonmc.api.plugin.location.Position;

public interface Block {
    BlockType getBlockType();
    Position getBlockLocation();
    boolean hasColor();
    DyeColor getColor();
}