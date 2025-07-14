package com.github.xef5000.ultimateCoinflip.api.managers;

import com.github.xef5000.ultimateCoinflip.api.models.CoinflipColor;
import com.github.xef5000.ultimateCoinflip.api.models.CoinflipOffer;
import com.github.xef5000.ultimateCoinflip.api.models.PlayerStats;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface DataManager {
    PlayerStats getPlayerStats(Player player);

    PlayerStats getPlayerStats(UUID uuid, String name);

    /**
     * Get all player stats
     * @return Collection of all player stats
     */
    Collection<? extends PlayerStats> getAllPlayerStats();

    void addCoinflipOffer(Player player, double amount, int timeoutSeconds, CoinflipColor selectedColor, String currency);

    /**
     * Removes a coinflip offer
     *
     * @param playerUUID The UUID of the player who created the offer
     * @param returnMoney Whether to return the money to the player (true for expired offers, false for accepted offers)
     */
    void removeCoinflipOffer(UUID playerUUID, boolean returnMoney);

    CoinflipOffer getCoinflipOffer(UUID playerUUID);

    List<? extends CoinflipOffer> getActiveOffers();

    boolean hasActiveOffer(UUID playerUUID);

}
