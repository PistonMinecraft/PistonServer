package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.player.PlayerEntity;
import org.pistonmc.pluginapi.location.Location;

public class PlayerMoveEvent extends PlayerEvent {
    private final Location from;
    private final Location to;
    public PlayerMoveEvent(PlayerEntity player, Location from, Location to) {
        super(player);
        this.from = from;
        this.to = to;
    }

    /**
     * 返回玩家从哪个位置移动
     * @return 玩家从哪个位置移动
     */
    public Location getFrom() {
        return from;
    }

    /**
     * 返回玩家移动到哪个位置
     * @return 玩家移动到哪个位置
     */
    public Location getTo() {
        return to;
    }
}