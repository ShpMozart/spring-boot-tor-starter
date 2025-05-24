package com.mozart;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

@AutoConfiguration
@EnableConfigurationProperties(TorProperties.class)
public class TorAutoConfiguration {

    @Bean
    public TorService torService(TorProperties properties) {
        try {
            Path workingDir = Paths.get(System.getProperty("user.dir"));
            Path hiddenServiceDir = workingDir.resolve(properties.getHiddenServiceDir());

            Files.createDirectories(hiddenServiceDir);

            Files.createDirectories(hiddenServiceDir);

            try {
                Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwx------");
                Files.setPosixFilePermissions(hiddenServiceDir, perms);
            } catch (UnsupportedOperationException e) {
                System.out.println("Skipping permission setting: not a POSIX-compliant OS");
            }

            Path torrcPath = workingDir.resolve("torrc");
            String torrcContent = buildTorConfig(properties, hiddenServiceDir);

            Files.writeString(torrcPath, torrcContent, StandardCharsets.UTF_8);

            System.out.println("Tor config content:\n" + torrcContent);
            System.out.println("Tor config path: " + torrcPath.toAbsolutePath());

            TorService service = new TorService();
            service.startTor(torrcPath.toString(), workingDir.toString());
            return service;

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Tor", e);
        }
    }
    private String buildTorConfig(TorProperties props, Path hiddenServiceDir) {
        return String.format(
                        "SocksPort %d\n" +
                        "ControlPort %d\n" +
                        "HiddenServiceDir %s\n" +
                        "HiddenServicePort %d 127.0.0.1:%d\n",
                props.getSocksPort(),
                props.getControlPort(),
                hiddenServiceDir.toString().replace("\\", "/"),
                props.getHiddenServicePort(),
                props.getServicePort());
    }
}