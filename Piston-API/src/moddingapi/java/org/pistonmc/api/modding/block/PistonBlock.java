package org.pistonmc.api.modding.block;

import org.pistonmc.api.modding.mod.PistonMod;
import org.pistonmc.api.modding.texture.Texture;

public abstract class PistonBlock {
    Texture texture;
    String BlockName;
    PistonMod registerMod;
    PistonBlock(Texture texture, String BlockName, PistonMod registerMod) {
        this.BlockName = BlockName;
        this.texture = texture;
        this.registerMod = registerMod;
    }

    public String getBlockName() {
        return BlockName;
    }

    public Texture getTexture() {
        return texture;
    }

    public PistonMod getRegisterMod() {
        return registerMod;
    }
}
