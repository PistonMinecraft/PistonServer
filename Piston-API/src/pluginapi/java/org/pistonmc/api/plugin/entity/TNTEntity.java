package org.pistonmc.api.plugin.entity;

public interface TNTEntity extends Entity {
    double getBlastTime();
    void setBlastTime(double blastTime);
}