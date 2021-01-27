package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.event.Event;

public abstract class EntityEvent extends Event {
    private final Entity triggerEntity;

    public EntityEvent(Entity triggerEntity) {
        super();
        this.triggerEntity = triggerEntity;
    }

    public EntityEvent(Entity triggerEntity, boolean isAsync) {
        super(isAsync);
        this.triggerEntity = triggerEntity;
    }

    /**
     * 返回触发该事件的实体
     * @return  触发事件实体
     */
    public Entity getTriggerEntity() {
        return triggerEntity;
    }
}
