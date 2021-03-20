package org.pistonmc.server.impl.pluginapi.entity.player;

import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.block.TargetBlockInfo;
import com.destroystokyo.paper.entity.TargetEntityInfo;
import com.destroystokyo.paper.profile.PlayerProfile;
import net.md_5.bungee.api.chat.BaseComponent;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pistonmc.api.plugin.entity.player.ActualPlayerEntity;

import java.net.InetSocketAddress;
import java.util.*;

public class PistonActualPlayerEntity extends PistonPlayerEntity implements ActualPlayerEntity {
    private final ServerPlayer player;

    public PistonActualPlayerEntity(ServerPlayer player) {
        this.player = player;
    }

    public org.bukkit.entity.Player getBukkitImpl() {
        return new BukkitImpl();
    }

    @Override
    public UUID getUUID() {
        return player.getUUID();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public void setDisplayName(String displayName) {

    }

    @Override
    public org.pistonmc.api.plugin.entity.EntityType getEntityType() {
        return org.pistonmc.api.plugin.entity.EntityType.PLAYER;
    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void setHealth(double health) {

    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    @Override
    public org.pistonmc.api.plugin.location.Location getLocation() {
        return null;
    }

    @Override
    public void setLocation(org.pistonmc.api.plugin.location.Location location) {

    }

    @Override
    public List<org.pistonmc.api.plugin.effect.Effect> getEffects() {
        return null;
    }

    @Override
    public void removeEffect() {

    }

    @Override
    public float getHunger() {
        return 0;
    }

    @Override
    public org.pistonmc.api.plugin.inventory.Inventory getInventory() {
        return null;
    }

    @Override
    public void ban() {

    }

    @Override
    public void unBan() {

    }

    @Override
    public void banIP() {

    }

    @Override
    public String getIP() {
        return null;
    }

    @Override
    public void unBanIP() {

    }

    @Override
    public float getExp() {
        return 0;
    }

    @Override
    public void setExp(float exp) {

    }

    @Override
    public org.pistonmc.api.plugin.inventory.Inventory getArmor() {
        return null;
    }

    private class BukkitImpl implements org.bukkit.entity.Player {
        @NotNull
        @Override
        public String getDisplayName() {
            return PistonActualPlayerEntity.this.getDisplayName();
        }

        @Override
        public void setDisplayName(@Nullable String name) {
            PistonActualPlayerEntity.this.setDisplayName(name);
        }

        @NotNull
        @Override
        public String getPlayerListName() {
            return null;
        }

        @Override
        public void setPlayerListName(@Nullable String name) {

        }

        @Nullable
        @Override
        public String getPlayerListHeader() {
            return null;
        }

        @Nullable
        @Override
        public String getPlayerListFooter() {
            return null;
        }

        @Override
        public void setPlayerListHeader(@Nullable String header) {

        }

        @Override
        public void setPlayerListFooter(@Nullable String footer) {

        }

        @Override
        public void setPlayerListHeaderFooter(@Nullable String header, @Nullable String footer) {

        }

        @Override
        public void setCompassTarget(@NotNull Location loc) {

        }

        @NotNull
        @Override
        public Location getCompassTarget() {
            return null;
        }

        @Nullable
        @Override
        public InetSocketAddress getAddress() {
            return null;
        }

        @Override
        public int getProtocolVersion() {
            return 0;
        }

        @Nullable
        @Override
        public InetSocketAddress getVirtualHost() {
            return null;
        }

        @Override
        public boolean isConversing() {
            return false;
        }

        @Override
        public void acceptConversationInput(@NotNull String input) {

        }

        @Override
        public boolean beginConversation(@NotNull Conversation conversation) {
            return false;
        }

        @Override
        public void abandonConversation(@NotNull Conversation conversation) {

        }

        @Override
        public void abandonConversation(@NotNull Conversation conversation, @NotNull ConversationAbandonedEvent details) {

        }

        @Override
        public void sendRawMessage(@NotNull String message) {

        }

        @Override
        public void sendRawMessage(@Nullable UUID sender, @NotNull String message) {

        }

        @Override
        public void kickPlayer(@Nullable String message) {

        }

        @Override
        public void chat(@NotNull String msg) {

        }

        @Override
        public boolean performCommand(@NotNull String command) {
            return false;
        }

        @NotNull
        @Override
        public Location getLocation() {
            return null;
        }

        @Nullable
        @Override
        public Location getLocation(@Nullable Location loc) {
            return null;
        }

        @Override
        public void setVelocity(@NotNull Vector velocity) {

        }

        @NotNull
        @Override
        public Vector getVelocity() {
            return null;
        }

        @Override
        public double getHeight() {
            return 0;
        }

        @Override
        public double getWidth() {
            return 0;
        }

        @NotNull
        @Override
        public BoundingBox getBoundingBox() {
            return null;
        }

        @Override
        public boolean isOnGround() {
            return false;
        }

        @Override
        public boolean isInWater() {
            return false;
        }

        @NotNull
        @Override
        public World getWorld() {
            return null;
        }

        @Override
        public void setRotation(float yaw, float pitch) {

        }

        @Override
        public boolean teleport(@NotNull Location location) {
            return false;
        }

        @Override
        public boolean teleport(@NotNull Location location, @NotNull PlayerTeleportEvent.TeleportCause cause) {
            return false;
        }

        @Override
        public boolean teleport(@NotNull Entity destination) {
            return false;
        }

        @Override
        public boolean teleport(@NotNull Entity destination, @NotNull PlayerTeleportEvent.TeleportCause cause) {
            return false;
        }

        @NotNull
        @Override
        public List<Entity> getNearbyEntities(double x, double y, double z) {
            return null;
        }

        @Override
        public int getEntityId() {
            return 0;
        }

        @Override
        public int getFireTicks() {
            return 0;
        }

        @Override
        public int getMaxFireTicks() {
            return 0;
        }

        @Override
        public void setFireTicks(int ticks) {

        }

        @Override
        public void remove() {

        }

        @Override
        public boolean isDead() {
            return false;
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public void sendMessage(@NotNull String message) {

        }

        @Override
        public void sendMessage(@NotNull String[] messages) {

        }

        @Override
        public void sendMessage(@Nullable UUID sender, @NotNull String message) {

        }

        @Override
        public void sendMessage(@Nullable UUID sender, @NotNull String[] messages) {

        }

        @NotNull
        @Override
        public Server getServer() {
            return null;
        }

        @Override
        public boolean isPersistent() {
            return false;
        }

        @Override
        public void setPersistent(boolean persistent) {

        }

        @Nullable
        @Override
        public Entity getPassenger() {
            return null;
        }

        @Override
        public boolean setPassenger(@NotNull Entity passenger) {
            return false;
        }

        @NotNull
        @Override
        public List<Entity> getPassengers() {
            return null;
        }

        @Override
        public boolean addPassenger(@NotNull Entity passenger) {
            return false;
        }

        @Override
        public boolean removePassenger(@NotNull Entity passenger) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean eject() {
            return false;
        }

        @Override
        public float getFallDistance() {
            return 0;
        }

        @Override
        public void setFallDistance(float distance) {

        }

        @Override
        public void setLastDamageCause(@Nullable EntityDamageEvent event) {

        }

        @Nullable
        @Override
        public EntityDamageEvent getLastDamageCause() {
            return null;
        }

        @NotNull
        @Override
        public UUID getUniqueId() {
            return null;
        }

        @Override
        public int getTicksLived() {
            return 0;
        }

        @Override
        public void setTicksLived(int value) {

        }

        @Override
        public void playEffect(@NotNull EntityEffect type) {

        }

        @NotNull
        @Override
        public EntityType getType() {
            return null;
        }

        @Override
        public boolean isInsideVehicle() {
            return false;
        }

        @Override
        public boolean leaveVehicle() {
            return false;
        }

        @Nullable
        @Override
        public Entity getVehicle() {
            return null;
        }

        @Override
        public void setCustomNameVisible(boolean flag) {

        }

        @Override
        public boolean isCustomNameVisible() {
            return false;
        }

        @Override
        public void setGlowing(boolean flag) {

        }

        @Override
        public boolean isGlowing() {
            return false;
        }

        @Override
        public void setInvulnerable(boolean flag) {

        }

        @Override
        public boolean isInvulnerable() {
            return false;
        }

        @Override
        public boolean isSilent() {
            return false;
        }

        @Override
        public void setSilent(boolean flag) {

        }

        @Override
        public boolean hasGravity() {
            return false;
        }

        @Override
        public void setGravity(boolean gravity) {

        }

        @Override
        public int getPortalCooldown() {
            return 0;
        }

        @Override
        public void setPortalCooldown(int cooldown) {

        }

        @NotNull
        @Override
        public Set<String> getScoreboardTags() {
            return null;
        }

        @Override
        public boolean addScoreboardTag(@NotNull String tag) {
            return false;
        }

        @Override
        public boolean removeScoreboardTag(@NotNull String tag) {
            return false;
        }

        @NotNull
        @Override
        public PistonMoveReaction getPistonMoveReaction() {
            return null;
        }

        @NotNull
        @Override
        public BlockFace getFacing() {
            return null;
        }

        @NotNull
        @Override
        public Pose getPose() {
            return null;
        }

        @Override
        public boolean isSneaking() {
            return false;
        }

        @Override
        public void setSneaking(boolean sneak) {

        }

        @Override
        public boolean isSprinting() {
            return false;
        }

        @Override
        public void setSprinting(boolean sprinting) {

        }

        @Override
        public void saveData() {

        }

        @Override
        public void loadData() {

        }

        @Override
        public void setSleepingIgnored(boolean isSleeping) {

        }

        @Override
        public boolean isSleepingIgnored() {
            return false;
        }

        @Override
        public boolean isOnline() {
            return false;
        }

        @Override
        public boolean isBanned() {
            return false;
        }

        @Override
        public boolean isWhitelisted() {
            return false;
        }

        @Override
        public void setWhitelisted(boolean value) {

        }

        @Nullable
        @Override
        public Player getPlayer() {
            return null;
        }

        @Override
        public long getFirstPlayed() {
            return 0;
        }

        @Override
        public long getLastPlayed() {
            return 0;
        }

        @Override
        public boolean hasPlayedBefore() {
            return false;
        }

        @Nullable
        @Override
        public Location getBedSpawnLocation() {
            return null;
        }

        @Override
        public long getLastLogin() {
            return 0;
        }

        @Override
        public long getLastSeen() {
            return 0;
        }

        @Override
        public void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {

        }

        @Override
        public void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {

        }

        @Override
        public void incrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException {

        }

        @Override
        public void decrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException {

        }

        @Override
        public void setStatistic(@NotNull Statistic statistic, int newValue) throws IllegalArgumentException {

        }

        @Override
        public int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
            return 0;
        }

        @Override
        public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {

        }

        @Override
        public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {

        }

        @Override
        public int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
            return 0;
        }

        @Override
        public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException {

        }

        @Override
        public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException {

        }

        @Override
        public void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int newValue) throws IllegalArgumentException {

        }

        @Override
        public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {

        }

        @Override
        public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {

        }

        @Override
        public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
            return 0;
        }

        @Override
        public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) throws IllegalArgumentException {

        }

