package org.pistonmc.api.modding.entity.item;

import org.pistonmc.api.modding.entity.PistonEntity;
import org.pistonmc.api.modding.item.Item;

public interface PistonItemEntity extends PistonEntity {
    Item getItem();
}
