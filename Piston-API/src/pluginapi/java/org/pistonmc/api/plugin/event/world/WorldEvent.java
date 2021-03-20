package org.pistonmc.api.plugin.event.world;

import org.pistonmc.api.common.event.Event;
import org.pistonmc.api.plugin.world.World;

public class WorldEvent extends Event {
    private final World world;

    public WorldEvent(World world) {
        super();
        this.world = world;
    }

    public WorldEvent(World world, boolean isAsync) {
        super(isAsync);
        this.world = world;
    }

    /**
     * 返回触发该事件的世界
     * @return 触发该事件的世界
     */
    public World getWorld() {
        return world;
    }
}