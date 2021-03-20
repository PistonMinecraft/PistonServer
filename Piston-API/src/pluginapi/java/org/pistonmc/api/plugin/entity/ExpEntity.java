package org.pistonmc.api.plugin.entity;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

public interface ExpEntity extends Entity {
    PlayerEntity getTargetPlayer();
    double getExpCount();
}