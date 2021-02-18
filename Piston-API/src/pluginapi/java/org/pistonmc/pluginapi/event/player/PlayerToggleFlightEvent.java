package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.player.PlayerEntity;

/**
 * TODO
 */
public class PlayerToggleFlightEvent extends PlayerEvent {
    public PlayerToggleFlightEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}