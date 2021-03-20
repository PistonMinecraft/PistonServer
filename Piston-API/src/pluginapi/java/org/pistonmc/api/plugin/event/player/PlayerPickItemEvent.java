package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;
import org.pistonmc.api.plugin.item.Item;

public class PlayerPickItemEvent extends PlayerEvent {
    private final Item item;

    public PlayerPickItemEvent(PlayerEntity player, Item item) {
        super(player);
        this.item = item;
    }

    /**
     * 返回被捡起的物品
     * @return 被捡起的物品
     */
    public Item getItem() {
        return item;
    }
}