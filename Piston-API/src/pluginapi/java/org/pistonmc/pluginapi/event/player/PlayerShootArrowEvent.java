package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.ArrowEntity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

/**
 * 箭被射出
 */
public class PlayerShootArrowEvent extends PlayerEvent {
    private ArrowEntity arrowEntity;
    public PlayerShootArrowEvent(ArrowEntity arrow, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        arrowEntity = arrow;
    }
    /**
     * 被射出的箭的实体
     * @return 射出的箭的实体
     */
    public ArrowEntity getArrowEntity() {
        return arrowEntity;
    }
}
