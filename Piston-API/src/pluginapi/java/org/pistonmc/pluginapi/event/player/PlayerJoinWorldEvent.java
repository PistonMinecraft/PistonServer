package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.world.World;

public class PlayerJoinWorldEvent extends PlayerEvent{
    private World world;
    public PlayerJoinWorldEvent(PlayerEntity player, World world, boolean isAsync) {
        super(player, isAsync);
        this.world = world;
    }
    /**
     * 获取玩家进入的世界
     * @return 进入的世界
     */
    public World getWorld(){
        return world;
    }
}
