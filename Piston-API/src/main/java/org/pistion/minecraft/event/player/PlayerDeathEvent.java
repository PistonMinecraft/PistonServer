package org.pistion.minecraft.event.player;

import org.pistion.minecraft.entity.Entity;
import org.pistion.minecraft.entity.PlayerEntity;

public class PlayerDeathEvent extends PlayerEvent{
    //玩家死亡事件
    private String deathMessage;
    //死亡广播消息
    private Entity killerEntity;
    //击杀 玩家 的实体
    public PlayerDeathEvent(Entity killerEntity, PlayerEntity deathPlayer, String deathMessage,boolean isAsync) {
        super(deathPlayer, isAsync);
        this.deathMessage = deathMessage;
        this.killerEntity = killerEntity;
    }
    public void setDeathMessage(String deathMessage){
        //设置死亡广播消息
        this.deathMessage = deathMessage;
    }
    public String getDeathMessage(){
        //获取死亡广播消息
        return deathMessage;
    }
    public PlayerEntity getDeathPlayer(){
        //获取死亡的玩家实体
        return getPlayer();
    }
    public Entity getKillerEntity(){
        //获取击杀玩家的实体
        return killerEntity;
    }
}
