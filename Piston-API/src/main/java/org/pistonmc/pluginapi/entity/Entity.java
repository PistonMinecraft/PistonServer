package org.pistonmc.pluginapi.entity;

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

}