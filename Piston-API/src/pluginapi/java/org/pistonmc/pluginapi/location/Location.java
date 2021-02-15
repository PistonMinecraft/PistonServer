package org.pistonmc.pluginapi.location;

import org.pistonmc.pluginapi.block.Block;
import org.pistonmc.pluginapi.world.World;

public interface Location {
    double getX();
    double getY();
    double getZ();
    void setX(double locationX);
    void setY(double locationY);
    void setZ(double locationZ);
    Block getBlock();
    void setBlock(Block block);
    World getWorld();
}