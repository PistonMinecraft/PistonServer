package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.event.Event;
import org.pistonmc.pluginapi.world.World;

public class WorldEvent extends Event {
    private World triggerWorld;
    public WorldEvent(World triggerWorld, boolean isAsync) {
        super(isAsync);
        this.triggerWorld = triggerWorld;
    }

    /**
     * 返回触发该事件的世界
     * @return 触发该事件的世界
     */
    public World getTriggerWorld() {
        return triggerWorld;
    }
}
