package com.github.xef5000.ultimateCoinflip.api.models;

import java.util.Map;
import java.util.UUID;

public interface PlayerStats {

    UUID getPlayerUUID();

    String getPlayerName();

    int getGamesPlayed();

    int getGamesWon();

    int getGamesLost();

    /**
     * Get overall total amount won across all currencies.
     * @return The overall total amount won.
     */
    double getTotalWon();

    /**
     * Get overall total amount lost across all currencies.
     * @return The overall total amount lost.
     */
    double getTotalLost();

    /**
     * Get total amount won for a specific currency.
     * @param currency The currency identifier.
     * @return The total amount won for that currency.
     */
    double getTotalWon(String currency);

    /**
     * Get total amount lost for a specific currency.
     * @param currency The currency identifier.
     * @return The total amount lost for that currency.
     */
    double getTotalLost(String currency);

    /**
     * Get overall net profit across all currencies.
     * @return The overall net profit.
     */
    double getNetProfit();

    /**
     * Get net profit for a specific currency.
     * @param currency The currency identifier.
     * @return The net profit for that currency.
     */
    double getNetProfit(String currency);

    double getWinRate();

    /**
     * Get the player's luck value
     * @return The player's luck value
     */
    int getLuck();

    /**
     * Adds a win for a specific currency.
     * @param amount The amount won.
     * @param currency The currency of the win.
     */
    void addWin(double amount, String currency);

    /**
     * Adds a loss for a specific currency.
     * @param amount The amount lost.
     * @param currency The currency of the loss.
     */
    void addLoss(double amount, String currency);

    /**
     * Add to the player's luck value
     * @param amount The amount to add
     */
    void addLuck(int amount);

    /**
     * Remove from the player's luck value
     * @param amount The amount to remove
     */
    void removeLuck(int amount);

    /**
     * Set the player's luck value
     * @param luck The new luck value
     */
    void setLuck(int luck);

    /**
     * Get the map of total won amounts by currency.
     * @return A map where keys are currency identifiers and values are total amounts won.
     */
    Map<String, Double> getTotalWonByCurrency();

    /**
     * Get the map of total lost amounts by currency.
     * @return A map where keys are currency identifiers and values are total amounts lost.
     */
    Map<String, Double> getTotalLostByCurrency();
}
