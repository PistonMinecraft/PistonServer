package org.pistonmc.server.impl.pluginapi;

import com.destroystokyo.paper.entity.ai.MobGoals;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.google.common.collect.Lists;
import net.minecraft.server.dedicated.DedicatedPlayerList;
import net.minecraft.server.dedicated.DedicatedServer;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.*;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.loot.LootTable;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pistonmc.pluginapi.Piston;
import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.server.RuntimeProperties;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PistonServer implements org.pistonmc.pluginapi.Server {
    private final DedicatedServer server;
    private final DedicatedPlayerList playerList;

    private final BukkitImpl bukkitImpl;

    public PistonServer(DedicatedServer server) {
        this.server = server;
        this.playerList = server.getPlayerList();
        Piston.setServer(this);
        this.bukkitImpl = new BukkitImpl();
    }

    @Override
    public String getServerVersion() {
        return RuntimeProperties.get(RuntimeProperties.Key.SERVER_VERSION);
    }

    @Override
    public PlayerEntity getPlayer(String playerName) {
        return null;
    }

    @Override
    public PlayerEntity getPlayer(UUID playerUUID) {
        return null;
    }

    public org.pistonmc.pluginapi.world.World getWorld(String worldName) {
        return null;
    }

    public BukkitImpl getBukkitImpl() {
        return bukkitImpl;
    }

    public class BukkitImpl implements org.bukkit.Server {
        private final List<org.bukkit.entity.Player> onlinePlayers = playerList.getPlayers().stream().map(e -> e.getPistonPluginEntityImpl().getBukkitImpl()).collect(Collectors.toList());
        private BukkitImpl() {
            Bukkit.setServer(this);
        }

        @NotNull
        @Override
        public String getName() {
            return RuntimeProperties.get(RuntimeProperties.Key.SERVER_NAME, "Piston");
        }

        @NotNull
        @Override
        public String getVersion() {
            return "${RuntimeProperties.get(RuntimeProperties.Key.SERVER_VERSION)} (MC: ${server.getServerVersion()})";
        }

        @NotNull
        @Override
        public String getBukkitVersion() {
            return RuntimeProperties.get(RuntimeProperties.Key.SERVER_BUKKIT_VERSION)   ;
        }

        @NotNull
        @Override
        public String getMinecraftVersion() {
            return server.getServerVersion();
        }

        @NotNull
        @Override
        public Collection<? extends org.bukkit.entity.Player> getOnlinePlayers() {
            return null;
        }

        @Override
        public int getMaxPlayers() {
            return playerList.getMaxPlayers();
        }

        @Override
        public void setMaxPlayers(int maxPlayers) {
            playerList.setMaxPlayers(maxPlayers);
        }

        @Override
        public int getPort() {
            return server.getPort();
        }

        @Override
        public int getViewDistance() {
            return 0;
        }

        @NotNull
        @Override
        public String getIp() {
            return null;
        }

        @NotNull
        @Override
        public String getWorldType() {
            return null;
        }

        @Override
        public boolean getGenerateStructures() {
            return false;
        }

        @Override
        public int getMaxWorldSize() {
            return 0;
        }

        @Override
        public boolean getAllowEnd() {
            return false;
        }

        @Override
        public boolean getAllowNether() {
            return false;
        }

        @Override
        public boolean hasWhitelist() {
            return false;
        }

        @Override
        public void setWhitelist(boolean value) {

        }

        @NotNull
        @Override
        public Set<OfflinePlayer> getWhitelistedPlayers() {
            return null;
        }

        @Override
        public void reloadWhitelist() {

        }

        @Override
        public int broadcastMessage(@NotNull String message) {
            return 0;
        }

        @NotNull
        @Override
        public String getUpdateFolder() {
            return null;
        }

        @NotNull
        @Override
        public File getUpdateFolderFile() {
            return null;
        }

        @Override
        public long getConnectionThrottle() {
            return 0;
        }

        @Override
        public int getTicksPerAnimalSpawns() {
            return 0;
        }

        @Override
        public int getTicksPerMonsterSpawns() {
            return 0;
        }

        @Override
        public int getTicksPerWaterSpawns() {
            return 0;
        }

        @Override
        public int getTicksPerWaterAmbientSpawns() {
            return 0;
        }

        @Override
        public int getTicksPerAmbientSpawns() {
            return 0;
        }

        @Nullable
        @Override
        public Player getPlayer(@NotNull String name) {
            return null;
        }

        @Nullable
        @Override
        public Player getPlayerExact(@NotNull String name) {
            return null;
        }

        @NotNull
        @Override
        public List<Player> matchPlayer(@NotNull String name) {
            return null;
        }

        @Nullable
        @Override
        public Player getPlayer(@NotNull UUID id) {
            return null;
        }

        @Nullable
        @Override
        public UUID getPlayerUniqueId(@NotNull String playerName) {
            return null;
        }

        @NotNull
        @Override
        public PluginManager getPluginManager() {
            return null;
        }

        @NotNull
        @Override
        public BukkitScheduler getScheduler() {
            return null;
        }

        @NotNull
        @Override
        public ServicesManager getServicesManager() {
            return null;
        }

        @NotNull
        @Override
        public List<World> getWorlds() {
            return null;
        }

        @Nullable
        @Override
        public World createWorld(@NotNull WorldCreator creator) {
            return null;
        }

        @Override
        public boolean unloadWorld(@NotNull String name, boolean save) {
            return false;
        }

        @Override
        public boolean unloadWorld(@NotNull World world, boolean save) {
            return false;
        }

        @Nullable
        @Override
        public World getWorld(@NotNull String name) {
            return null;
        }

        @Nullable
        @Override
        public World getWorld(@NotNull UUID uid) {
            return null;
        }

        @Nullable
        @Override
        public MapView getMap(int id) {
            return null;
        }

        @NotNull
        @Override
        public MapView createMap(@NotNull World world) {
            return null;
        }

        @NotNull
        @Override
        public ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType) {
            return null;
        }

        @NotNull
        @Override
        public ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType, int radius, boolean findUnexplored) {
            return null;
        }

        @Override
        public void reload() {

        }

        @Override
        public void reloadData() {

        }

        @NotNull
        @Override
        public java.util.logging.Logger getLogger() {
            return null;
        }

        @Nullable
        @Override
        public PluginCommand getPluginCommand(@NotNull String name) {
            return null;
        }

        @Override
        public void savePlayers() {

        }

        @Override
        public boolean dispatchCommand(@NotNull CommandSender sender, @NotNull String commandLine) throws CommandException {
            return false;
        }

        @Override
        public boolean addRecipe(@Nullable Recipe recipe) {
            return false;
        }

        @NotNull
        @Override
        public List<Recipe> getRecipesFor(@NotNull ItemStack result) {
            return null;
        }

        @Nullable
        @Override
        public Recipe getRecipe(@NotNull NamespacedKey recipeKey) {
            return null;
        }

        @NotNull
        @Override
        public Iterator<Recipe> recipeIterator() {
            return null;
        }

        @Override
        public void clearRecipes() {

        }

        @Override
        public void resetRecipes() {

        }

        @Override
        public boolean removeRecipe(@NotNull NamespacedKey key) {
            return false;
        }

        @NotNull
        @Override
        public Map<String, String[]> getCommandAliases() {
            return null;
        }

        @Override
        public int getSpawnRadius() {
            return 0;
        }

        @Override
        public void setSpawnRadius(int value) {

        }

        @Override
        public boolean getOnlineMode() {
            return false;
        }

        @Override
        public boolean getAllowFlight() {
            return false;
        }

        @Override
        public boolean isHardcore() {
            return false;
        }

        @Override
        public void shutdown() {

        }

        @Override
        public int broadcast(@NotNull String message, @NotNull String permission) {
            return 0;
        }

        @NotNull
        @Override
        public OfflinePlayer getOfflinePlayer(@NotNull String name) {
            return null;
        }

        @Nullable
        @Override
        public OfflinePlayer getOfflinePlayerIfCached(@NotNull String name) {
            return null;
        }

        @NotNull
        @Override
        public OfflinePlayer getOfflinePlayer(@NotNull UUID id) {
            return null;
        }

        @NotNull
        @Override
        public Set<String> getIPBans() {
            return null;
        }

        @Override
        public void banIP(@NotNull String address) {

        }

        @Override
        public void unbanIP(@NotNull String address) {

        }

        @NotNull
        @Override
        public Set<OfflinePlayer> getBannedPlayers() {
            return null;
        }

        @NotNull
        @Override
        public BanList getBanList(@NotNull BanList.Type type) {
            return null;
        }

        @NotNull
        @Override
        public Set<OfflinePlayer> getOperators() {
            return null;
        }

        @NotNull
        @Override
        public GameMode getDefaultGameMode() {
            return null;
        }

        @Override
        public void setDefaultGameMode(@NotNull GameMode mode) {

        }

        @NotNull
        @Override
        public ConsoleCommandSender getConsoleSender() {
            return null;
        }

        @NotNull
        @Override
        public File getWorldContainer() {
            return null;
        }

        @NotNull
        @Override
        public OfflinePlayer[] getOfflinePlayers() {
            return new OfflinePlayer[0];
        }

        @NotNull
        @Override
        public Messenger getMessenger() {
            return null;
        }

        @NotNull
        @Override
        public HelpMap getHelpMap() {
            return null;
        }

        @NotNull
        @Override
        public Inventory createInventory(@Nullable InventoryHolder owner, @NotNull InventoryType type) {
            return null;
        }

        @NotNull
        @Override
        public Inventory createInventory(@Nullable InventoryHolder owner, @NotNull InventoryType type, @NotNull String title) {
            return null;
        }

        @NotNull
        @Override
        public Inventory createInventory(@Nullable InventoryHolder owner, int size) throws IllegalArgumentException {
            return null;
        }

        @NotNull
        @Override
        public Inventory createInventory(@Nullable InventoryHolder owner, int size, @NotNull String title) throws IllegalArgumentException {
            return null;
        }

        @NotNull
        @Override
        public Merchant createMerchant(@Nullable String title) {
            return null;
        }

        @Override
        public int getMonsterSpawnLimit() {
            return 0;
        }

        @Override
        public int getAnimalSpawnLimit() {
            return 0;
        }

        @Override
        public int getWaterAnimalSpawnLimit() {
            return 0;
        }

        @Override
        public int getWaterAmbientSpawnLimit() {
            return 0;
        }

        @Override
        public int getAmbientSpawnLimit() {
            return 0;
        }

        @Override
        public boolean isPrimaryThread() {
            return false;
        }

        @NotNull
        @Override
        public String getMotd() {
            return null;
        }

        @Nullable
        @Override
        public String getShutdownMessage() {
            return null;
        }

        @NotNull
        @Override
        public Warning.WarningState getWarningState() {
            return null;
        }

        @NotNull
        @Override
        public ItemFactory getItemFactory() {
            return null;
        }

        @NotNull
        @Override
        public ScoreboardManager getScoreboardManager() {
            return null;
        }

        @Nullable
        @Override
        public CachedServerIcon getServerIcon() {
            return null;
        }

        @NotNull
        @Override
        public CachedServerIcon loadServerIcon(@NotNull File file) throws IllegalArgumentException, Exception {
            return null;
        }

        @NotNull
        @Override
        public CachedServerIcon loadServerIcon(@NotNull BufferedImage image) throws IllegalArgumentException, Exception {
            return null;
        }

        @Override
        public void setIdleTimeout(int threshold) {

        }

        @Override
        public int getIdleTimeout() {
            return 0;
        }

        @NotNull
        @Override
        public ChunkGenerator.ChunkData createChunkData(@NotNull World world) {
            return null;
        }

        @NotNull
        @Override
        public ChunkGenerator.ChunkData createVanillaChunkData(@NotNull World world, int x, int z) {
            return null;
        }

        @NotNull
        @Override
        public BossBar createBossBar(@Nullable String title, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
            return null;
        }

        @NotNull
        @Override
        public KeyedBossBar createBossBar(@NotNull NamespacedKey key, @Nullable String title, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
            return null;
        }

        @NotNull
        @Override
        public Iterator<KeyedBossBar> getBossBars() {
            return null;
        }

        @Nullable
        @Override
        public KeyedBossBar getBossBar(@NotNull NamespacedKey key) {
            return null;
        }

        @Override
        public boolean removeBossBar(@NotNull NamespacedKey key) {
            return false;
        }

        @Nullable
        @Override
        public Entity getEntity(@NotNull UUID uuid) {
            return null;
        }

        @NotNull
        @Override
        public double[] getTPS() {
            return new double[0];
        }

        @NotNull
        @Override
        public long[] getTickTimes() {
            return new long[0];
        }

        @Override
        public double getAverageTickTime() {
            return 0;
        }

        @NotNull
        @Override
        public CommandMap getCommandMap() {
            return null;
        }

        @Nullable
        @Override
        public Advancement getAdvancement(@NotNull NamespacedKey key) {
            return null;
        }

        @NotNull
        @Override
        public Iterator<Advancement> advancementIterator() {
            return null;
        }

        @NotNull
        @Override
        public BlockData createBlockData(@NotNull Material material) {
            return null;
        }

        @NotNull
        @Override
        public BlockData createBlockData(@NotNull Material material, @Nullable Consumer<BlockData> consumer) {
            return null;
        }

        @NotNull
        @Override
        public BlockData createBlockData(@NotNull String data) throws IllegalArgumentException {
            return null;
        }

        @NotNull
        @Override
        public BlockData createBlockData(@Nullable Material material, @Nullable String data) throws IllegalArgumentException {
            return null;
        }

        @Override
        public <T extends Keyed> Tag<T> getTag(@NotNull String registry, @NotNull NamespacedKey tag, @NotNull Class<T> clazz) {
            return null;
        }

        @NotNull
        @Override
        public <T extends Keyed> Iterable<Tag<T>> getTags(@NotNull String registry, @NotNull Class<T> clazz) {
            return null;
        }

        @Nullable
        @Override
        public LootTable getLootTable(@NotNull NamespacedKey key) {
            return null;
        }

        @NotNull
        @Override
        public List<Entity> selectEntities(@NotNull CommandSender sender, @NotNull String selector) throws IllegalArgumentException {
            return null;
        }

        @NotNull
        @Override
        public UnsafeValues getUnsafe() {
            return null;
        }

        @NotNull
        @Override
        public Spigot spigot() {
            return null;
        }

        @Override
        public void reloadPermissions() {

        }

        @Override
        public boolean reloadCommandAliases() {
            return false;
        }

        @Override
        public boolean suggestPlayerNamesWhenNullTabCompletions() {
            return false;
        }

        @NotNull
        @Override
        public String getPermissionMessage() {
            return null;
        }

        @NotNull
        @Override
        public PlayerProfile createProfile(@NotNull UUID uuid) {
            return null;
        }

        @NotNull
        @Override
        public PlayerProfile createProfile(@NotNull String name) {
            return null;
        }

        @NotNull
        @Override
        public PlayerProfile createProfile(@Nullable UUID uuid, @Nullable String name) {
            return null;
        }

        @Override
        public int getCurrentTick() {
            return 0;
        }

        @Override
        public boolean isStopping() {
            return false;
        }

        @NotNull
        @Override
        public MobGoals getMobGoals() {
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
    }
}
