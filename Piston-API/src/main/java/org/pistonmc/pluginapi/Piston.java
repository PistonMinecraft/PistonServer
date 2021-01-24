package org.pistonmc.pluginapi;

import org.pistonmc.pluginapi.entity.PlayerEntity;
import org.pistonmc.pluginapi.plugin.PluginManager;

public class Piston {
    private PluginManager pluginManager;
    public void initPistonPlugin(){
        //初始化PistonPluginAPI并加载Piston插件
        pluginManager = new PluginManager();
        /*
        此处应有jar包解析
         */
        //PluginManager.loadPistonPlugin();
        //加载Piston插件
    }

    /**
     * 返回Piston服务端版本
     * @return Piston服务端版本
     */
    public String getPistonServerVersion(){
        return null;
    }
    /**
     * 通过玩家名称获取玩家实体
     * @param playerName
     * @return 玩家实体
     */
    public PlayerEntity getPlayer(String playerName){
        return null;
    }
}
