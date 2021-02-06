package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.location.Location;

/**
 * 玩家实体移动不会通知到该事件
 */
public class EntityMoveEvent extends EntityEvent {
    private final Location from;
    private final Location to;
    public EntityMoveEvent(Entity entity, boolean async, Location from, Location to) {
        super(entity, async);
        this.from = from;
        this.to = to;
    }
    /**
     * 返回实体从哪个位置移动
     * @return 实体从哪个位置移动
     */
    public Location getFrom() {
        return from;
    }

    /**
     * 返回实体移动到哪个位置
     * @return 实体移动到哪个位置
     */
    public Location getTo() {
        return to;
    }
}
