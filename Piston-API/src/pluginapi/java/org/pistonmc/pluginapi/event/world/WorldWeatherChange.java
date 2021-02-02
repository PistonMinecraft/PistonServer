package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.world.Weathers;
import org.pistonmc.pluginapi.world.World;

public class WorldWeatherChange extends WorldEvent {
    private Weathers from;
    public WorldWeatherChange(Weathers from, World triggerWorld, boolean isAsync) {
        super(triggerWorld, isAsync);
    }

    /**
     * 返回被切换的天气
     * @return 被切换的天气
     */
    public Weathers getFrom() {
        return from;
    }
}
