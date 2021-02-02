package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerFishEvent extends PlayerEvent {
    public PlayerFishEvent(PlayerEntity triggerPlayer) {
        super(triggerPlayer);
    }
}
