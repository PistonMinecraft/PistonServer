package org.pistion.minecraft.event.player;

import org.pistion.minecraft.entity.PlayerEntity;

public class PlayerJoinServerEvent extends PlayerEvent{
    //玩家进入服务器事件
    private String playerJoinMessage;
    public PlayerJoinServerEvent(PlayerEntity player,String playerJoinMessage, boolean isAsync) {
        super(player, isAsync);
        this.playerJoinMessage = playerJoinMessage;
    }
    public void setPlayerJoinMessage(String playerJoinMessage){
        //设置进入服务器的广播消息
        this.playerJoinMessage = playerJoinMessage;
    }
    public String getPlayerJoinMessage(){
        //获取进入服务器的广播消息
        return playerJoinMessage;
    }

}
