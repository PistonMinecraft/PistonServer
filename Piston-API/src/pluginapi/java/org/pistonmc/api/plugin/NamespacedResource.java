package org.pistonmc.api.plugin;

import lombok.AllArgsConstructor;
import manifold.ext.props.rt.api.val;
import net.kyori.adventure.key.Key;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

@AllArgsConstructor(onConstructor_ = @NonNull)
public class NamespacedResource implements Key {
    public static final String DEFAULT_NAMESPACE = "minecraft";
    final @val String namespace;
    final @val String path;

    public NamespacedResource(@NonNull String fullNameOrName) {
        if(fullNameOrName.contains(":")) { // If it is a full name
            String[] s = fullNameOrName.split(":");
            this.namespace = s[0];
            this.path = s[1];
        } else { // If it is name only
            this.namespace = DEFAULT_NAMESPACE;
            this.path = fullNameOrName;
        }
    }

    public static @NonNull NamespacedResource minecraft(String name) {
        return new NamespacedResource(DEFAULT_NAMESPACE, name);
    }

    @Override
    public @NonNull String toString() {
        return namespace + ':' + path;
    }

    @Override
    public @NonNull String namespace() {
        return namespace;
    }

    @Override
    public @NonNull String value() {
        return path;
    }

    @Override
    public @NonNull String asString() {
        return toString();
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