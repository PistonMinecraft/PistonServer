package org.pistion.minecraft.event.player;

import org.pistion.minecraft.entity.PlayerEntity;

public class PlayerLeaveServerEvent extends PlayerEvent{
    //玩家离开服务器事件
    private String playerLeaveMessage;
    public PlayerLeaveServerEvent(PlayerEntity player, String playerLeaveMessage, boolean isAsync) {
        super(player, isAsync);
        this.playerLeaveMessage = playerLeaveMessage;
    }
    public void setPlayerJoinMessage(String playerJoinMessage){
        //设置离开服务器的广播消息
        this.playerLeaveMessage = playerLeaveMessage;
    }
    public String getPlayerJoinMessage(){
        //获取离开服务器的广播消息
        return playerLeaveMessage;
    }
}
