package org.pistonmc.pluginapi;

import org.pistonmc.pluginapi.entity.PlayerEntity;

public interface Piston {
    /**
     * 返回Piston服务端版本
     * @return Piston服务端版本
     */
    String getServerVersion();
    /**
     * 通过玩家名称获取玩家实体
     * @param playerName
     * @return 玩家实体
     */
    PlayerEntity getPlayer(String playerName);
}
