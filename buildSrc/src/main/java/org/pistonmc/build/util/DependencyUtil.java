package org.pistonmc.build.util;

import com.google.gson.JsonObject;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.spi.FileSystemProvider;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DependencyUtil {
    private static final FileSystemProvider JAR_FSP;
    static {
        FileSystemProvider provider = null;
        for (FileSystemProvider p: FileSystemProvider.installedProviders()) {
            if(p.getScheme().equalsIgnoreCase("jar")) {
                provider = p;
            }
        }
        if(provider == null) throw new IllegalStateException("jar/zip file system provider does not exist");
        JAR_FSP = provider;
    }
//    project.getDependencies().add("implementation", project.files(genDependencyFromMinecraftJson((String)
//            project.getRootProject().getExtensions().getByType(ExtraPropertiesExtension.class).get("MC_VERSION"), PROCESS_DIR)));
    public static File genDependencyFromMinecraftJson(String version, File dir) {
        JsonObject server = VersionManifest.getVersion(version).get("downloads").getAsJsonObject().get("server").getAsJsonObject();
        Path file = dir.toPath().resolve("server.jar");
        Path fileProcessed = dir.toPath().resolve(version + "_server_processed.jar");
        try {
            Files.deleteIfExists(fileProcessed);
        } catch(Throwable ignored) { return fileProcessed.toFile(); }
        if(Files.exists(file)) {
            if(Files.isDirectory(file)) Files.delete(file);
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            String sha1 = server.get("sha1").getAsString();
            StringBuilder actual = new StringBuilder();
            for(byte i : md.digest(Files.readAllBytes(file))) {
                String s = Integer.toHexString(i);
                if(s.length() < 2) actual.append('0');
                actual.append(s);
            }
            if(!sha1.contentEquals(actual)) {
                System.err.println("Hash doesn't match. Redownloading jar...");
                Files.delete(file);
            }
        }
        if(Files.notExists(file)) {
            try(NetworkUtil.Net.Connection connection = NetworkUtil.newBuilder(server.get("url").getAsString()).connect()) {
                Files.copy(connection.asStream(), file, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        try(FileSystem jarFs = JAR_FSP.newFileSystem(file, Collections.emptyMap());
            FileSystem processedJarFs = JAR_FSP.newFileSystem(fileProcessed, Collections.singletonMap("create", "true"));
            Stream<Path> sp = Files.list(jarFs.getPath("/")).filter(p -> p.toString().endsWith(".class")).parallel()) {
            List<String> excludes = sp.map(p -> p.getFileName().toString()).collect(Collectors.toList());
            try(Stream<Path> sp1 = Files.walk(jarFs.getPath("/")).skip(1L).map(jarFs.getPath("/")::relativize)
                    .filter(p -> !p.startsWith("net")).filter(p -> !excludes.contains(p.toString())).parallel()) {
                sp1.forEach(p -> {
                    Path path = processedJarFs.getPath(p.toString());
                    if(Files.isDirectory(p)) Files.createDirectories(path);
                    else {
                        Path parent = path.getParent();
                        if(parent != null && Files.notExists(parent)) Files.createDirectories(parent);
                        Files.copy(p, path);
                    }
                });
            }
        }
        return fileProcessed.toFile();
    }
}
