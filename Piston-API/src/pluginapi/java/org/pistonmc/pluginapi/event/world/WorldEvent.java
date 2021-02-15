package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.event.Event;
import org.pistonmc.pluginapi.world.World;

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