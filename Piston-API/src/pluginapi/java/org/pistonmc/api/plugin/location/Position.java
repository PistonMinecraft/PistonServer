package org.pistonmc.api.plugin.location;

/**
 * Represents a position
 */
public interface Position {
    /**
     * Gets the X pos of this {@link Position}
     * @return the X pos of this {@link Position}
     */
    double x();

    /**
     * Gets the Y pos of this {@link Position}
     * @return the Y pos of this {@link Position}
     */
    double y();

    /**
     * Gets the Z pos of this {@link Position}
     * @return the Z pos of this {@link Position}
     */
    double z();
}