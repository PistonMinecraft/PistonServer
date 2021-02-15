package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.event.Cancelable;
import org.pistonmc.pluginapi.inventory.Inventory;

public class PlayerOpenInventoryEvent extends PlayerEvent implements Cancelable {
    private final Inventory inventory;
    private boolean cancelled;

    public PlayerOpenInventoryEvent(PlayerEntity player, Inventory open) {
        super(player);
        this.inventory = open;
    }

    public Inventory getInventory() {
        return inventory;
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