package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.item.Item;

public class PlayerPickItemEvent extends PlayerEvent {
    private Item item;
    public PlayerPickItemEvent(Item item, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
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
