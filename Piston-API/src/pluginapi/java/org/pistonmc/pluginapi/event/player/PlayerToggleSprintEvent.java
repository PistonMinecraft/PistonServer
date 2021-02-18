package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.player.PlayerEntity;

/**
 * TODO
 */
public class PlayerToggleSprintEvent extends PlayerEvent {
    public PlayerToggleSprintEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}