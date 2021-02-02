package org.pistonmc.pluginapi.item;

public interface Item {
    ItemType getItemType();
    String getItemName();
    ItemNBT getItemNBT();
}
