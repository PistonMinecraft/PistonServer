package org.pistonmc.pluginapi.food;

import org.pistonmc.pluginapi.Types;

import java.util.function.Supplier;

public enum FoodType implements Types.FoodType {
    APPLE,
    BAKED_POTATO,
    BEEF,
    BEETROOT,
    BEETROOT_SOUP,
    BREAD,
    CARROT,
    CHICKEN,
    CHORUS_FRUIT,
    COD,
    COOKED_BEEF,
    COOKED_CHICKEN,
    COOKED_COD,
    COOKED_MUTTON,
    COOKED_PORKCHOP,
    COOKED_RABBIT,
    COOKED_SALMON,
    COOKIE,
    DRIED_KELP,
    ENCHANTED_GOLDEN_APPLE,
    GOLDEN_APPLE,
    GOLDEN_CARROT,
    HONEY_BOTTLE,
    MELON_SLICE,
    MUSHROOM_STEW,
    MUTTON,
    POISONOUS_POTATO,
    PORKCHOP,
    POTATO,
    PUFFERFISH,
    PUMPKIN_PIE,
    RABBIT,
    RABBIT_STEW,
    ROTTEN_FLESH,
    SALMON,
    SPIDER_EYE,
    SUSPICIOUS_STEW,
    SWEET_BERRIES,
    TROPICAL_FISH;
    public enum ModFoodType implements Types.FoodType {
        FORGE,
        PISTON,
        FABRIC,
        UNKNOWN;
        private Supplier<Food> specificFood;
        public void setSpecificItem(Supplier<Food> specificItem) {
            this.specificFood = specificFood;
        }
        public Food getSpecificItem() {
            return specificFood.get();
        }
    }
}
