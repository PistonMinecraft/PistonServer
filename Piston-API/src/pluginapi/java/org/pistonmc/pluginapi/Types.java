package org.pistonmc.pluginapi;

/**
 * Classes for making vanilla type and mod type enums compatible
 */
public interface Types {
    interface BlockType {}
    interface EffectType {}
    interface EntityType {}
    interface FluidType { }
    interface FoodType {}
    interface ItemType {}
    interface ResourceType {
        ResourceName getId();
    }
    interface SoundType extends ResourceType {}
    interface WorldType {}
}