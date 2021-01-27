package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.world.World;

public class WorldCreatePortalEvent extends WorldEvent {
    public WorldCreatePortalEvent(World triggerWorld, boolean isAsync) {
        super(triggerWorld, isAsync);
    }
}
