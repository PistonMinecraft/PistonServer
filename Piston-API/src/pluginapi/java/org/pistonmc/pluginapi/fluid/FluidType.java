package org.pistonmc.pluginapi.fluid;

import org.pistonmc.pluginapi.Types;

import java.util.function.Supplier;

public enum FluidType implements Types.FluidType {
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
    UNKNOWN {public void setSpecificFluid(){}};
    public enum ModFluidType implements Types.FluidType {
        FORGE,
        PISTON,
        FABRIC,
        UNKNOWN;
        private Supplier<Fluid> specificFluid;
        public void setSpecificFluid(Supplier<Fluid> specificFluid) {
            this.specificFluid = specificFluid;
        }
        public Fluid getSpecificFluid() {
            return specificFluid.get();
        }
    }
}