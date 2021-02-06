package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.ItemEntity;

public class EntityThrowItemEvent extends EntityEvent {
    private final ItemEntity item;
    public EntityThrowItemEvent(Entity entity, boolean async, ItemEntity itemEntity) {
        super(entity, async);
        this.item = itemEntity;
    }

    /**
     * 返回被丢出的物品
     * @return 被丢出的物品
     */
    public ItemEntity getItem() {
        return item;
    }
}
