package org.pistonmc.api.modding.entity.animal;

import org.pistonmc.api.modding.DyeColor;
import org.pistonmc.api.modding.entity.Shearable;

public interface PistonSheep extends PistonAnimal, Shearable {
    DyeColor getColor();

}
