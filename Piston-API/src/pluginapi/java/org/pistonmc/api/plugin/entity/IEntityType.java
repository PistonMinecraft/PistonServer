package org.pistonmc.api.plugin.entity;

import manifold.ext.props.rt.api.val;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.pistonmc.api.plugin.NamespacedResource;
import org.pistonmc.api.plugin.Piston;
import org.pistonmc.api.plugin.ResourceHolder;

import java.util.Objects;

public interface IEntityType<T extends Entity> extends ResourceHolder {
    /**
     * The id of this type of entity
     */
    @val NamespacedResource id;

    default boolean canSerialize() {
        return Objects.requireNonNull(Piston.registryUtil).isEntityTypeCanSerialize(id);
    }

    /**
     * Gets whether this type of entity can be summoned by /summon command or a spawner
     * @return if this entity can be summoned by /summon command or a spawner
     */
    default boolean canSummon() {
        return Objects.requireNonNull(Piston.registryUtil).isEntityTypeCanSummon(id);
    }

    boolean fireImmune();

    boolean canSpawnFarFromPlayer();

    @val(annos = @NonNull) MobCategory category;

    @val(annos = @NonNull) String descriptionId;

    @val(annos = @NonNull) Component description;

    @val(annos = @NonNull) NamespacedResource defaultLootTable;

    @val float width;

    @val float height;

//    AABB getAABB(double d0, double d1, double d2) // TODO

//    boolean isBlockDangerous(BlockState blockstate) // TODO

//    EntityDimensions getDimensions() // TODO

    int clientTrackingRange();

    int updateInterval();

    default boolean trackDeltas() {
        return this != EntityType.PLAYER && this != EntityType.LLAMA_SPIT && this != EntityType.WITHER
                && this != EntityType.BAT && this != EntityType.ITEM_FRAME && this != EntityType.LEASH_KNOT
                && this != EntityType.PAINTING && this != EntityType.END_CRYSTAL && this != EntityType.EVOKER_FANGS;
    }

    @Override
    default NamespacedResource getResource() {
        return id;
    }
}