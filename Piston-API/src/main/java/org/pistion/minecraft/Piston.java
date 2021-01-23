package org.pistion.minecraft;

import org.pistion.minecraft.plugin.PluginManager;

public class Piston {
    //Pistion.java
    //完成对插件的基础操作
    private PluginManager pluginManager;
    //PistonPluginManager
    public void initPistonPlugin(){
        //初始化PistonPluginAPI并加载Piston插件
        pluginManager =new PluginManager();
        /*
        此处应有jar包解析
         */
        //PluginManager.loadPistonPlugin();
        //加载Piston插件
    }
}
