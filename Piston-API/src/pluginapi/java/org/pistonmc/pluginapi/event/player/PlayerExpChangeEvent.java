package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

/**
 * TODO
 */
public class PlayerExpChangeEvent extends PlayerEvent {
    public PlayerExpChangeEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}
