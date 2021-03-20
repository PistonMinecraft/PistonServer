package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

/**
 * TODO
 */
public class PlayerToggleSprintEvent extends PlayerEvent {
    public PlayerToggleSprintEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}