package org.pistonmc.pluginapi;

public class ResourceName {
    public static final String DEFAULT_NAMESPACE = "minecraft";
    private final String namespace;
    private final String name;

    public ResourceName(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    public ResourceName(String fullNameOrName) {
        if(fullNameOrName.contains(":")) { // If arg is a full name
            String[] s = fullNameOrName.split(":");
            this.namespace = s[0];
            this.name = s[1];
        } else { // If arg is name only
            this.namespace = DEFAULT_NAMESPACE;
            this.name = fullNameOrName;
        }
    }

    public static ResourceName minecraft(String name) {
        return new ResourceName(DEFAULT_NAMESPACE, name);
    }

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
        return name;
    }
}