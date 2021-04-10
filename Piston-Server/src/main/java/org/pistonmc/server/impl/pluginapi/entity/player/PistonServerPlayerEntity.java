package org.pistonmc.server.impl.pluginapi.entity.player;

import net.minecraft.server.level.ServerPlayer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.pistonmc.api.plugin.entity.EntityType;

public class PistonServerPlayerEntity extends org.pistonmc.server.impl.pluginapi.entity.PistonEntity {
    public PistonServerPlayerEntity(ServerPlayer entity) {
        super(entity);
    }

    @Override
    public @NonNull EntityType getEntityType() {
        return EntityType.PLAYER;
    }
}