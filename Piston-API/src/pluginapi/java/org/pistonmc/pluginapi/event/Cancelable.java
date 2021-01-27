package org.pistonmc.pluginapi.event;

public interface Cancelable {
    boolean isCancelled();
    void setCancelled(boolean cancelled);
}
