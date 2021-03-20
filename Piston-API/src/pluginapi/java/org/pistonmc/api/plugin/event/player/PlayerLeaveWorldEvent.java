package org.pistonmc.api.plugin.event.player;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;
import org.pistonmc.api.plugin.world.World;

public class PlayerLeaveWorldEvent extends PlayerEvent {
    private final World world;

    public PlayerLeaveWorldEvent(PlayerEntity player, World world, boolean async) {
        super(player, async);
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