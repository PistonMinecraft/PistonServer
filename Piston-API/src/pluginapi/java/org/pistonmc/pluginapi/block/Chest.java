package org.pistonmc.pluginapi.block;

import org.pistonmc.pluginapi.util.Inventory;

public interface Chest extends Block {
    Inventory getInventory();
    void setInventory(Inventory inventory);

}
