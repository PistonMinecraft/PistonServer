package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.item.Item;

public class PlayerItemBreakEvent extends PlayerEvent {
    private final Item item;

    public PlayerItemBreakEvent(PlayerEntity player, Item item) {
        super(player);
        this.item = item;
    }

    /**
     * 返回损坏的物品
     * @return 损坏的物品
     */
    public Item getItem() {
        return item;
    }
}
