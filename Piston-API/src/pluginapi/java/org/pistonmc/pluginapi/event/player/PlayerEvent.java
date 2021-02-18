package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.player.PlayerEntity;
import org.pistonmc.pluginapi.event.Event;

public abstract class PlayerEvent extends Event {
    private final PlayerEntity player;

    public PlayerEvent(PlayerEntity player) {
        super();
        this.player = player;
    }

    public PlayerEvent(PlayerEntity player, boolean async) {
        super(async);
        this.player = player;
    }

    /**
     * 返回触发该事件的玩家实体
     * @return 触发该事件的玩家实体
     */
    public PlayerEntity getPlayer() {
        return player;
    }
}