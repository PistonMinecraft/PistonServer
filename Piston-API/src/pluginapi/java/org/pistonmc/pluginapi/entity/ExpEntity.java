package org.pistonmc.pluginapi.entity;

import org.pistonmc.pluginapi.entity.player.PlayerEntity;

public interface ExpEntity extends Entity {
    PlayerEntity getTargetPlayer();
    double getExpCount();
}