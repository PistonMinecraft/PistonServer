package org.pistonmc.api.plugin.entity.player;

import org.pistonmc.api.plugin.entity.LivingEntity;
import org.pistonmc.api.plugin.inventory.Inventory;

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