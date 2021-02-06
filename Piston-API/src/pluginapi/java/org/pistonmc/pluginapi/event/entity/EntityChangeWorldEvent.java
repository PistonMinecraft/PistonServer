package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.event.Cancelable;
import org.pistonmc.pluginapi.world.World;

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