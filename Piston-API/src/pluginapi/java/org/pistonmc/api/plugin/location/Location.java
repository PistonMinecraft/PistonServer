package org.pistonmc.api.plugin.location;

import org.pistonmc.api.plugin.block.Block;
import org.pistonmc.api.plugin.world.World;

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