package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.ItemEntity;
import org.pistonmc.pluginapi.util.Item;

public class EntityThrowItemEvent extends EntityEvent{
    private ItemEntity item;
    public EntityThrowItemEvent(ItemEntity itemEntity, Entity triggerEntity, boolean isAsync) {
        super(triggerEntity, isAsync);
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
