package org.pistonmc.api.plugin;

import manifold.ext.props.rt.api.val;

@FunctionalInterface
public interface ResourceHolder {
    @val NamespacedResource resource;
}