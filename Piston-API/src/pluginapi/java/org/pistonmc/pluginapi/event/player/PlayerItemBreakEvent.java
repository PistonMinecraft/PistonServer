package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.item.Item;

public class PlayerItemBreakEvent extends PlayerEvent {
    private Item item;
    public PlayerItemBreakEvent(Item item, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
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
