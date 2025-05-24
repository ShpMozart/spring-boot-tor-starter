package com.mozart;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.concurrent.Executors;

@Service
public class TorService {
    private Process torProcess;
    public void startTor(String torrcPath, String workingDirectory) throws IOException {
        System.out.println("Starting Tor with config: " + torrcPath);
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("tor", "-f", torrcPath);
        processBuilder.directory(new File(workingDirectory));

        System.out.println("Starting Tor process...");
        torProcess = processBuilder.start();
        
        Executors.newSingleThreadExecutor().submit(() -> {
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(torProcess.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("TOR OUTPUT: "+ line);
                }
            } catch (IOException e) {
                System.err.println("Error reading Tor output" + e.getMessage());
            }
        });
        
        Runtime.getRuntime().addShutdownHook(new Thread(this::stopTor));
    }
    
    public void stopTor() {
        if (torProcess != null && torProcess.isAlive()) {
            System.out.println("Stopping Tor process...");
            torProcess.destroy();
        }
    }
}