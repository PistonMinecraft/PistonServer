package org.pistonmc.api.plugin.effect;

public interface Effect {
    EffectType getEffectType();
    short getEffectLevel();
    int remainTime();
}