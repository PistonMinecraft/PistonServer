package org.pistonmc.pluginapi.entity;

import org.pistonmc.pluginapi.block.BlockColor;

public interface SheepEntity extends Entity {
    boolean hasWool();
    void setWool(boolean hasWool);
    BlockColor getColor();
    void setColor(BlockColor woolColor);
}
