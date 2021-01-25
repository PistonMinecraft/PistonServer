package org.pistonmc.pluginapi.block;

public enum BlockType {
    MOD_FORGE("minecraft:null"),
    MOD_PISTON("minecraft:null"),
    MOD_FABRIC("minecraft:null"),
    MOD_OTHER("minecraft:null"),
    AIR,
    GRASS;
    private BlockType(){

    }
    BlockType(String BlockID) {
    }
}
