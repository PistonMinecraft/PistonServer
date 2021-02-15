package org.pistonmc.pluginapi.event;

public interface Cancelable {
    /**
     * Returns whether this event is cancelled or not
     * @return if this event is cancelled
     */
    boolean isCancelled();

    /**
     * Sets whether this event is cancelled or not
     * @param cancelled if this event is cancelled
     */
    void setCancelled(boolean cancelled);
}