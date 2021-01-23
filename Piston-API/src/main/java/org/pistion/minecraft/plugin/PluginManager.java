package org.pistion.minecraft.plugin;

public class PluginManager {
    public static boolean loadPistonPlugin(String mainClass ){
        //加载Piston插件
        //此函数不会判断主类是否继承PistonPlugin
        try {
            Class clazz = Class.forName(mainClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
