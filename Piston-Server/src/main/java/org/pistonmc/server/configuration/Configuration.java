package org.pistonmc.server.configuration;

import java.util.List;

public interface Configuration {
    <T> void add(String key, T value);
    <T> void addArray(String key, T... value);
    <T> void addArray(String key, List<T> value);
    void addSection(String key, Configuration value);
    <T> T get(String key);
    <T> T get(String key, T def);
    Configuration getSection(String key);
    <T> List<T> getArray(String key);
    <T> List<T> getArray(String key, T... def);
    <T> List<T> getArray(String key, List<T> def);
}
