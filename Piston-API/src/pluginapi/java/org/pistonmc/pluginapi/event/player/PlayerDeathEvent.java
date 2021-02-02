package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerDeathEvent extends PlayerEvent {
    private String deathMessage;
    private final Entity killer;
    private boolean keepInventory;
    public PlayerDeathEvent(PlayerEntity deathPlayer, boolean isAsync, Entity killer, String deathMessage) {
        super(deathPlayer, isAsync);
        this.deathMessage = deathMessage;
        this.killer = killer;
        keepInventory = false;
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
    /**
     * 设置是否保留物品
     * @param keepInventory 是否保留物品
     */
    public void setKeepInventory(boolean keepInventory) {
        this.keepInventory = keepInventory;
    }
    /**
     * 返回是否保存物品
     * @return 是否保存物品
     */
    public boolean isKeepInventory() {
        return keepInventory;
    }
}
