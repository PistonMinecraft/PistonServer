package org.pistonmc.pluginapi.plugin;

public class PluginManager {
    public PluginManager() {}
    public static boolean loadPistonPlugin(String mainClass) {
        //加载Piston插件
        //此函数不会判断主类是否继承PistonPlugin
        try {
            Class<?> c = Class.forName(mainClass);
            if(PistonPlugin.class.isAssignableFrom(c)) {
                @SuppressWarnings("unchecked") PistonPlugin plugin = ((Class<? extends PistonPlugin>) c).newInstance();
                plugin.onEnable();
                return true;
            }
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean registerEventListener() {
        return false;
    }
}
