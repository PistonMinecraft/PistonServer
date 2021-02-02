package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.location.Location;

public class PlayerMoveEvent extends PlayerEvent {
    private  Location from;
    public PlayerMoveEvent(Location from, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        this.from = from;
    }

    /**
     * 返回玩家从哪个位置移动
     * @return 玩家从哪个位置移动
     */
    public Location getFrom() {
        return from;
    }
}
