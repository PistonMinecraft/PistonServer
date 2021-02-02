package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;

/**
 * 玩家死亡不会广播至此事件
 */
public class EntityDeathEvent extends EntityEvent {
    private Entity killerEntity;
    public EntityDeathEvent(Entity killerEntity,Entity triggerEntity, boolean isAsync) {
        super(triggerEntity, isAsync);
        this.killerEntity = killerEntity;
    }

    /**
     * 获取击杀实体的实体
     * @return 击杀实体的实体
     */
    public Entity getKillerEntity() {
        return killerEntity;
    }
}
