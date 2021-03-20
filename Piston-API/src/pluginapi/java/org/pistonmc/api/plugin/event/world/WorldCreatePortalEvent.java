package org.pistonmc.api.plugin.event.world;

import org.pistonmc.api.plugin.world.Portal;
import org.pistonmc.api.plugin.world.World;

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