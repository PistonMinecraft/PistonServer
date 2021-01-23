package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerJoinServerEvent extends PlayerEvent {
    private String playerJoinMessage;
    public PlayerJoinServerEvent(PlayerEntity player, boolean isAsync, String playerJoinMessage) {
        super(player, isAsync);
        this.playerJoinMessage = playerJoinMessage;
    }

    /**
     * 设置进入服务器的广播消息
     * @param playerJoinMessage 进入服务器的广播消息
     */
    public void setPlayerJoinMessage(String playerJoinMessage) {
        this.playerJoinMessage = playerJoinMessage;
    }

    /**
     * 获取进入服务器的广播消息
     * @return 进入服务器的广播消息
     */
    public String getPlayerJoinMessage() {
        return playerJoinMessage;
    }

}
