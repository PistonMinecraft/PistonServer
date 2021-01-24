package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.MushroomEntity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerShearMushroomEvent extends PlayerEvent {
    private MushroomEntity mushroomEntity;
    private boolean agreeShearMushroom;
    public PlayerShearMushroomEvent(MushroomEntity mushroomEntity, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        this.mushroomEntity = mushroomEntity;
        agreeShearMushroom = true;
    }
    /**
     * 获取 将要被剪掉蘑菇的Mushroom实体
     * @return 将要被剪掉蘑菇的Mushroom实体
     */
    public MushroomEntity getMushroomEntity() {
        return mushroomEntity;
    }
    /**
     * 设置是否允许剪掉蘑菇
     * @param agreeShearMushroom
     */
    public void setShearable(boolean agreeShearMushroom) {
        this.agreeShearMushroom = agreeShearMushroom;
    }
    /**
     * 获取是否允许剪掉蘑菇
     * @return 是否允许剪掉蘑菇
     */
    public boolean isShearable(){
        return agreeShearMushroom;
    }
}
