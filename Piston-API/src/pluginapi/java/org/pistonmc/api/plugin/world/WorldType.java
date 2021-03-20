package org.pistonmc.api.plugin.world;

public enum WorldType {
    END,
    NETHER,
    OVERWORLD,
    MOD {
        private World specificWorld;

        @Override
        public void setSpecificWorld(World specificWorld) {
            this.specificWorld = specificWorld;
        }

        @Override
        public World getSpecificWorld() {
            return specificWorld;
        }
    },
    UNKNOWN;

    public void setSpecificWorld(World specificWorld) {
        throw new UnsupportedOperationException();
    }

    public World getSpecificWorld() {
        throw new UnsupportedOperationException();
    }
}