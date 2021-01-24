package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

/**
 *  Cow/Mushroom 被挤奶的事件
 */
public class PlayerMilkEvent extends PlayerEvent{
    private Entity milkEntity;
    private boolean milkable;
    public PlayerMilkEvent(Entity milkEntity, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
    }

    /**
     * 返回被挤奶的Cow/Mushroom实体
     * @return  被挤奶的Cow/Mushroom实体
     */
    public Entity getMilkEntity() {
        return milkEntity;
    }
    /**
     * 返回是否允许挤奶
     * @return  是否允许挤奶
     */
    public boolean isMilkable() {
        return milkable;
    }

    /**
     * 设置是否允许挤奶
     * @param milkable
     */
    public void setMilkable(boolean milkable){
        this.milkable = milkable;
    }
}
