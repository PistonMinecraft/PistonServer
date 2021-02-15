package org.pistonmc.pluginapi.food;

public interface Food {
    FoodType getFoodType();
    int getFoodLevel();
    void setFoodLevel();
}