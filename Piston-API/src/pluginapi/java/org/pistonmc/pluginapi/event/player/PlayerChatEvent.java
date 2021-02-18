package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.player.PlayerEntity;
import org.pistonmc.pluginapi.event.Cancelable;

public class PlayerChatEvent extends PlayerEvent implements Cancelable {
    private String message;
    private boolean cancelled;

    public PlayerChatEvent(String message, PlayerEntity player) {
        super(player);
        this.message = message;
    }

    public PlayerChatEvent(String message, PlayerEntity player, boolean async) {
        super(player, async);
        this.message = message;
    }

    /**
     * 返回玩家发出的消息
     * @return 玩家发出的消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置玩家发出的消息
     * @param message 玩家发出的消息
     */
    public void setMessage(String message) {
        this.message = message;
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