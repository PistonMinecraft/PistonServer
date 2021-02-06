package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.world.WeatherType;
import org.pistonmc.pluginapi.world.World;

public class WorldWeatherChange extends WorldEvent {
    private WeatherType from;
    public WorldWeatherChange(WeatherType from, World triggerWorld, boolean isAsync) {
        super(triggerWorld, isAsync);
    }

    /**
     * 返回被切换的天气
     * @return 被切换的天气
     */
    public WeatherType getFrom() {
        return from;
    }
}
