package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

/**
 * TODO
 */
public class PlayerToggleSneakEvent extends PlayerEvent {
    public PlayerToggleSneakEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}
