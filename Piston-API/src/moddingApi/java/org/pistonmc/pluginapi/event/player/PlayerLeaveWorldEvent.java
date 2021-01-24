package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.world.World;

public class PlayerLeaveWorldEvent extends PlayerEvent{
    private World world;
    public PlayerLeaveWorldEvent(PlayerEntity player, World world, boolean isAsync) {
        super(player, isAsync);
        this.world = world;
    }
    /**
     * 获取玩家离开的世界
     * @return 离开的世界
     */
    public World getWorld(){
        return world;
    }
}
