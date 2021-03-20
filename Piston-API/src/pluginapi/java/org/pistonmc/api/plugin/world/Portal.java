package org.pistonmc.api.plugin.world;

import org.pistonmc.api.plugin.location.Location;

public interface Portal {
    PortalType getPortalType();

    Location getPortalLocation();

    Location getDestinationLocation();
}