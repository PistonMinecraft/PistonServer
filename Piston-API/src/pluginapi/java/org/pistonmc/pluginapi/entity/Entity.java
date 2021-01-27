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
    UUID getUUID();
    String getName();
    String getDisplayName();
    void setDisplayName(String displayName);
    EntityType getEntityType();
    void killEntity();
    double getHealth();
    void setHealth(double health);
    //是否有权限 (所有实体都存在权限?)
    boolean hasPermission(String permission);
    Location getLocation();
    void setLocation(Location location);
    List<Effect> getEffects();
    void removeEffect();
}