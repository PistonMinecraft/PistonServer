package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerLeaveServerEvent extends PlayerEvent {
    private String playerLeaveMessage;
    public PlayerLeaveServerEvent(PlayerEntity player, boolean isAsync, String playerLeaveMessage) {
        super(player, isAsync);
        this.playerLeaveMessage = playerLeaveMessage;
    }

    /**
     * 设置离开服务器的广播消息
     * @param playerLeaveMessage 离开服务器的广播消息
     */
    public void setPlayerLeaveMessage(String playerLeaveMessage) {
        this.playerLeaveMessage = playerLeaveMessage;
    }

    /**
     * 获取离开服务器的广播消息
     * @return 离开服务器的广播消息
     */
    public String getPlayerLeaveMessage() {
        return playerLeaveMessage;
    }
}
