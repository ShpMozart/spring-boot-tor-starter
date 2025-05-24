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

No need to manually edit `torrc`, configure ports, or handle service directories. Just include the dependency and enable Tor in your properties.

---

## 🧠 Why would I use this?

This starter is ideal for:
- **Anonymous deployments** on the dark web (e.g. private APIs, dashboards, chat systems)
- Building **privacy-focused** services with Spring Boot
- Educational purposes: learning how Tor and hidden services work in Java


