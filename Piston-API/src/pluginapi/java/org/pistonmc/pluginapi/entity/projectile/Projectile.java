package org.pistonmc.pluginapi.entity.projectile;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.pistonmc.pluginapi.entity.Entity;

public interface Projectile extends Entity {
    void setOwner(@Nullable Entity entity);
    @Nullable Entity getOwner();
}