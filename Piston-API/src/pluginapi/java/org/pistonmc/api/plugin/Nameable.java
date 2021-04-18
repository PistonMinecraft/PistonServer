package org.pistonmc.api.plugin;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 表示某个有name, custom name并且可能有display name的东西
 * <br><br>
 * Represents something that have a name and a custom name, and may have a display name
 */
public interface Nameable {
    /**
     * Gets the name of this {@link Nameable}
     * @return the name of this {@link Nameable}
     */
    @NonNull
    Component getName();

    /**
     * Gets whether this {@link Nameable} has a custom name
     * @return if this {@link Nameable} has a custom name
     */
    default boolean hasCustomName() {
        return getCustomName() != null;
    }

    /**
     * Gets the display name of this {@link Nameable}. Default implementation delegates to {@link Nameable#getName()}
     * @return the name of this {@link Nameable}, if any. Defaults to {@link Nameable#getName()}
     */
    @NonNull
    default Component getDisplayName() {
        return getName();
    }

    /**
     * Gets the custom name of this {@link Nameable}
     * @return the custom name of this {@link Nameable}, if any
     */
    @Nullable
    default Component getCustomName() {
        return null;
    }
}