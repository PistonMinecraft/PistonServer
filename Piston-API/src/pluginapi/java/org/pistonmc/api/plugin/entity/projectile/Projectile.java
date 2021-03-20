package org.pistonmc.api.plugin.entity.projectile;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.pistonmc.api.plugin.entity.Entity;

public interface Projectile extends Entity {
    void setOwner(@Nullable Entity entity);
    @Nullable Entity getOwner();
}