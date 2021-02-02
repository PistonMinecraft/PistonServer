package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.EntityType;

public class EntityTypeChangeEvent extends EntityEvent {
    private EntityType from;
    public EntityTypeChangeEvent(EntityType from,Entity triggerEntity, boolean isAsync) {
        super(triggerEntity, isAsync);
        this.from = from;
    }
    /**
     * 返回由什么实体改变
     * @return 由什么实体改变
     */
    public EntityType getFrom() {
        return from;
    }
}
