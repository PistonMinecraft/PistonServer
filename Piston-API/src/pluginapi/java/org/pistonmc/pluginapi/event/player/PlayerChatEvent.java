package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerChatEvent extends PlayerEvent {
    private String message;
    public PlayerChatEvent(String message,PlayerEntity triggerPlayer) {
        super(triggerPlayer);
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
}
