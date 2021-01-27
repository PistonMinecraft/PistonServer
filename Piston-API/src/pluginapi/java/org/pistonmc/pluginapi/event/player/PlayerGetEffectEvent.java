package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.effect.Effect;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerGetEffectEvent extends PlayerEvent {
    private Effect effect;
    public PlayerGetEffectEvent(Effect effect, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
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
