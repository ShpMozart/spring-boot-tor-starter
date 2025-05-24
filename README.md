# 🌐 Spring Boot Tor Starter

> Expose your Spring Boot application as a **Tor hidden service (.onion)** — automatically, securely, and with zero hassle.

![Java](https://img.shields.io/badge/java-17%2B-blue.svg)
![Spring Boot](https://img.shields.io/badge/spring--boot-3.x-brightgreen)
![Tor](https://img.shields.io/badge/tor--network-supported-purple)

---

## 🚀 What is it?

**Spring Boot Tor Starter** is an auto-configuration library that:

- Automatically generates the `torrc` configuration file
- Creates a Tor hidden service directory (with proper permissions)
- Starts the Tor process in the background
- Reads and exposes the generated `.onion` address from the `hostname` file

No need to manually edit `torrc`, configure ports, or handle service directories.  
Just include the dependency and enable Tor in your `application.properties`.

---

## 🔒 Use Cases

- Anonymous deployments on the **dark web**
- Privacy-focused APIs and dashboards
- Educational purposes — learning how Tor + Java work together

---

## ⚙️ Requirements

- Java 17+
- Spring Boot 3.x
- ✅ **Tor must be installed on your system** and accessible via `tor` command

You can install Tor from [https://www.torproject.org/download/](https://www.torproject.org/download/)

---

## 📦 How to install locally

Until the library is published to Maven Central, install it manually in your local Maven repo:

```bash
mvn install:install-file \
  -Dfile=target/spring-boot-tor-starter-1.0.0.jar \
  -DgroupId=com.mozart \
  -DartifactId=spring-boot-tor-starter \
  -Dversion=1.0.0 \
  -Dpackaging=jar
```

then add it to pom.xml 
```xml
<dependency>
  <groupId>com.mozart</groupId>
  <artifactId>spring-boot-tor-starter</artifactId>
  <version>1.0</version>
</dependency>
```

