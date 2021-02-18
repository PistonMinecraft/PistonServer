package org.pistonmc.server.impl.pluginapi.entity.projectile;

import net.minecraft.world.entity.projectile.WitherSkull;

public class PistonWitherSkull {
    private final WitherSkull skull;

    public PistonWitherSkull(WitherSkull skull) {
        this.skull = skull;
    }

    public org.bukkit.entity.WitherSkull getBukkitImpl() {
        return new BukkitImpl();
    }

    private class BukkitImpl implements org.bukkit.entity.WitherSkull {
        @Override
        public void setCharged(boolean charged) {
            skull.setDangerous(charged);
        }

        @Override
        public boolean isCharged() {
            return skull.isDangerous();
        }
    }
}