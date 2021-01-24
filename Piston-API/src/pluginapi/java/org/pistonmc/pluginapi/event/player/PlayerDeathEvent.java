package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerDeathEvent extends PlayerEvent {
    private String deathMessage;
    private final Entity killerEntity;
    public PlayerDeathEvent(PlayerEntity deathPlayer, boolean isAsync, Entity killerEntity, String deathMessage) {
        super(deathPlayer, isAsync);
        this.deathMessage = deathMessage;
        this.killerEntity = killerEntity;
    }

    /**
     * 设置死亡广播消息
     * @param deathMessage 死亡广播消息
     */
    public void setDeathMessage(String deathMessage){
        this.deathMessage = deathMessage;
    }

    /**
     * 获取死亡广播消息
     * @return 死亡广播消息
     */
    public String getDeathMessage(){
        return deathMessage;
    }

    /**
     * 获取击杀玩家的实体
     * @return 击杀玩家的实体
     */
    public Entity getKillerEntity(){
        return killerEntity;
    }
}
