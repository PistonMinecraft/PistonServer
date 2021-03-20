package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

public class PlayerJoinServerEvent extends PlayerEvent {
    private String joinMessage;

    public PlayerJoinServerEvent(PlayerEntity player, String joinMessage) {
        super(player);
        this.joinMessage = joinMessage;
    }

    /**
     * 设置进入服务器的广播消息
     * @param joinMessage 进入服务器的广播消息
     */
    public void setJoinMessage(String joinMessage) {
        this.joinMessage = joinMessage;
    }

    /**
     * 获取进入服务器的广播消息
     * @return 进入服务器的广播消息
     */
    public String getJoinMessage() {
        return joinMessage;
    }
}