package org.pistion.minecraft.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PluginManager {
    public static boolean loadPistonPlugin(String mainClass){
        //加载Piston插件
        //此函数不会判断主类是否继承PistonPlugin
        Class clazz = null;
        PistonPlugin plugin = null;
        try {
            clazz = Class.forName(mainClass);
            plugin = (PistonPlugin) clazz.newInstance();
            plugin.onEnable();
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean registerEventListener(){
        return true;
    }
}
