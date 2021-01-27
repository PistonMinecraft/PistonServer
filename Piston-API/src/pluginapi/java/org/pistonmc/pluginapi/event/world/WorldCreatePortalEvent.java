package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.world.Portal;
import org.pistonmc.pluginapi.world.World;

public class WorldCreatePortalEvent extends WorldEvent {
    private Portal portal;
    public WorldCreatePortalEvent(Portal portal, World triggerWorld, boolean isAsync) {
        super(triggerWorld, isAsync);
        this.portal = portal;
    }
    /**
     * 返回传送门
     * @return 传送门
     */
    public Portal getPortal() {
        return portal;
    }
}