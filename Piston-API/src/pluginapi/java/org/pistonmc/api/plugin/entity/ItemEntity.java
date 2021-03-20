package org.pistonmc.api.plugin.entity;

import org.pistonmc.api.plugin.item.Item;

public interface ItemEntity extends Entity {
    Item getItem();
}