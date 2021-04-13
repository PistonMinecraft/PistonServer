package org.pistonmc;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecrell.terminalconsole.TerminalConsoleAppender;

import java.net.Proxy;
import java.util.Optional;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class RuntimeProperties {
    public static final class Key<V> {
        private final String name;
        final boolean constant;
        private Key(String name) {
            this.name = name;
            this.constant = false;
        }
        private Key(String key, boolean constant) {
            this.name = key;
            this.constant = constant;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;

            Key<?> key = (Key<?>) o;

            return name.equals(key.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        public static final Key<Proxy> GLOBAL_PROXY = new Key<>("global_proxy");
        public static final Key<Boolean> CONSOLE = new Key<>("console");

        // Server properties
        public static final Key<String> SERVER_NAME = new Key<>("server_name", true);
        public static final Key<String> SERVER_VERSION = new Key<>("server_version", true);
        public static final Key<String> SERVER_BUKKIT_VERSION = new Key<>("server_bukkit_version", true);
        public static final Key<String[]> SERVER_LAUNCH_ARGS = new Key<>("server_launch_args", true);
    }
    public static class SystemPropKey {
        final String key;
        private SystemPropKey(String key) {
            this.key = key;
        }
        public static class BooleanPropKey extends SystemPropKey {
            private BooleanPropKey(String key) {
                super(key);
            }
            String getKey() {
                return key;
            }
            public static final BooleanPropKey TERMINAL_JLINE = new BooleanPropKey(TerminalConsoleAppender.JLINE_OVERRIDE_PROPERTY);
        }
    }
    private static final Object2ObjectMap<Key<?>, Object> PROPERTIES = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap<>());
    static {
        Package p = RuntimeProperties.class.getPackage();
        Manifest man = new Manifest(RuntimeProperties.class.getClassLoader().getResourceAsStream(JarFile.MANIFEST_NAME));
        // init some default values
        put(Key.CONSOLE, true);
        put(Key.SERVER_NAME, p.getImplementationTitle());
        put(Key.SERVER_VERSION, p.getImplementationVersion());
        put(Key.SERVER_BUKKIT_VERSION, man.getMainAttributes().getValue("Bukkit-Version"));
        put(Key.SERVER_LAUNCH_ARGS, man.getMainAttributes().getValue("Server-Launch-Args").split(" "));
    }
    @SuppressWarnings("unchecked")
    public static <V> V put(Key<V> key, V value) {
        if(get(key) != null && key.constant) throw new IllegalArgumentException("You cannot change a constant");
        return (V) PROPERTIES.put(key, value);
    }
    @SuppressWarnings("unchecked")
    public static <V> V get(Key<V> key) {
        return (V) PROPERTIES.get(key);
    }
    @SuppressWarnings("unchecked")
    public static <V> V get(Key<V> key, V defaultValue) {
        return (V) Optional.ofNullable(PROPERTIES.get(key)).orElse(defaultValue);
    }

    public static boolean getSystemProperty(SystemPropKey.BooleanPropKey key) {
        return Boolean.getBoolean(key.key);
    }
    public static boolean setSystemProperty(SystemPropKey.BooleanPropKey key, boolean value) {
        return Boolean.parseBoolean(System.setProperty(key.key, String.valueOf(value)));
    }
    public static String getSystemProperty(SystemPropKey key) {
        return System.getProperty(key.key);
    }
    public static String setSystemProperty(SystemPropKey key, String value) {
        return System.setProperty(key.key, value);
    }
}