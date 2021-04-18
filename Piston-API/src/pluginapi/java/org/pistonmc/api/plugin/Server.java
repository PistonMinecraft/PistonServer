package org.pistonmc.api.plugin;

import org.pistonmc.api.plugin.entity.player.PlayerEntity;

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

    /**
     * 通过玩家UUID获取玩家实体
     * @param playerUUID UUID
     * @return 玩家实体
     */
    PlayerEntity getPlayer(UUID playerUUID);

    /**
     * 获取服务器最大人数
     * @return
     */
    int getMaxPlayer();
}