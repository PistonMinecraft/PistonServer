package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerDeliveryInfernalEvent extends PlayerEvent{
    private boolean agreeDelivery;
    public PlayerDeliveryInfernalEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
    public boolean isAgreeDelivery(){
        return agreeDelivery;
    }
    public void setAgreeDelivery(boolean agreeDelivery){
        this.agreeDelivery = agreeDelivery;
    }
}
