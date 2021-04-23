package org.pistonmc.api.modding.entity;

import org.pistonmc.api.modding.item.Item;

public interface PistonEntity {
    double getHealth();
    void setHealth(double health);
    EntityAttribute getAttribute();
    Item deathDrop();
    void setDeathDrop(Item item);
}
