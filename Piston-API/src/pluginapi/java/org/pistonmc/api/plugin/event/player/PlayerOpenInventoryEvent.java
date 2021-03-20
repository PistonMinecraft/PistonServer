package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;
import org.pistonmc.api.plugin.inventory.Inventory;
import org.pistonmc.api.common.event.Cancelable;

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