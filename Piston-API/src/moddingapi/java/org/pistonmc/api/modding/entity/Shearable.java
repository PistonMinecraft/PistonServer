package org.pistonmc.api.modding.entity;

import org.pistonmc.api.modding.item.Item;

public interface Shearable {
    Item getDropItem();
    void setDropItem(Item item);
}
