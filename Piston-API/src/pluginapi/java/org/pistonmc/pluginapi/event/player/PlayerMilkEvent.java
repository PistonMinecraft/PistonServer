package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.event.Cancelable;

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
