package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

/**
 * TODO
 */
public class PlayerToggleFlightEvent extends PlayerEvent {
    public PlayerToggleFlightEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}