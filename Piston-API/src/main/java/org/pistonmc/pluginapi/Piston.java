package org.pistonmc.pluginapi;

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
}
