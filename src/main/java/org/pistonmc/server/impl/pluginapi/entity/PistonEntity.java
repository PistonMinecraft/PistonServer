/*
 * PistonServer. A high performance, multi-API support Minecraft server.
 * Copyright (C) 2019-2021 PistonMC Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.pistonmc.server.impl.pluginapi.entity;

import net.kyori.adventure.text.Component;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public abstract class PistonEntity /*implements org.pistonmc.api.plugin.entity.Entity*/ {
    protected final Entity entity;
    public PistonEntity(Entity entity) {
        this.entity = entity;
    }

    // TODO: Coming soon
    /*@Override
    public boolean isSpectator() {
        return entity.isSpectator();
    }

    @Override
    public void unRide() {
        entity.unRide();
    }

    @Override
    public int getEntityId() {
        return entity.getId();
    }

    @Override
    @NonNull
    public Set<String> getTags() {
        return Collections.unmodifiableSet(entity.getTags());
    }

    @Override
    public boolean addTag(@NonNull String tag) {
        return entity.addTag(tag);
    }

    @Override
    public boolean removeTag(@NonNull String tag) {
        return entity.removeTag(tag);
    }

    @Override
    public void kill() {
        entity.kill();
    }

    @Override
    public void remove() {
        entity.remove();
    }

    @Override
    public void setEntityPose(EntityPose pose) {
        entity.setPose(Pose.values()[pose.ordinal()]);
    }

    @Override
    public EntityPose getEntityPose() {
        return EntityPose.values()[entity.getPose().ordinal()];
    }

    @Override
    public void setPos(double x, double y, double z) {
        entity.setPos(x, y, z);
    }

    @Override
    public void setPortalCooldownTime(int dimensionChangingDelay) {
        entity.setDimensionChangingDelay(dimensionChangingDelay);
    }

    @Override
    public int getPortalCooldownTime() {
        int i = entity.getCustomDimensionChangingDelay();
        return i < 0 ? entity.getDimensionChangingDelay() : i;
    }

    @Override
    public boolean isOnPortalCooldown() {
        return entity.isOnPortalCooldown();
    }

    @Override
    public void setPortalWaitTime(@IntRange(from = 0, to = Integer.MAX_VALUE) int portalWaitTime) {
        entity.setPortalWaitTime(portalWaitTime);
    }

    @Override
    public int getPortalWaitTime() {
        int i = entity.getCustomPortalWaitTime();
        return i < 0 ? entity.getPortalWaitTime() : i;
    }

    @Override
    public void setRemainingFireTicks(int remainingFireTicks) {
        entity.setRemainingFireTicks(remainingFireTicks);
    }

    @Override
    public int getRemainingFireTicks() {
        return entity.getRemainingFireTicks();
    }

    @Override
    public boolean isOnGround() {
        return entity.isOnGround();
    }

    @Override
    public void playSound(@NonNull Sound sound, float volume, float pitch) {
        entity.playSound(Registry.SOUND_EVENT.get(sound.getId().toNative()), volume, pitch);
    }

    @Override
    public boolean isSilent() {
        return entity.isSilent();
    }

    @Override
    public void setSilent(boolean silent) {
        entity.setSilent(silent);
    }

    @Override
    public boolean isNoGravity() {
        return entity.isNoGravity();
    }

    @Override
    public void setNoGravity(boolean noGravity) {
        entity.setNoGravity(noGravity);
    }

    @Override
    public boolean isFireImmune() {
        return entity.fireImmune();
    }

    @Override
    public boolean isInWater() {
        return entity.isInWater();
    }

    @Override
    public boolean isInRain() {
        return entity.isInRain();
    }

    @Override
    public boolean isInBubbleColumn() {
        return entity.isInBubbleColumn();
    }

    @Override
    public boolean isEyeInFluid(@NonNull FluidType fluid) {
        if(fluid == null) return false;
        Tag<Fluid> mcTagFluid = null;
        switch(fluid) {
            case WATER:
            case FLOWING_WATER:
                mcTagFluid = FluidTags.WATER;
                break;
            case LAVA:
            case FLOWING_LAVA:
                mcTagFluid = FluidTags.LAVA;
                break;
        }
        return entity.isEyeInFluid(mcTagFluid);
    }

    @Override
    public boolean isInLava() {
        return entity.isInLava();
    }

    @Override
    public boolean hurt(@NonNull EntityDamageSource damageSource, float hurtDamage) {
        DamageSource ds;
        return entity.hurt(ds, hurtDamage);
    }

    @Override
    public UUID getUUID() {
        return entity.getUUID();
    }

    @Override
    public String getName() {
        return entity.getName().getString();
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public void setDisplayName(String displayName) {

    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void setHealth(double health) {

    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void setLocation(Location location) {

    }

    @Override
    public List<Effect> getEffects() {
        return null;
    }

    @Override
    public void removeEffect() {

    }*/

    public class BukkitImpl implements org.bukkit.entity.Entity {
        private BukkitImpl() {}

        @NotNull
        @Override
        public org.bukkit.Location getLocation() {
            return null;
        }

        @Nullable
        @Override
        public org.bukkit.Location getLocation(@Nullable org.bukkit.Location loc) {
            return null;
        }

        @Override
        public void setVelocity(@NotNull org.bukkit.util.Vector velocity) {

        }

        @NotNull
        @Override
        public org.bukkit.util.Vector getVelocity() {
            return null;
        }

        @Override
        public double getHeight() {
            return 0;
        }

        @Override
        public double getWidth() {
            return 0;
        }

        @NotNull
        @Override
        public org.bukkit.util.BoundingBox getBoundingBox() {
            return null;
        }

        @Override
        public boolean isOnGround() {
            return false;
        }

        @Override
        public boolean isInWater() {
            return false;
        }

        @NotNull
        @Override
        public org.bukkit.World getWorld() {
            return null;
        }

        @Override
        public void setRotation(float yaw, float pitch) {

        }

        @Override
        public boolean teleport(@NotNull org.bukkit.Location location) {
            return false;
        }

        @Override
        public boolean teleport(@NotNull org.bukkit.Location location, @NotNull org.bukkit.event.player.PlayerTeleportEvent.TeleportCause cause) {
            return false;
        }

        @Override
        public boolean teleport(@NotNull org.bukkit.entity.Entity destination) {
            return false;
        }

        @Override
        public boolean teleport(@NotNull org.bukkit.entity.Entity destination, @NotNull org.bukkit.event.player.PlayerTeleportEvent.TeleportCause cause) {
            return false;
        }

        @NotNull
        @Override
        public List<org.bukkit.entity.Entity> getNearbyEntities(double x, double y, double z) {
            return null;
        }

        @Override
        public int getEntityId() {
            return 0;
        }

        @Override
        public int getFireTicks() {
            return 0;
        }

        @Override
        public int getMaxFireTicks() {
            return 0;
        }

        @Override
        public void setFireTicks(int ticks) {

        }

        @Override
        public void remove() {

        }

        @Override
        public boolean isDead() {
            return false;
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public void sendMessage(@NotNull String message) {

        }

        @Override
        public void sendMessage(@NotNull String[] messages) {

        }

        @Override
        public void sendMessage(@Nullable UUID sender, @NotNull String message) {

        }

        @Override
        public void sendMessage(@Nullable UUID sender, @NotNull String[] messages) {

        }

        @NotNull
        @Override
        public org.bukkit.Server getServer() {
            return null;
        }

        @NotNull
        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isPersistent() {
            return false;
        }

        @Override
        public void setPersistent(boolean persistent) {

        }

        @Nullable
        @Override
        public org.bukkit.entity.Entity getPassenger() {
            return null;
        }

        @Override
        public boolean setPassenger(@NotNull org.bukkit.entity.Entity passenger) {
            return false;
        }

        @NotNull
        @Override
        public List<org.bukkit.entity.Entity> getPassengers() {
            return null;
        }

        @Override
        public boolean addPassenger(@NotNull org.bukkit.entity.Entity passenger) {
            return false;
        }

        @Override
        public boolean removePassenger(@NotNull org.bukkit.entity.Entity passenger) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean eject() {
            return false;
        }

        @Override
        public float getFallDistance() {
            return 0;
        }

        @Override
        public void setFallDistance(float distance) {

        }

        @Override
        public void setLastDamageCause(@Nullable org.bukkit.event.entity.EntityDamageEvent event) {

        }

        @Nullable
        @Override
        public org.bukkit.event.entity.EntityDamageEvent getLastDamageCause() {
            return null;
        }

        @NotNull
        @Override
        public UUID getUniqueId() {
            return null;
        }

        @Override
        public int getTicksLived() {
            return 0;
        }

        @Override
        public void setTicksLived(int value) {

        }

        @Override
        public void playEffect(@NotNull org.bukkit.EntityEffect type) {

        }

        @NotNull
        @Override
        public org.bukkit.entity.EntityType getType() {
            return null;
        }

        @Override
        public boolean isInsideVehicle() {
            return false;
        }

        @Override
        public boolean leaveVehicle() {
            return false;
        }

        @Nullable
        @Override
        public org.bukkit.entity.Entity getVehicle() {
            return null;
        }

        @Override
        public void setCustomNameVisible(boolean flag) {

        }

        @Override
        public boolean isCustomNameVisible() {
            return false;
        }

        @Override
        public void setGlowing(boolean flag) {

        }

        @Override
        public boolean isGlowing() {
            return false;
        }

        @Override
        public void setInvulnerable(boolean flag) {

        }

        @Override
        public boolean isInvulnerable() {
            return false;
        }

        @Override
        public boolean isSilent() {
            return false;
        }

        @Override
        public void setSilent(boolean flag) {

        }

        @Override
        public boolean hasGravity() {
            return false;
        }

        @Override
        public void setGravity(boolean gravity) {

        }

        @Override
        public int getPortalCooldown() {
            return 0;
        }

        @Override
        public void setPortalCooldown(int cooldown) {

        }

        @NotNull
        @Override
        public Set<String> getScoreboardTags() {
            return null;
        }

        @Override
        public boolean addScoreboardTag(@NotNull String tag) {
            return false;
        }

        @Override
        public boolean removeScoreboardTag(@NotNull String tag) {
            return false;
        }

        @NotNull
        @Override
        public org.bukkit.block.PistonMoveReaction getPistonMoveReaction() {
            return null;
        }

        @NotNull
        @Override
        public org.bukkit.block.BlockFace getFacing() {
            return null;
        }

        @NotNull
        @Override
        public org.bukkit.entity.Pose getPose() {
            return null;
        }

        @NotNull
        @Override
        public Spigot spigot() {
            return null;
        }

        @Nullable
        @Override
        public org.bukkit.Location getOrigin() {
            return null;
        }

        @Override
        public boolean fromMobSpawner() {
            return false;
        }

        @NotNull
        @Override
        public org.bukkit.Chunk getChunk() {
            return null;
        }

        @NotNull
        @Override
        public org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason getEntitySpawnReason() {
            return null;
        }

        @Override
        public boolean isInRain() {
            return false;
        }

        @Override
        public boolean isInBubbleColumn() {
            return false;
        }

        @Override
        public boolean isInWaterOrRain() {
            return false;
        }

        @Override
        public boolean isInWaterOrBubbleColumn() {
            return false;
        }

        @Override
        public boolean isInWaterOrRainOrBubbleColumn() {
            return false;
        }

        @Override
        public boolean isInLava() {
            return false;
        }

        @Override
        public boolean isTicking() {
            return false;
        }

        @Override
        public @Nullable Component customName() {
            return null;
        }

        @Override
        public void customName(@Nullable Component customName) {

        }

        @Nullable
        @Override
        public String getCustomName() {
            return null;
        }

        @Override
        public void setCustomName(@Nullable String name) {

        }

        @Override
        public void setMetadata(@NotNull String metadataKey, @NotNull org.bukkit.metadata.MetadataValue newMetadataValue) {

        }

        @NotNull
        @Override
        public List<org.bukkit.metadata.MetadataValue> getMetadata(@NotNull String metadataKey) {
            return null;
        }

        @Override
        public boolean hasMetadata(@NotNull String metadataKey) {
            return false;
        }

        @Override
        public void removeMetadata(@NotNull String metadataKey, @NotNull org.bukkit.plugin.Plugin owningPlugin) {

        }

        @Override
        public boolean isPermissionSet(@NotNull String name) {
            return false;
        }

        @Override
        public boolean isPermissionSet(@NotNull org.bukkit.permissions.Permission perm) {
            return false;
        }

        @Override
        public boolean hasPermission(@NotNull String name) {
            return false;
        }

        @Override
        public boolean hasPermission(@NotNull org.bukkit.permissions.Permission perm) {
            return false;
        }

        @NotNull
        @Override
        public org.bukkit.permissions.PermissionAttachment addAttachment(@NotNull org.bukkit.plugin.Plugin plugin, @NotNull String name, boolean value) {
            return null;
        }

        @NotNull
        @Override
        public org.bukkit.permissions.PermissionAttachment addAttachment(@NotNull org.bukkit.plugin.Plugin plugin) {
            return null;
        }

        @Nullable
        @Override
        public org.bukkit.permissions.PermissionAttachment addAttachment(@NotNull org.bukkit.plugin.Plugin plugin, @NotNull String name, boolean value, int ticks) {
            return null;
        }

        @Nullable
        @Override
        public org.bukkit.permissions.PermissionAttachment addAttachment(@NotNull org.bukkit.plugin.Plugin plugin, int ticks) {
            return null;
        }

        @Override
        public void removeAttachment(@NotNull org.bukkit.permissions.PermissionAttachment attachment) {

        }

        @Override
        public void recalculatePermissions() {

        }

        @NotNull
        @Override
        public Set<org.bukkit.permissions.PermissionAttachmentInfo> getEffectivePermissions() {
            return null;
        }

        @Override
        public boolean isOp() {
            return false;
        }

        @Override
        public void setOp(boolean value) {

        }

        @NotNull
        @Override
        public org.bukkit.persistence.PersistentDataContainer getPersistentDataContainer() {
            return null;
        }
    }
}
