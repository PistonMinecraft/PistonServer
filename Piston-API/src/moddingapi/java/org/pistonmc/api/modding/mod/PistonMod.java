package org.pistonmc.api.modding.mod;

public abstract class PistonMod {
    String modName;
    private PistonModManager pistonModManager;

    public void onPreLoad() {}

    public void onLoad() {}

    public void onMinecraftLoad() {}

    protected PistonModManager getPluginManager() {
        return pistonModManager;
    }

    public String getModName() { return modName; }
}
