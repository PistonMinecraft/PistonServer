package org.pistonmc.pluginapi.world;

import java.util.function.Supplier;

public enum WorldType {
    END,
    NETHER,
    OVERWORLD;
    public enum ModWorldType {
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
