package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.effect.Effect;
import org.pistonmc.api.plugin.entity.player.PlayerEntity;

public class PlayerGetEffectEvent extends PlayerEvent {
    private final Effect effect;

    public PlayerGetEffectEvent(PlayerEntity player, Effect effect) {
        super(player);
        this.effect = effect;
    }

    /**
     * 返回获得的药水效果
     * @return 获得的药水效果
     */
    public Effect getEffect() {
        return effect;
    }
}