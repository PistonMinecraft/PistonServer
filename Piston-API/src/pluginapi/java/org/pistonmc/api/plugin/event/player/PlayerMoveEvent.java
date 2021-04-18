package org.pistonmc.api.plugin.event.player;

import manifold.ext.props.rt.api.val;
import org.pistonmc.api.plugin.entity.player.PlayerEntity;
import org.pistonmc.api.plugin.location.Position;

public class PlayerMoveEvent extends PlayerEvent {
    /**
     * 返回玩家从哪个位置移动
     * @return 玩家从哪个位置移动
     */
    @val Position from;

    /**
     * 返回玩家移动到哪个位置
     * @return 玩家移动到哪个位置
     */
    @val Position to;

    public PlayerMoveEvent(PlayerEntity player, Position from, Position to) {
        super(player);
        this.from = from;
        this.to = to;
    }
}