package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.event.Event;

public abstract class PlayerEvent extends Event {
    private final PlayerEntity triggerPlayer;

    public PlayerEvent(PlayerEntity triggerPlayer) {
        super();
        this.triggerPlayer = triggerPlayer;
    }

    public PlayerEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(isAsync);
        this.triggerPlayer = triggerPlayer;
    }

    /**
     * 返回触发该事件的玩家实体
     * @return 触发该事件的玩家实体
     */
    public PlayerEntity getTriggerPlayer() {
        return triggerPlayer;
    }
}
