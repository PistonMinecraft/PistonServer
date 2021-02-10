package org.pistonmc.pluginapi.entity;

import org.pistonmc.pluginapi.effect.Effect;
import org.pistonmc.pluginapi.location.Location;

import java.util.List;
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
    EntityType getEntityType();
    UUID getUUID();
    String getName();
    String getDisplayName();
    void setDisplayName(String displayName);
    void killEntity();
    double getHealth();
    void setHealth(double health);
    boolean hasPermission(String permission);
    Location getLocation();
    void setLocation(Location location);
    List<Effect> getEffects();
    void removeEffect();
}