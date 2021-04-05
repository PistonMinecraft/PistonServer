package org.pistonmc.server.impl.pluginapi.extensions.org.pistonmc.api.plugin.NamespacedResource;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import net.minecraft.resources.ResourceLocation;
import org.pistonmc.api.plugin.NamespacedResource;

@Extension
public class ConvertExt {
    public static ResourceLocation toNative(@This NamespacedResource toConvert) {
        return new ResourceLocation(toConvert.namespace, toConvert.path);
    }
}