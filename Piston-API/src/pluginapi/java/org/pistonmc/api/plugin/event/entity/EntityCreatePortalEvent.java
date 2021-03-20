package org.pistonmc.api.plugin.event.entity;

import org.pistonmc.api.plugin.entity.Entity;
import org.pistonmc.api.plugin.world.Portal;

/**
 * TODO
 */
public class EntityCreatePortalEvent extends EntityEvent {
    private Portal portal;

    public EntityCreatePortalEvent(Portal portal, Entity entity) {
        super(entity);
        this.portal = portal;
    }
}