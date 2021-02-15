package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.entity.SheepEntity;
import org.pistonmc.pluginapi.event.Cancelable;

public class PlayerShearWoolEvent extends PlayerEvent implements Cancelable {
    private final SheepEntity target;
    private boolean cancelled;

    public PlayerShearWoolEvent(PlayerEntity triggerPlayer, SheepEntity target) {
        super(triggerPlayer);
        this.target = target;
    }

    /**
     * 返回被剪掉羊毛的羊的实体
     * @return 被剪掉羊毛的羊实体
     */
    public SheepEntity getSheep() {
        return target;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}