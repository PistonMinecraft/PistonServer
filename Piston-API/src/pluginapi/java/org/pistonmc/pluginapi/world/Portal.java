package org.pistonmc.pluginapi.world;

import org.pistonmc.pluginapi.location.Location;

public interface Portal {
    PortalType getPortalType();
    Location getPortalLocation();
    Location getDeliveryLocation();
}
