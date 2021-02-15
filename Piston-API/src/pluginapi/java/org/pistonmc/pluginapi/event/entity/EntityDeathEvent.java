package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;

/**
 * 玩家死亡不会广播至此事件
 */
public class EntityDeathEvent extends EntityEvent {
    private final Entity killer;

    public EntityDeathEvent(Entity who, Entity killer) {
        super(who);
        this.killer = killer;
    }

    /**
     * 获取击杀实体的实体
     * @return 击杀实体的实体
     */
    public Entity getKiller() {
        return killer;
    }
}