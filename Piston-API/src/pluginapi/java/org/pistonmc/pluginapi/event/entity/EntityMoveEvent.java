package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;

public class EntityMoveEvent extends EntityEvent {
    public EntityMoveEvent(Entity triggerEntity, boolean isAsync) {
        super(triggerEntity, isAsync);
    }
}
