package org.pistonmc.pluginapi.effect;

import java.util.function.Supplier;

public enum EffectType {
    MOVEMENT_SPEED,
    MOVEMENT_SLOWDOWN,
    DIG_SPEED,
    DIG_SLOWDOWN,
    DAMAGE_BOOST,
    HEAL,
    HARM,
    JUMP,
    CONFUSION,
    REGENERATION,
    DAMAGE_RESISTANCE,
    FIRE_RESISTANCE,
    WATER_BREATHING,
    INVISIBILITY,
    BLINDNESS,
    NIGHT_VISION,
    HUNGER,
    WEAKNESS,
    POISON,
    WITHER,
    HEALTH_BOOST,
    ABSORPTION,
    SATURATION,
    GLOWING,
    LEVITATION,
    LUCK,
    UNLUCK,
    SLOW_FALLING,
    CONDUIT_POWER,
    DOLPHINS_GRACE,
    BAD_OMEN;
    public enum ModEffectType {
        FORGE,
        PISTON,
        FABRIC,
        UNKNOWN;
        private Supplier<Effect> specificEffect;
        public void setSpecificEffect(Supplier<Effect> specificEffect) {
            this.specificEffect = specificEffect;
        }
        public Effect getSpecificEffect() {
            return specificEffect.get();
        }
    }
}
