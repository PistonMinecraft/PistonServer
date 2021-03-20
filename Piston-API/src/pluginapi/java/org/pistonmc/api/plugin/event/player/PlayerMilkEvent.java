package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.Entity;
import org.pistonmc.api.plugin.entity.player.PlayerEntity;
import org.pistonmc.api.common.event.Cancelable;

/**
 *  Cow/Mushroom 被挤奶的事件
 */
public class PlayerMilkEvent extends PlayerEvent implements Cancelable {
    private final Entity target;
    private boolean cancelled;
    public PlayerMilkEvent(PlayerEntity player, Entity target, boolean isAsync) {
        super(player, isAsync);
        this.target = target;
    }

    /**
     * 返回被挤奶的Cow/Mushroom实体
     * @return  被挤奶的Cow/Mushroom实体
     */
    public Entity getTarget() {
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