        @Override
        public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) {

        }

        @Override
        public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int newValue) {

        }

        @Override
        public void setBedSpawnLocation(@Nullable Location location) {

        }

        @Override
        public void setBedSpawnLocation(@Nullable Location location, boolean force) {

        }

        @Override
        public void playNote(@NotNull Location loc, byte instrument, byte note) {

        }

        @Override
        public void playNote(@NotNull Location loc, @NotNull Instrument instrument, @NotNull Note note) {

        }

        @Override
        public void playSound(@NotNull Location location, @NotNull Sound sound, float volume, float pitch) {

        }

        @Override
        public void playSound(@NotNull Location location, @NotNull String sound, float volume, float pitch) {

        }

        @Override
        public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch) {

        }

        @Override
        public void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch) {

        }

        @Override
        public void stopSound(@NotNull Sound sound) {

        }

        @Override
        public void stopSound(@NotNull String sound) {

        }

        @Override
        public void stopSound(@NotNull Sound sound, @Nullable SoundCategory category) {

        }

        @Override
        public void stopSound(@NotNull String sound, @Nullable SoundCategory category) {

        }

        @Override
        public void playEffect(@NotNull Location loc, @NotNull Effect effect, int data) {

        }

        @Override
        public <T> void playEffect(@NotNull Location loc, @NotNull Effect effect, @Nullable T data) {

        }

        @Override
        public void sendBlockChange(@NotNull Location loc, @NotNull Material material, byte data) {

        }

        @Override
        public void sendBlockChange(@NotNull Location loc, @NotNull BlockData block) {

        }

        @Override
        public boolean sendChunkChange(@NotNull Location loc, int sx, int sy, int sz, @NotNull byte[] data) {
            return false;
        }

        @Override
        public void sendSignChange(@NotNull Location loc, @Nullable String[] lines) throws IllegalArgumentException {

        }

        @Override
        public void sendSignChange(@NotNull Location loc, @Nullable String[] lines, @NotNull DyeColor dyeColor) throws IllegalArgumentException {

        }

        @Override
        public void sendMap(@NotNull MapView map) {

        }

        @Override
        public void sendActionBar(@NotNull String message) {

        }

        @Override
        public void sendActionBar(char alternateChar, @NotNull String message) {

        }

        @Override
        public void sendActionBar(@NotNull BaseComponent... message) {

        }

        @Override
        public void setPlayerListHeaderFooter(@Nullable BaseComponent[] header, @Nullable BaseComponent[] footer) {

        }

        @Override
        public void setPlayerListHeaderFooter(@Nullable BaseComponent header, @Nullable BaseComponent footer) {

        }

        @Override
        public void setTitleTimes(int fadeInTicks, int stayTicks, int fadeOutTicks) {

        }

        @Override
        public void setSubtitle(BaseComponent[] subtitle) {

        }

        @Override
        public void setSubtitle(BaseComponent subtitle) {

        }

        @Override
        public void showTitle(@Nullable BaseComponent[] title) {

        }

        @Override
        public void showTitle(@Nullable BaseComponent title) {

        }

        @Override
        public void showTitle(@Nullable BaseComponent[] title, @Nullable BaseComponent[] subtitle, int fadeInTicks, int stayTicks, int fadeOutTicks) {

        }

        @Override
        public void showTitle(@Nullable BaseComponent title, @Nullable BaseComponent subtitle, int fadeInTicks, int stayTicks, int fadeOutTicks) {

        }

        @Override
        public void sendTitle(@NotNull Title title) {

        }

        @Override
        public void updateTitle(@NotNull Title title) {

        }

        @Override
        public void hideTitle() {

        }

        @Override
        public void updateInventory() {

        }

        @Override
        public void setPlayerTime(long time, boolean relative) {

        }

        @Override
        public long getPlayerTime() {
            return 0;
        }

        @Override
        public long getPlayerTimeOffset() {
            return 0;
        }

        @Override
        public boolean isPlayerTimeRelative() {
            return false;
        }

        @Override
        public void resetPlayerTime() {

        }

        @Override
        public void setPlayerWeather(@NotNull WeatherType type) {

        }

        @Nullable
        @Override
        public WeatherType getPlayerWeather() {
            return null;
        }

        @Override
        public void resetPlayerWeather() {

        }

        @Override
        public void giveExp(int amount, boolean applyMending) {

        }

        @Override
        public int applyMending(int amount) {
            return 0;
        }

        @Override
        public void giveExpLevels(int amount) {

        }

        @Override
        public float getExp() {
            return 0;
        }

        @Override
        public void setExp(float exp) {

        }

        @Override
        public int getLevel() {
            return 0;
        }

        @Override
        public void setLevel(int level) {

        }

        @Override
        public int getTotalExperience() {
            return 0;
        }

        @Override
        public void setTotalExperience(int exp) {

        }

        @Override
        public void sendExperienceChange(float progress) {

        }

        @Override
        public void sendExperienceChange(float progress, int level) {

        }

        @Override
        public float getExhaustion() {
            return 0;
        }

        @Override
        public void setExhaustion(float value) {

        }

        @Override
        public float getSaturation() {
            return 0;
        }

        @Override
        public void setSaturation(float value) {

        }

        @Override
        public int getFoodLevel() {
            return 0;
        }

        @Override
        public void setFoodLevel(int value) {

        }

        @Override
        public boolean getAllowFlight() {
            return false;
        }

        @Override
        public void setAllowFlight(boolean flight) {

        }

        @Override
        public void hidePlayer(@NotNull Player player) {

        }

        @Override
        public void hidePlayer(@NotNull Plugin plugin, @NotNull Player player) {

        }

        @Override
        public void showPlayer(@NotNull Player player) {

        }

        @Override
        public void showPlayer(@NotNull Plugin plugin, @NotNull Player player) {

        }

        @Override
        public boolean canSee(@NotNull Player player) {
            return false;
        }

        @Override
        public boolean isFlying() {
            return false;
        }

        @Override
        public void setFlying(boolean value) {

        }

        @Override
        public void setFlySpeed(float value) throws IllegalArgumentException {

        }

        @Override
        public void setWalkSpeed(float value) throws IllegalArgumentException {

        }

        @Override
        public float getFlySpeed() {
            return 0;
        }

        @Override
        public float getWalkSpeed() {
            return 0;
        }

        @Override
        public void setTexturePack(@NotNull String url) {

        }

        @Override
        public void setResourcePack(@NotNull String url) {

        }

        @Override
        public void setResourcePack(@NotNull String url, @NotNull byte[] hash) {

        }

        @NotNull
        @Override
        public Scoreboard getScoreboard() {
            return null;
        }

        @Override
        public void setScoreboard(@NotNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {

        }

        @Override
        public boolean isHealthScaled() {
            return false;
        }

        @Override
        public void setHealthScaled(boolean scale) {

        }

        @Override
        public void setHealthScale(double scale) throws IllegalArgumentException {

        }

        @Override
        public double getHealthScale() {
            return 0;
        }

        @Nullable
        @Override
        public Entity getSpectatorTarget() {
            return null;
        }

        @Override
        public void setSpectatorTarget(@Nullable Entity entity) {

        }

        @Override
        public void sendTitle(@Nullable String title, @Nullable String subtitle) {

        }

        @Override
        public void sendTitle(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut) {

        }

        @Override
        public void resetTitle() {

        }

        @Override
        public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count) {

        }

        @Override
        public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count) {

        }

        @Override
        public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, @Nullable T data) {

        }

        @Override
        public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, @Nullable T data) {

        }

        @Override
        public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ) {

        }

        @Override
        public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {

        }

        @Override
        public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data) {

        }

        @Override
        public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data) {

        }

        @Override
        public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra) {

        }

        @Override
        public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {

        }

        @Override
        public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data) {

        }

        @Override
        public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data) {

        }

        @NotNull
        @Override
        public AdvancementProgress getAdvancementProgress(@NotNull Advancement advancement) {
            return null;
        }

        @Override
        public int getClientViewDistance() {
            return 0;
        }

        @NotNull
        @Override
        public String getLocale() {
            return null;
        }

        @Override
        public boolean getAffectsSpawning() {
            return false;
        }

        @Override
        public void setAffectsSpawning(boolean affects) {

        }

        @Override
        public int getViewDistance() {
            return 0;
        }

        @Override
        public void setViewDistance(int viewDistance) {

        }

        @Override
        public void updateCommands() {

        }

        @Override
        public void openBook(@NotNull ItemStack book) {

        }

        @Override
        public void setResourcePack(@NotNull String url, @NotNull String hash) {

        }

        @Nullable
        @Override
        public PlayerResourcePackStatusEvent.Status getResourcePackStatus() {
            return null;
        }

        @Nullable
        @Override
        public String getResourcePackHash() {
            return null;
        }

        @Override
        public boolean hasResourcePack() {
            return false;
        }

        @NotNull
        @Override
        public PlayerProfile getPlayerProfile() {
            return null;
        }

        @Override
        public void setPlayerProfile(@NotNull PlayerProfile profile) {

        }

        @Override
        public float getCooldownPeriod() {
            return 0;
        }

        @Override
        public float getCooledAttackStrength(float adjustTicks) {
            return 0;
        }

        @Override
        public void resetCooldown() {

        }

        @NotNull
        @Override
        public <T> T getClientOption(@NotNull ClientOption<T> option) {
            return null;
        }

        @Nullable
        @Override
        public Firework boostElytra(@NotNull ItemStack firework) {
            return null;
        }

        @Override
        public void sendOpLevel(byte level) {

        }

        @Nullable
        @Override
        public String getClientBrandName() {
            return null;
        }

        @NotNull
        @Override
        public Spigot spigot() {
            return null;
        }

        @Nullable
        @Override
        public Location getOrigin() {
            return null;
        }

        @Override
        public boolean fromMobSpawner() {
            return false;
        }

        @NotNull
        @Override
        public Chunk getChunk() {
            return null;
        }

        @NotNull
        @Override
        public CreatureSpawnEvent.SpawnReason getEntitySpawnReason() {
            return null;
        }

        @Override
        public boolean isInRain() {
            return false;
        }

        @Override
        public boolean isInBubbleColumn() {
            return false;
        }

        @Override
        public boolean isInWaterOrRain() {
            return false;
        }

        @Override
        public boolean isInWaterOrBubbleColumn() {
            return false;
        }

        @Override
        public boolean isInWaterOrRainOrBubbleColumn() {
            return false;
        }

        @Override
        public boolean isInLava() {
            return false;
        }

        @Override
        public boolean isTicking() {
            return false;
        }

        @NotNull
        @Override
        public Map<String, Object> serialize() {
            return null;
        }

        @NotNull
        @Override
        public String getName() {
            return null;
        }

        @NotNull
        @Override
        public PlayerInventory getInventory() {
            return null;
        }

        @NotNull
        @Override
        public Inventory getEnderChest() {
            return null;
        }

        @NotNull
        @Override
        public MainHand getMainHand() {
            return null;
        }

        @Override
        public boolean setWindowProperty(@NotNull InventoryView.Property prop, int value) {
            return false;
        }

        @NotNull
        @Override
        public InventoryView getOpenInventory() {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openInventory(@NotNull Inventory inventory) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openWorkbench(@Nullable Location location, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openEnchanting(@Nullable Location location, boolean force) {
            return null;
        }

        @Override
        public void openInventory(@NotNull InventoryView inventory) {

        }

        @Nullable
        @Override
        public InventoryView openMerchant(@NotNull Villager trader, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openMerchant(@NotNull Merchant merchant, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openAnvil(@Nullable Location location, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openCartographyTable(@Nullable Location location, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openGrindstone(@Nullable Location location, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openLoom(@Nullable Location location, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openSmithingTable(@Nullable Location location, boolean force) {
            return null;
        }

        @Nullable
        @Override
        public InventoryView openStonecutter(@Nullable Location location, boolean force) {
            return null;
        }

        @Override
        public void closeInventory() {

        }

        @Override
        public void closeInventory(@NotNull InventoryCloseEvent.Reason reason) {

        }

        @NotNull
        @Override
        public ItemStack getItemInHand() {
            return null;
        }

        @Override
        public void setItemInHand(@Nullable ItemStack item) {

        }

        @NotNull
        @Override
        public ItemStack getItemOnCursor() {
            return null;
        }

        @Override
        public void setItemOnCursor(@Nullable ItemStack item) {

        }

        @Override
        public boolean hasCooldown(@NotNull Material material) {
            return false;
        }

        @Override
        public int getCooldown(@NotNull Material material) {
            return 0;
        }

        @Override
        public void setCooldown(@NotNull Material material, int ticks) {

        }

        @Override
        public int getSleepTicks() {
            return 0;
        }

        @Nullable
        @Override
        public Location getPotentialBedLocation() {
            return null;
        }

        @Override
        public boolean sleep(@NotNull Location location, boolean force) {
            return false;
        }

        @Override
        public void wakeup(boolean setSpawnLocation) {

        }

        @NotNull
        @Override
        public Location getBedLocation() {
            return null;
        }

        @NotNull
        @Override
        public GameMode getGameMode() {
            return null;
        }

        @Override
        public void setGameMode(@NotNull GameMode mode) {

        }

        @Override
        public boolean isBlocking() {
            return false;
        }

        @Override
        public double getEyeHeight() {
            return 0;
        }

        @Override
        public double getEyeHeight(boolean ignorePose) {
            return 0;
        }

        @NotNull
        @Override
        public Location getEyeLocation() {
            return null;
        }

        @NotNull
        @Override
        public List<Block> getLineOfSight(@Nullable Set<Material> transparent, int maxDistance) {
            return null;
        }

        @NotNull
        @Override
        public Block getTargetBlock(@Nullable Set<Material> transparent, int maxDistance) {
            return null;
        }

        @Nullable
        @Override
        public Block getTargetBlock(int maxDistance, @NotNull TargetBlockInfo.FluidMode fluidMode) {
            return null;
        }

        @Nullable
        @Override
        public BlockFace getTargetBlockFace(int maxDistance, @NotNull TargetBlockInfo.FluidMode fluidMode) {
            return null;
        }

        @Nullable
        @Override
        public TargetBlockInfo getTargetBlockInfo(int maxDistance, @NotNull TargetBlockInfo.FluidMode fluidMode) {
            return null;
        }

        @Nullable
        @Override
        public Entity getTargetEntity(int maxDistance, boolean ignoreBlocks) {
            return null;
        }

        @Nullable
        @Override
        public TargetEntityInfo getTargetEntityInfo(int maxDistance, boolean ignoreBlocks) {
            return null;
        }

        @NotNull
        @Override
        public List<Block> getLastTwoTargetBlocks(@Nullable Set<Material> transparent, int maxDistance) {
            return null;
        }

        @Nullable
        @Override
        public Block getTargetBlockExact(int maxDistance) {
            return null;
        }

        @Nullable
        @Override
        public Block getTargetBlockExact(int maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
            return null;
        }

        @Nullable
        @Override
        public RayTraceResult rayTraceBlocks(double maxDistance) {
            return null;
        }

        @Nullable
        @Override
        public RayTraceResult rayTraceBlocks(double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
            return null;
        }

        @Override
        public int getRemainingAir() {
            return 0;
        }

        @Override
        public void setRemainingAir(int ticks) {

        }

        @Override
        public int getMaximumAir() {
            return 0;
        }

        @Override
        public void setMaximumAir(int ticks) {

        }

        @Override
        public int getArrowCooldown() {
            return 0;
        }

        @Override
        public void setArrowCooldown(int ticks) {

        }

        @Override
        public int getArrowsInBody() {
            return 0;
        }

        @Override
        public void setArrowsInBody(int count) {

        }

        @Override
        public int getMaximumNoDamageTicks() {
            return 0;
        }

        @Override
        public void setMaximumNoDamageTicks(int ticks) {

        }

        @Override
        public double getLastDamage() {
            return 0;
        }

        @Override
        public void setLastDamage(double damage) {

        }

        @Override
        public int getNoDamageTicks() {
            return 0;
        }

        @Override
        public void setNoDamageTicks(int ticks) {

        }

        @Nullable
        @Override
        public Player getKiller() {
            return null;
        }

        @Override
        public void setKiller(@Nullable Player killer) {

        }

        @Override
        public boolean addPotionEffect(@NotNull PotionEffect effect) {
            return false;
        }

        @Override
        public boolean addPotionEffect(@NotNull PotionEffect effect, boolean force) {
            return false;
        }

        @Override
        public boolean addPotionEffects(@NotNull Collection<PotionEffect> effects) {
            return false;
        }

        @Override
        public boolean hasPotionEffect(@NotNull PotionEffectType type) {
            return false;
        }

        @Nullable
        @Override
        public PotionEffect getPotionEffect(@NotNull PotionEffectType type) {
            return null;
        }

        @Override
        public void removePotionEffect(@NotNull PotionEffectType type) {

        }

        @NotNull
        @Override
        public Collection<PotionEffect> getActivePotionEffects() {
            return null;
        }

        @Override
        public boolean hasLineOfSight(@NotNull Entity other) {
            return false;
        }

        @Override
        public boolean getRemoveWhenFarAway() {
            return false;
        }

        @Override
        public void setRemoveWhenFarAway(boolean remove) {

        }

        @Nullable
        @Override
        public EntityEquipment getEquipment() {
            return null;
        }

        @Override
        public void setCanPickupItems(boolean pickup) {

        }

        @Override
        public boolean getCanPickupItems() {
            return false;
        }

        @Override
        public boolean isLeashed() {
            return false;
        }

        @NotNull
        @Override
        public Entity getLeashHolder() throws IllegalStateException {
            return null;
        }

        @Override
        public boolean setLeashHolder(@Nullable Entity holder) {
            return false;
        }

        @Override
        public boolean isGliding() {
            return false;
        }

        @Override
        public void setGliding(boolean gliding) {

        }

        @Override
        public boolean isSwimming() {
            return false;
        }

        @Override
        public void setSwimming(boolean swimming) {

        }

        @Override
        public boolean isRiptiding() {
            return false;
        }

        @Override
        public boolean isSleeping() {
            return false;
        }

        @Override
        public void setAI(boolean ai) {

        }

        @Override
        public boolean hasAI() {
            return false;
        }

        @Override
        public void attack(@NotNull Entity target) {

        }

        @Override
        public void swingMainHand() {

        }

        @Override
        public void swingOffHand() {

        }

        @Override
        public void setCollidable(boolean collidable) {

        }

        @Override
        public boolean isCollidable() {
            return false;
        }

        @NotNull
        @Override
        public Set<UUID> getCollidableExemptions() {
            return null;
        }

        @Nullable
        @Override
        public <T> T getMemory(@NotNull MemoryKey<T> memoryKey) {
            return null;
        }

        @Override
        public <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T memoryValue) {

        }

        @NotNull
        @Override
        public EntityCategory getCategory() {
            return null;
        }

        @Override
        public void setInvisible(boolean invisible) {

        }

        @Override
        public boolean isInvisible() {
            return false;
        }

        @Override
        public int getArrowsStuck() {
            return 0;
        }

        @Override
        public void setArrowsStuck(int arrows) {

        }

        @Override
        public int getShieldBlockingDelay() {
            return 0;
        }

        @Override
        public void setShieldBlockingDelay(int delay) {

        }

        @Nullable
        @Override
        public ItemStack getActiveItem() {
            return null;
        }

        @Override
        public void clearActiveItem() {

        }

        @Override
        public int getItemUseRemainingTime() {
            return 0;
        }

        @Override
        public int getHandRaisedTime() {
            return 0;
        }

        @Override
        public boolean isHandRaised() {
            return false;
        }

        @Override
        public boolean isJumping() {
            return false;
        }

        @Override
        public void setJumping(boolean jumping) {

        }

        @Override
        public void playPickupItemAnimation(@NotNull Item item, int quantity) {

        }

        @Override
        public float getHurtDirection() {
            return 0;
        }

        @Override
        public void setHurtDirection(float hurtDirection) {

        }

        @Override
        public int getExpToLevel() {
            return 0;
        }

        @Nullable
        @Override
        public Entity releaseLeftShoulderEntity() {
            return null;
        }

        @Nullable
        @Override
        public Entity releaseRightShoulderEntity() {
            return null;
        }

        @Override
        public float getAttackCooldown() {
            return 0;
        }

        @Override
        public boolean discoverRecipe(@NotNull NamespacedKey recipe) {
            return false;
        }

        @Override
        public int discoverRecipes(@NotNull Collection<NamespacedKey> recipes) {
            return 0;
        }

        @Override
        public boolean undiscoverRecipe(@NotNull NamespacedKey recipe) {
            return false;
        }

        @Override
        public int undiscoverRecipes(@NotNull Collection<NamespacedKey> recipes) {
            return 0;
        }

        @Override
        public boolean hasDiscoveredRecipe(@NotNull NamespacedKey recipe) {
            return false;
        }

        @NotNull
        @Override
        public Set<NamespacedKey> getDiscoveredRecipes() {
            return null;
        }

        @Nullable
        @Override
        public Entity getShoulderEntityLeft() {
            return null;
        }

        @Override
        public void setShoulderEntityLeft(@Nullable Entity entity) {

        }

        @Nullable
        @Override
        public Entity getShoulderEntityRight() {
            return null;
        }

        @Override
        public void setShoulderEntityRight(@Nullable Entity entity) {

        }

        @Override
        public void openSign(@NotNull Sign sign) {

        }

        @Override
        public boolean dropItem(boolean dropAll) {
            return false;
        }

        @Nullable
        @Override
        public AttributeInstance getAttribute(@NotNull Attribute attribute) {
            return null;
        }

        @Override
        public void registerAttribute(@NotNull Attribute attribute) {

        }

        @Override
        public void damage(double amount) {

        }

        @Override
        public void damage(double amount, @Nullable Entity source) {

        }

        @Override
        public double getHealth() {
            return 0;
        }

        @Override
        public void setHealth(double health) {

        }

        @Override
        public double getAbsorptionAmount() {
            return 0;
        }

        @Override
        public void setAbsorptionAmount(double amount) {

        }

        @Override
        public double getMaxHealth() {
            return 0;
        }

        @Override
        public void setMaxHealth(double health) {

        }

        @Override
        public void resetMaxHealth() {

        }

        @Nullable
        @Override
        public String getCustomName() {
            return null;
        }

        @Override
        public void setCustomName(@Nullable String name) {

        }

        @Override
        public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {

        }

        @NotNull
        @Override
        public List<MetadataValue> getMetadata(@NotNull String metadataKey) {
            return null;
        }

        @Override
        public boolean hasMetadata(@NotNull String metadataKey) {
            return false;
        }

        @Override
        public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {

        }

        @Override
        public boolean isPermissionSet(@NotNull String name) {
            return false;
        }

        @Override
        public boolean isPermissionSet(@NotNull Permission perm) {
            return false;
        }

        @Override
        public boolean hasPermission(@NotNull String name) {
            return false;
        }

        @Override
        public boolean hasPermission(@NotNull Permission perm) {
            return false;
        }

        @NotNull
        @Override
        public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
            return null;
        }

        @NotNull
        @Override
        public PermissionAttachment addAttachment(@NotNull Plugin plugin) {
            return null;
        }

        @Nullable
        @Override
        public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
            return null;
        }

        @Nullable
        @Override
        public PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
            return null;
        }

        @Override
        public void removeAttachment(@NotNull PermissionAttachment attachment) {

        }

        @Override
        public void recalculatePermissions() {

        }

        @NotNull
        @Override
        public Set<PermissionAttachmentInfo> getEffectivePermissions() {
            return null;
        }

        @Override
        public boolean isOp() {
            return false;
        }

        @Override
        public void setOp(boolean value) {

        }

        @NotNull
        @Override
        public PersistentDataContainer getPersistentDataContainer() {
            return null;
        }

        @Override
        public void sendPluginMessage(@NotNull Plugin source, @NotNull String channel, @NotNull byte[] message) {

        }

        @NotNull
        @Override
        public Set<String> getListeningPluginChannels() {
            return null;
        }

        @NotNull
        @Override
        public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile) {
            return null;
        }

        @NotNull
        @Override
        public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile, @Nullable Vector velocity) {
            return null;
        }
    }
}
