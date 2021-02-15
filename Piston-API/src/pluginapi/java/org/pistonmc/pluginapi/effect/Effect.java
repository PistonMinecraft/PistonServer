package org.pistonmc.pluginapi.effect;

public interface Effect {
    EffectType getEffectType();
    short getEffectLevel();
    int remainTime();
}