package org.pistonmc.pluginapi.effect;

import org.pistonmc.pluginapi.Types;

public enum EffectType implements Types.EffectType {
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
    BAD_OMEN,
    UNKNOWN;
    public enum ModEffectType implements Types.EffectType {
        FORGE,
        PISTON,
        FABRIC;
        private Effect specificEffect;
        public void setSpecificEffect(Effect specificEffect) {
            this.specificEffect = specificEffect;
        }
        public Effect getSpecificEffect() {
            return specificEffect;
        }
    }
}
