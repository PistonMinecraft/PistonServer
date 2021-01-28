package org.pistonmc.pluginapi.world;

import org.pistonmc.pluginapi.Types;

import java.util.function.Supplier;

public enum WorldType implements Types.WorldType {
    END,
    NETHER,
    OVERWORLD;
    public enum ModWorldType implements Types.WorldType {
        FORGE,
        PISTON,
        FABRIC,
        UNKNOWN;
        private Supplier<World> specificWorld;
        public void setSpecificWorld(Supplier<World> specificWorld) {
            this.specificWorld = specificWorld;
        }
        public World getSpecificWorld() {
            return specificWorld.get();
        }
    }
}
