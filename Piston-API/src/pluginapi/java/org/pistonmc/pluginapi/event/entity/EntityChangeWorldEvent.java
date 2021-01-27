package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.event.Cancelable;
import org.pistonmc.pluginapi.world.WorldType;

public class EntityChangeWorldEvent extends EntityEvent implements Cancelable {
    private final WorldType from;
    private final WorldType to;
    private boolean cancelled;

    public EntityChangeWorldEvent(Entity triggerEntity, WorldType from, WorldType to) {
        super(triggerEntity);
        this.from = from;
        this.to = to;
    }

    public EntityChangeWorldEvent(Entity triggerEntity, boolean isAsync, WorldType from, WorldType to) {
        super(triggerEntity, isAsync);
        this.from = from;
        this.to = to;
    }

    public WorldType getFrom() {
        return from;
    }

    public WorldType getTo() {
        return to;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}