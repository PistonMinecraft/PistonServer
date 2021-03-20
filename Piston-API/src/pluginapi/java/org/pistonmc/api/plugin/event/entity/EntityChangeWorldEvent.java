package org.pistonmc.api.plugin.event.entity;

import org.pistonmc.api.plugin.entity.Entity;
import org.pistonmc.api.plugin.world.World;
import org.pistonmc.api.common.event.Cancelable;

public class EntityChangeWorldEvent extends EntityEvent implements Cancelable {
    private final World from;
    private final World to;
    private boolean cancelled;

    public EntityChangeWorldEvent(Entity entity, World from, World to) {
        super(entity);
        this.from = from;
        this.to = to;
    }

    public World getFrom() {
        return from;
    }

    public World getTo() {
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