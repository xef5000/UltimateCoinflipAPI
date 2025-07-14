# UltimateCoinflip API

A Java API for interacting with the UltimateCoinflip plugin, allowing you to manage coinflip offers, retrieve player statistics, and integrate with custom plugins.

## Table of Contents
- [Getting Started](#getting-started)
- [API Overview](#api-overview)
- [DataManager Usage](#datamanager-usage)
- [Models](#models)
- [Events](#events)
- [Example Usage](#example-usage)
- [Support](#support)

---

## Getting Started

1. **Add the API as a dependency**
   - If using Maven, add the following to your `pom.xml`:
     ```xml
     <dependency>
       <groupId>com.github.xef5000</groupId>
       <artifactId>ultimatecoinflip-api</artifactId>
       <version>1.1.1</version>
       <scope>provided</scope>
     </dependency>
     ```
   - Or add the JAR directly to your plugin's `libs` folder.

2. **Import the API in your plugin**
   - Ensure your plugin depends on UltimateCoinflip in `plugin.yml`:
     ```yaml
     depend: [UltimateCoinflip]
     ```

## API Overview

The main entry point is the `UltimateCoinflipAPI` interface. You can obtain an instance via the plugin:

```java
UltimateCoinflipAPI api = (UltimateCoinflipAPI) Bukkit.getServer().getPluginManager().getPlugin("UltimateCoinflip");
```

The API provides access to the `DataManager`, which exposes all main features.

## DataManager Usage

The `DataManager` interface provides methods to:

- Retrieve player stats:
  - `PlayerStats getPlayerStats(Player player);`
  - `PlayerStats getPlayerStats(UUID uuid, String name);`
  - `Collection<? extends PlayerStats> getAllPlayerStats();`
- Manage coinflip offers:
  - `void addCoinflipOffer(Player player, double amount, int timeoutSeconds, CoinflipColor selectedColor, String currency);`
  - `void removeCoinflipOffer(UUID playerUUID, boolean returnMoney);`
  - `CoinflipOffer getCoinflipOffer(UUID playerUUID);`
  - `List<? extends CoinflipOffer> getActiveOffers();`
  - `boolean hasActiveOffer(UUID playerUUID);`

## Models

### CoinflipOffer
Represents a coinflip offer. Key methods:
- `UUID getPlayerUUID()`
- `String getPlayerName()`
- `double getAmount()`
- `int getTimeoutSeconds()`
- `CoinflipColor getSelectedColor()`
- `String getCurrency()`
- `boolean isExpired()`
- `long getTimeRemaining()`

### PlayerStats
Represents player statistics. Key methods:
- `UUID getPlayerUUID()`
- `String getPlayerName()`
- `int getGamesPlayed()`, `getGamesWon()`, `getGamesLost()`
- `double getTotalWon()`, `getTotalLost()`, `getNetProfit()`
- `double getTotalWon(String currency)`, `getTotalLost(String currency)`

### CoinflipColor
Enum of available colors:
- RED, BLUE, GREEN, YELLOW, ORANGE, PURPLE, PINK, WHITE, BLACK

## Events

The API provides events in the `events` package for listening to coinflip-related actions. (See the `events/` directory for available events and usage.)

## Example Usage

```java
UltimateCoinflipAPI api = ...;
DataManager dataManager = api.getDataManager();

// Add a coinflip offer
Player player = ...;
dataManager.addCoinflipOffer(player, 100.0, 60, CoinflipColor.RED, "vault");

// Get player stats
PlayerStats stats = dataManager.getPlayerStats(player);
int wins = stats.getGamesWon();

// List all active offers
List<? extends CoinflipOffer> offers = dataManager.getActiveOffers();
```

## Support
For questions or support, open an issue on the GitHub repository or contact the plugin author.

