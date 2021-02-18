package org.pistonmc.pluginapi.entity.player;

import org.pistonmc.pluginapi.entity.LivingEntity;
import org.pistonmc.pluginapi.inventory.Inventory;

public interface PlayerEntity extends LivingEntity {
    float getHunger();
    Inventory getInventory();
    void ban();
    void unBan();
    void banIP();
    String getIP();
    void unBanIP();
    float getExp();
    void setExp(float exp);
    Inventory getArmor();
}