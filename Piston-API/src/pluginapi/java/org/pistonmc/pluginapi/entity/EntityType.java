package org.pistonmc.pluginapi.entity;

public enum EntityType {
    MOD_FORGE("minecraft:null","null"),
    MOD_PISTON("minecraft:null","null"),
    MOD_FABRIC("minecraft:null","null"),
    MOD_OTHER("minecraft:null","null"),
    AREA_EFFECT_CLOUD,
    ARMOR_STAND,
    ARROW,
    CREEPER,
    FALL,
    ITEM;
    private EntityType() {
    }

    EntityType(String EntityID,String EntityName) {
    }
}