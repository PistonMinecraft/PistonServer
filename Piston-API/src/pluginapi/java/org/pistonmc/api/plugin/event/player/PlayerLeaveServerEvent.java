package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

public class PlayerLeaveServerEvent extends PlayerEvent {
    private String leaveMessage;

    public PlayerLeaveServerEvent(PlayerEntity player, String leaveMessage) {
        super(player);
        this.leaveMessage = leaveMessage;
    }

    /**
     * 设置离开服务器的广播消息
     * @param leaveMessage 离开服务器的广播消息
     */
    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    /**
     * 获取离开服务器的广播消息
     * @return 离开服务器的广播消息
     */
    public String getLeaveMessage() {
        return leaveMessage;
    }
}