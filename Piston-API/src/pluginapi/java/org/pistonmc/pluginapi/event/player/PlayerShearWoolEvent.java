package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.entity.SheepEntity;

public class PlayerShearWoolEvent extends PlayerEvent {
    private SheepEntity cutWoolSheep;
    private boolean agreeShearWool;
    public PlayerShearWoolEvent(SheepEntity cutWoolSheep, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        this.cutWoolSheep = cutWoolSheep;
        agreeShearWool = true;
    }

    /**
     * 返回被剪掉羊毛的羊的实体
     * @return 被剪掉羊毛的羊实体
     */
    public SheepEntity getCutWoolSheep() {
        return cutWoolSheep;
    }
    /**
     * 设置是否允许剪掉羊毛
     * @param agreeShearWool
     */
    public void setShearable(boolean agreeShearWool) {
        this.agreeShearWool = agreeShearWool;
    }
    public boolean isShearable(){
        return agreeShearWool;
    }
}
