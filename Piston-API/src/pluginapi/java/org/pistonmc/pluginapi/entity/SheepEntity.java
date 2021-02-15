package org.pistonmc.pluginapi.entity;

import org.pistonmc.pluginapi.DyeColor;

public interface SheepEntity extends Entity {
    boolean isWooled();
    void setWooled(boolean wooled);
    DyeColor getColor();
    void setColor(DyeColor woolColor);
    boolean canShear();
}