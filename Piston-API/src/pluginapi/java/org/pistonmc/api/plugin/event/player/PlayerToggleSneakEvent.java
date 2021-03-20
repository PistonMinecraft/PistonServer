package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

/**
 * TODO
 */
public class PlayerToggleSneakEvent extends PlayerEvent {
    public PlayerToggleSneakEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}