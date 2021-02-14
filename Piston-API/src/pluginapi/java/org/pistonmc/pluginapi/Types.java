package org.pistonmc.pluginapi;

/**
 * Classes for making vanilla type and mod type enums compatible
 */
public interface Types {
    interface BlockType {}
    interface EffectType {}
    interface FluidType { }
    interface FoodType {}
    interface EntityType {}
    interface ItemType {}
    interface WorldType {}
    interface SoundType {
        ResourceName getId();
    }
}