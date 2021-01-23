package org.pistonmc.build.util;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DependencyUtil {
    public static List<String> genDependencyListFromMinecraftJson(String version) {
        return StreamSupport.stream(VersionManifest.getVersion(version).getAsJsonArray("libraries").spliterator(), true)
                .map(ele->ele.getAsJsonObject().get("downloads").getAsJsonObject()).filter(obj->obj.has("artifact"))
                .map(obj->obj.get("artifact").getAsJsonObject().get("url").getAsString()).map(URL::new).map(url -> url.getPath().substring(1))
                .map(s -> {
                    String[] strings = s.split("/");
                    int needLen = strings.length - 1;
                    StringBuilder builder = new StringBuilder();
                    for(int i = 0; i < needLen - 2; i++) {
                        builder.append(strings[i]);
                        if(i < needLen - 3) builder.append('.');
                    }
                    return builder.append(':').append(strings[needLen - 2]).append(':').append(strings[needLen - 1]).toString();
                }).collect(Collectors.toList());
    }
}