# ⚔️ Quest of the Realms

## 📌 Overview
This project is a Java-based console RPG.It allows players to explore a fantasy world, 
engage in combat, manage inventory and progress through a structured game system.

---

## 🚀 Features

- 🎮 Console-based RPG gameplay
- ⚔️ Turn-based combat system
- 🧭 World exploration and movement system
- 🎒 Inventory and item management
- 🧙 Player progression and stats system
- 💾 Game state persistence
- ⚡ Server-side game logic (REST-style API via Spring Boot)
- 🔄 Background processing for game mechanics (auto-save, regeneration)

---

## 🧠 Architecture & Design

The project follows a layered backend-inspired architecture:

- **Client-Server Model** – game logic is handled via server communication
- **REST-like API (Spring Boot)** – internal endpoints for game actions
- **Service Layer** – core game logic is separated from controllers
- **State Management System** – persistent game sessions
- **Modular Design** – components for combat, inventory, and world logic

---

## 📡 Game System Design

The game is structured around:

- Player state (stats(health, mana, attack damage), inventory)
- World map system
- Combat engine
- Item and equipment system
- Session-based progression

---

## 🧪 Technologies & Tools

- Java 23
- Spring Boot
- REST API design
- Multithreading & concurrency
- JSON serialization
- File I/O
- OOP principles
