package com.mozart;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@ConfigurationProperties(prefix = "tor")
public class TorProperties {
    private boolean enabled = true;
    private int controlPort = 9051;
    private int socksPort = 9050;
    private String hiddenServiceDir = "tor-hidden-service";
    private int hiddenServicePort = 80;
    private int servicePort = 8080;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getControlPort() {
        return controlPort;
    }

    public void setControlPort(int controlPort) {
        this.controlPort = controlPort;
    }

    public int getSocksPort() {
        return socksPort;
    }

    public void setSocksPort(int socksPort) {
        this.socksPort = socksPort;
    }

    public String getHiddenServiceDir() {
        return hiddenServiceDir;
    }

    public void setHiddenServiceDir(String hiddenServiceDir) {
        this.hiddenServiceDir = hiddenServiceDir;
    }

    public int getHiddenServicePort() {
        return hiddenServicePort;
    }

    public void setHiddenServicePort(int hiddenServicePort) {
        this.hiddenServicePort = hiddenServicePort;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(int servicePort) {
        this.servicePort = servicePort;
    }
}