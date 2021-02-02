package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.world.Portal;

public class EntityCreatePortalEvent extends EntityEvent {
    private Portal portal;
    public EntityCreatePortalEvent(Portal portal, Entity triggerEntity) {
        super(triggerEntity);
        this.portal = portal;
    }
}
