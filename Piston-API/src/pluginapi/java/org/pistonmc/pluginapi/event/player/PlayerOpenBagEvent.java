package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerOpenBagEvent extends PlayerEvent{
    public PlayerOpenBagEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
}
