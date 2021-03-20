package org.pistonmc.api.plugin.block;

import org.pistonmc.api.plugin.inventory.Inventory;

public interface Container {
    Inventory getInventory();
}