package org.pistonmc.pluginapi.entity;

import org.pistonmc.pluginapi.util.Inventory;

public interface PlayerEntity extends Entity {
    float getHunger();
    Inventory getInventory();
}