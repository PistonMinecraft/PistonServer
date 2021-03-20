package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.MushroomEntity;
import org.pistonmc.api.plugin.entity.player.PlayerEntity;
import org.pistonmc.api.common.event.Cancelable;

public class PlayerShearMushroomEvent extends PlayerEvent implements Cancelable {
    private MushroomEntity target;
    private boolean cancelled;

    public PlayerShearMushroomEvent(MushroomEntity target, PlayerEntity player) {
        super(player);
        this.target = target;
    }
    /**
     * 获取 将要被剪掉蘑菇的Mushroom实体
     * @return 将要被剪掉蘑菇的Mushroom实体
     */
    public MushroomEntity getMushroom() {
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