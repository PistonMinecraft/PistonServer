package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.world.World;

public class WorldWeatherChange extends WorldEvent {
    public WorldWeatherChange(World triggerWorld, boolean isAsync) {
        super(triggerWorld, isAsync);
    }
}
