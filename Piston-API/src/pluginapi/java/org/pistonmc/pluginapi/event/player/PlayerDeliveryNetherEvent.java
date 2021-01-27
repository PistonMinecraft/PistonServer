package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerDeliveryNetherEvent extends PlayerEvent {
    private boolean agreeDelivery;
    public PlayerDeliveryNetherEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
    public boolean isAgreeDelivery(){
        return agreeDelivery;
    }

    /**
     * 设置是否允许玩家传送
     * 如果拒绝玩家传送玩家会在地狱门一直不会传送至地狱
     * @param deliverable
     */
    public void setDeliverable(boolean deliverable){
        this.agreeDelivery = deliverable;
    }
}
