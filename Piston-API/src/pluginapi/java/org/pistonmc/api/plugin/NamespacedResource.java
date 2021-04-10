package org.pistonmc.api.plugin;

import lombok.AllArgsConstructor;
import manifold.ext.props.rt.api.val;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

@AllArgsConstructor
public class NamespacedResource {
    public static final String DEFAULT_NAMESPACE = "minecraft";
    final @val String namespace;
    final @val String path;

    public NamespacedResource(String fullNameOrName) {
        if(fullNameOrName.contains(":")) { // If it is a full name
            String[] s = fullNameOrName.split(":");
            this.namespace = s[0];
            this.path = s[1];
        } else { // If it is name only
            this.namespace = DEFAULT_NAMESPACE;
            this.path = fullNameOrName;
        }
    }

    public static NamespacedResource minecraft(String name) {
        return new NamespacedResource(DEFAULT_NAMESPACE, name);
    }

    @Override
    public String toString() {
        return namespace + ':' + path;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (!(o instanceof NamespacedResource)) return false;
        NamespacedResource that = (NamespacedResource) o;
        return namespace.equals(that.namespace) && path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, path);
    }
}