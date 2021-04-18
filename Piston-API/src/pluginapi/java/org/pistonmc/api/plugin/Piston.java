package org.pistonmc.api.plugin;

import manifold.ext.props.rt.api.get;
import manifold.ext.props.rt.api.set;
import manifold.ext.props.rt.api.var;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.pistonmc.api.plugin.util.RegistryUtil;

public class Piston {
    @var @set(param = @NonNull) @get(annos = @Nullable) static @Nullable Server server;

    @var @set(param = @NonNull) @get(annos = @Nullable) static @Nullable RegistryUtil registryUtil;
}