package org.pistonmc.api.plugin.food;

public interface Food {
    FoodType getFoodType();
    int getFoodLevel();
    void setFoodLevel();
}