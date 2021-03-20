package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

/**
 * TODO
 */
public class PlayerExpChangeEvent extends PlayerEvent {
    public PlayerExpChangeEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}