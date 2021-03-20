package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.Entity;
import org.pistonmc.api.plugin.entity.player.PlayerEntity;

public class PlayerDeathEvent extends PlayerEvent {
    private String deathMessage;
    private final Entity killer;

    public PlayerDeathEvent(PlayerEntity player, Entity killer, String deathMessage) {
        super(player);
        this.deathMessage = deathMessage;
        this.killer = killer;
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
    public Entity getKiller(){
        return killer;
    }
}