package org.pistonmc.pluginapi.entity;

import org.pistonmc.pluginapi.block.BlockColor;

public interface SheepEntity extends Entity {
    boolean hasWool();
    BlockColor getColor();
}
