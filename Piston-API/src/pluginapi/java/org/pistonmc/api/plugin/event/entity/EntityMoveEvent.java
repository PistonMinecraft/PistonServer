package org.pistonmc.api.plugin.event.entity;

import manifold.ext.props.rt.api.val;
import org.pistonmc.api.plugin.entity.Entity;
import org.pistonmc.api.plugin.location.Position;

/**
 * 玩家实体移动不会通知到该事件
 */
public class EntityMoveEvent extends EntityEvent {
    /**
     * 返回实体从哪个位置移动
     * @return 实体从哪个位置移动
     */
    @val Position from;
    /**
     * 返回实体移动到哪个位置
     * @return 实体移动到哪个位置
     */
    @val Position to;

    public EntityMoveEvent(Entity entity, Position from, Position to) {
        super(entity);
        this.from = from;
        this.to = to;
    }
}