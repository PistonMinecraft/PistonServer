package org.pistonmc.pluginapi.inventory;

public enum InventoryType {
    CHEST,
    ENDER_CHEST,
    TRAPPED_CHEST,
    SHULKER_BOX,
    CUSTOM_CHEST,
    BAG,
    ARMOR,
    MOD {
        private Inventory specificInventory;

        @Override
        public void setSpecificInventory(Inventory specificInventory) {
            this.specificInventory = specificInventory;
        }

        @Override
        public Inventory getSpecificInventory() {
            return specificInventory;
        }
    },
    UNKNOWN;

    public void setSpecificInventory(Inventory specificInventory) {
        throw new UnsupportedOperationException();
    }

    public Inventory getSpecificInventory() {
        throw new UnsupportedOperationException();
    }
}