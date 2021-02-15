package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.ArrowEntity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

/**
 * 箭被射出
 */
public class PlayerShootArrowEvent extends PlayerEvent {
    private final ArrowEntity arrow;

    public PlayerShootArrowEvent(PlayerEntity player, ArrowEntity arrow) {
        super(player);
        this.arrow = arrow;
    }

    /**
     * 被射出的箭的实体
     * @return 射出的箭的实体
     */
    public ArrowEntity getArrow() {
        return arrow;
    }
}