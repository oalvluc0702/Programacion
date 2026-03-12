# ⚔️ RPG Data Manager - Practica 7

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-COMPLETADO-brightgreen?style=for-the-badge&logo=checkmarx)

> **Progreso del Proyecto:** > ████████████████████ 100% Completado

Bienvenido al repositorio de **RPG Data Manager**. Este proyecto es un sistema robusto de gestión de datos para un entorno de juego de rol (RPG).

---

## 📂 Navegación Rápida

| Módulo | Acceso Directo | Descripción |
| :--- | :--- | :--- |
| 🚀 **Core** | [**Ir al Main**](./src/com/rpg/main/Main.java) | Punto de entrada del sistema |
| 💾 **Datos** | [**Ver Ficheros**](./ficheros) | Base de datos JSON y logs |
| 🛠️ **Utilidades** | [**Explorar Utils**](./src/com/rpg/utils) | Helpers de lectura y escritura |
| ⚠️ **Errores** | [**Gestionar Excepciones**](./src/com/rpg/handler) | Control de errores personalizado |

---

## 🛠️ Estructura de Directorios

> [!IMPORTANT]
> Los enlaces a continuación te redirigirán directamente al código fuente dentro de este repositorio.

### 📦 [Recursos y Ficheros](./ficheros)
* [📄 `ciudades.txt`](./ficheros/ciudades.txt) — *Listado plano de locaciones.*
* [📜 `errores.log`](./ficheros/errores.log) — *Registro histórico de excepciones.*
* [💎 `items.json`](./ficheros/items.json) — *Base de datos de objetos.*
* [👥 `personajes.json`](./ficheros/personajes.json) — *Datos de héroes y NPCs.*

### 💻 [Lógica del Sistema (src)](./src/com/rpg)
* [🛡️ **Handlers**](./src/com/rpg/handler) — Sistema de excepciones: `DatoInvalido`, `FormatoInvalido`, etc.
* [🏗️ **Models**](./src/com/rpg/model) — Clases POJO: `Ciudades`, `Items`, `Personajes`.
* [⚙️ **Services**](./src/com/rpg/services) — Orquestador de datos: `GestionMundo`.
* [🧰 **Utils**](./src/com/rpg/utils) — Parsers y utilidades de sistema.

---