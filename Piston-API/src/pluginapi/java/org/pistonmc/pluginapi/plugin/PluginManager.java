package org.pistonmc.pluginapi.plugin;

public interface PluginManager {
    boolean loadPistonPlugin(String mainClass);
    /*{
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
    }*/
    boolean registerEventListener();
    boolean loadPlugin(PistonPlugin plugin);
    boolean loadPlugin(String plugin);
    boolean unloadPlugin(PistonPlugin plugin);
    boolean unloadPlugin(String plugin);
}
