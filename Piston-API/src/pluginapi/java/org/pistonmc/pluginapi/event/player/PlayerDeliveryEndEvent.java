package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerDeliveryEndEvent extends PlayerEvent {
    private boolean agreeDelivery;
    public PlayerDeliveryEndEvent(PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }
    /**
     * 设置是否允许玩家传送
     * 如果拒绝玩家传送玩家会在末地传送门一直不会传送至末地
     * @param deliverable
     */
    public void setDeliverable(boolean deliverable){
        this.agreeDelivery = deliverable;
    }
}
