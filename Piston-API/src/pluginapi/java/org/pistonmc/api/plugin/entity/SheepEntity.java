package org.pistonmc.api.plugin.entity;

import org.pistonmc.api.plugin.DyeColor;

public interface SheepEntity extends Entity {
    boolean isWooled();
    void setWooled(boolean wooled);
    DyeColor getColor();
    void setColor(DyeColor woolColor);
    boolean canShear();
}