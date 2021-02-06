package org.pistonmc.pluginapi.world;

public interface World {
    String getWorldName();

    /**
     * 设置此世界的天气。
     * <br><br>
     * Set the weather of this world.
     * @param weather 要设置的天气<br><br>The weather to be set
     * @param ticks 持续的tick<br><br>Duration in ticks
     */
    void setWeather(WeatherType weather, int ticks);
}
