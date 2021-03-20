package org.pistonmc.api.plugin.event.world;

import org.pistonmc.api.common.event.Cancelable;
import org.pistonmc.api.plugin.world.WeatherType;
import org.pistonmc.api.plugin.world.World;

public class WorldWeatherChange extends WorldEvent implements Cancelable {
    private final WeatherType changeTo;
    private boolean cancelled;

    public WorldWeatherChange(World triggerWorld, WeatherType changeTo) {
        super(triggerWorld);
        this.changeTo = changeTo;
    }

    /**
     * 返回要切换的天气
     * @return 要切换的天气
     */
    public WeatherType getChangeTo() {
        return changeTo;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}