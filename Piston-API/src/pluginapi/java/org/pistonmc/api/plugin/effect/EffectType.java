package org.pistonmc.api.plugin.effect;

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
    BAD_OMEN,
    MOD {
        private Effect specificEffect;

        @Override
        public void setSpecificEffect(Effect specificEffect) {
            this.specificEffect = specificEffect;
        }

        @Override
        public Effect getSpecificEffect() {
            return specificEffect;
        }
    },
    UNKNOWN;

    public void setSpecificEffect(Effect specificEffect) {
        throw new UnsupportedOperationException();
    }

    public Effect getSpecificEffect() {
        throw new UnsupportedOperationException();
    }
}
