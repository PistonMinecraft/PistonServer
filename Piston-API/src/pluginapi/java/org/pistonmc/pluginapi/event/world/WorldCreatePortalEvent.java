package org.pistonmc.pluginapi.event.world;

import org.pistonmc.pluginapi.world.Portal;
import org.pistonmc.pluginapi.world.World;

public class WorldCreatePortalEvent extends WorldEvent {
    private final Portal portal;

    public WorldCreatePortalEvent(World world, Portal portal) {
        super(world);
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