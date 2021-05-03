package org.pistonmc.api.modding.location;


import org.pistonmc.api.modding.block.Block;

public interface Location {
    double getX();
    double getY();
    double getZ();
    void setX(double locationX);
    void setY(double locationY);
    void setZ(double locationZ);
    Block getBlock();
    void setBlock(Block block);
    //World getWorld();
}
