package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.location.Location;
/**
 *玩家实体移动不会通知到该事件
 */
public class EntityMoveEvent extends EntityEvent {
    private Location from;
    public EntityMoveEvent(Location from,Entity triggerEntity, boolean isAsync) {
        super(triggerEntity, isAsync);
        this.from = from;
    }
    /**
     * 返回实体从哪个位置移动
     * @return 实体从哪个位置移动
     */
    public Location getFrom() {
        return from;
    }
}
