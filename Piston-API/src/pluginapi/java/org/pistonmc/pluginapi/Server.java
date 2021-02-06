package org.pistonmc.pluginapi;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.world.World;

import java.util.UUID;

public interface Server {
    /**
     * 返回此实现的服务端版本
     * @return Piston服务端版本
     */
    String getServerVersion();
    /**
     * 通过玩家名称获取玩家实体
     * @param playerName 玩家的名字
     * @return 玩家实体
     */
    PlayerEntity getPlayer(String playerName);
    PlayerEntity getPlayer(UUID playerUUID);
    World getWorld(String worldName);
}
