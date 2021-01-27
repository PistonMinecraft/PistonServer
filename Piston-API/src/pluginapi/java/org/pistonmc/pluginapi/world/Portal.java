package org.pistonmc.pluginapi.world;

import org.pistonmc.pluginapi.util.PortalRect;

public interface Portal {
    PortalType getPortalType();
    PortalRect getPortalRect();
}
