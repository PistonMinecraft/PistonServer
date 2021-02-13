package org.pistonmc.pluginapi.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import org.pistonmc.pluginapi.effect.Effect;
import org.pistonmc.pluginapi.location.Location;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * 此接口表示一个{@code 实体}。
 * <br><br>
 * This interface represents an {@code Entity}.
 */
public interface Entity {
    /**
     * Returns true if this entity is in spectator mode.
     * @return true this entity is in spectator mode.
     */
    boolean isSpectator();
    /**
     * Eject all passengers if this entity is a vehicle.<br>
     * Stop riding if this entity is a passenger.
     */
    void unRide();

    /**
     * Returns the type of this entity
     * @return the type of this entity
     */
    @NotNull
    EntityType getEntityType();

    /**
     * Returns the id of this entity
     * @return the id of this entity
     */
    @Range(from = 1, to = Integer.MAX_VALUE)
    int getEntityId();

    /**
     * Returns the tags that added by /tag command
     * @return the tags of this entity
     */
    @NotNull
    Set<String> getTags();

    /**
     * Adds the tag to this entity
     * @param tag the tag to be added
     * @return true if the tag had been added successfully
     */
    boolean addTag(@Nullable String tag);

    /**
     * Removes the tag of this entity
     * @param tag the tag to be removed
     * @return true if the tag had been removed successfully
     */
    boolean removeTag(@Nullable String tag);

    /**
     * Kills this entity
     */
    void kill();

    /**
     * Removes this entity
     */
    void remove();

    /**
     * Sets the pose of this entity
     * @param pose the pose to be set
     */
    void setEntityPose(EntityPose pose);

    /**
     * Returns the pose of this entity
     * @return the pose of this entity
     */
    EntityPose getEntityPose();

    /**
     * Sets the position of this entity
     * @param x X pos
     * @param y Y pos
     * @param z Z pos
     */
    void setPos(double x, double y, double z);

    /**
     * Sets the portal cooldown time of this entity.
     * @param dimensionChangingDelay cooldown time
     */
    void setPortalCooldownTime(@Range(from = 0, to = Integer.MAX_VALUE) int dimensionChangingDelay);

    /**
     * Returns the portal cooldown time of this entity.
     * @return the portal cooldown time of this entity.
     */
    @Range(from = 0, to = Integer.MAX_VALUE)
    int getPortalCooldownTime();

    /**
     * Returns true if this entity is on portal cooldown
     * @return true if this entity is on portal cooldown
     */
    boolean isOnPortalCooldown();

    /**
     * Returns the ticks the entity will wait for before teleporting
     * @return the ticks the entity will wait for before teleporting. 0 for all entities, 1 for creative player, 80 for survival player
     */
    @Range(from = 0, to = Integer.MAX_VALUE)
    int getPortalWaitTime();

    /**
     * Sets the remaining ticks of this entity on fire<br>
     * <b>For creative players, remainingFireTicks is always 1 or less than 1, even if you set a larger value</b>
     * @param remainingFireTicks the remaining ticks of this entity on fire
     */
    void setRemainingFireTicks(int remainingFireTicks);

    /**
     * Returns the remaining ticks of this entity on fire
     * @return the remaining ticks of this entity on fire
     */
    int getRemainingFireTicks();

    /**
     * Clear the fire of this entity.
     */
    default void clearFire() {
        setRemainingFireTicks(0);
    }
    UUID getUUID();
    String getName();
    String getDisplayName();
    void setDisplayName(String displayName);
    double getHealth();
    void setHealth(double health);
    boolean hasPermission(String permission);
    Location getLocation();
    void setLocation(Location location);
    List<Effect> getEffects();
    void removeEffect();
}