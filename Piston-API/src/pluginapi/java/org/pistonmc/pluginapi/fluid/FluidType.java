package org.pistonmc.pluginapi.fluid;

import org.pistonmc.pluginapi.entity.Entity;

public enum FluidType {
    /**
     * Water source
     */
    WATER,
    FLOWING_WATER,
    /**
     * Lava source
     */
    LAVA,
    FLOWING_LAVA,
    MOD {
        private Entity specificFluid;

        @Override
        public void setSpecificFluid(Entity specificFluid) {
            this.specificFluid = specificFluid;
        }

        @Override
        public Entity getSpecificFluid() {
            return specificFluid;
        }
    },
    UNKNOWN;

    public void setSpecificFluid(Entity specificFluid) {
        throw new UnsupportedOperationException();
    }

    public Entity getSpecificFluid() {
        throw new UnsupportedOperationException();
    }
}