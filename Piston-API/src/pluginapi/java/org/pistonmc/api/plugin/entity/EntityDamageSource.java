package org.pistonmc.api.plugin.entity;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class EntityDamageSource {
    public static final EntityDamageSource IN_FIRE = new EntityDamageSource("inFire");
    public static final EntityDamageSource LIGHTNING_BOLT = new EntityDamageSource("lightningBolt");
    public static final EntityDamageSource ON_FIRE = new EntityDamageSource("onFire");
    public static final EntityDamageSource LAVA = new EntityDamageSource("lava");
    public static final EntityDamageSource HOT_FLOOR = new EntityDamageSource("hotFloor");
    public static final EntityDamageSource IN_WALL = new EntityDamageSource("inWall");
    public static final EntityDamageSource CRAMMING = new EntityDamageSource("cramming");
    public static final EntityDamageSource DROWN = new EntityDamageSource("drown");
    public static final EntityDamageSource STARVE = new EntityDamageSource("starve");
    public static final EntityDamageSource CACTUS = new EntityDamageSource("cactus");
    public static final EntityDamageSource FALL = new EntityDamageSource("fall");
    public static final EntityDamageSource FLY_INTO_WALL = new EntityDamageSource("flyIntoWall");
    public static final EntityDamageSource OUT_OF_WORLD = new EntityDamageSource("outOfWorld");
    public static final EntityDamageSource GENERIC = new EntityDamageSource("generic");
    public static final EntityDamageSource MAGIC = new EntityDamageSource("magic");
    public static final EntityDamageSource WITHER = new EntityDamageSource("wither");
    public static final EntityDamageSource ANVIL = new EntityDamageSource("anvil");
    public static final EntityDamageSource FALLING_BLOCK = new EntityDamageSource("fallingBlock");
    public static final EntityDamageSource DRAGON_BREATH = new EntityDamageSource("dragonBreath");
    public static final EntityDamageSource DRY_OUT = new EntityDamageSource("dryout");
    public static final EntityDamageSource SWEET_BERRY_BUSH = new EntityDamageSource("sweetBerryBush");

    private final String id;

    public EntityDamageSource(@NonNull String id) {
        this.id = Objects.requireNonNull(id);
    }

    public @NonNull String getId() {
        return id;
    }
}