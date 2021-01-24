package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.entity.SheepEntity;

public class PlayerCutWoolEvent extends PlayerEvent{
    private SheepEntity cutWoolSheep;
    public PlayerCutWoolEvent(SheepEntity cutWoolSheep, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        this.cutWoolSheep = cutWoolSheep;
    }

    /**
     * 返回被剪掉羊毛的羊的实体
     * @return 被剪掉羊毛的羊实体
     */
    public SheepEntity getCutWoolSheep() {
        return cutWoolSheep;
    }
}
