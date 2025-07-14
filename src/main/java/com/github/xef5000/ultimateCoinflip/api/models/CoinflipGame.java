package com.github.xef5000.ultimateCoinflip.api.models;

import java.util.UUID;

/**
 * Represents a coinflip game instance between two players.
 */
public interface CoinflipGame {

    /**
     * Get the game's unique ID.
     * @return the game UUID
     */
    UUID getGameId();

    /**
     * Get the creator's UUID.
     * @return the creator's UUID
     */
    UUID getCreatorUUID();

    /**
     * Get the creator's name.
     * @return the creator's name
     */
    String getCreatorName();

    /**
     * Get the accepter's UUID.
     * @return the accepter's UUID
     */
    UUID getAccepterUUID();

    /**
     * Get the accepter's name.
     * @return the accepter's name
     */
    String getAccepterName();

    /**
     * Get the bet amount.
     * @return the bet amount
     */
    double getAmount();

    /**
     * Get the creator's selected color.
     * @return the creator's coinflip color
     */
    CoinflipColor getCreatorColor();

    /**
     * Get the accepter's selected color.
     * @return the accepter's coinflip color
     */
    CoinflipColor getAccepterColor();

    /**
     * Get the start time of this coinflip.
     * @return the start timestamp (in milliseconds)
     */
    long getStartTime();

    /**
     * Check if the creator wins this coinflip.
     * @return true if the creator won, false otherwise
     */
    boolean doesCreatorWin();

    /**
     * Get the winner's UUID.
     * @return the winner's UUID
     */
    UUID getWinnerUUID();

    /**
     * Get the winner's name.
     * @return the winner's name
     */
    String getWinnerName();

    /**
     * Get the loser's UUID.
     * @return the loser's UUID
     */
    UUID getLoserUUID();

    /**
     * Get the loser's name.
     * @return the loser's name
     */
    String getLoserName();

    /**
     * Get the winner's color.
     * @return the winner's coinflip color
     */
    CoinflipColor getWinnerColor();

    /**
     * Get the loser's color.
     * @return the loser's coinflip color
     */
    CoinflipColor getLoserColor();

    /**
     * Get the current status of the game.
     * @return the coinflip status
     */
    CoinflipStatus getStatus();

    /**
     * Check if a player is involved in this coinflip.
     * @param playerUUID the UUID of the player to check
     * @return true if the player is either creator or accepter
     */
    boolean isPlayerInvolved(UUID playerUUID);

    /**
     * Check if the game results have been processed.
     * @return true if the results were processed, false otherwise
     */
    boolean areResultsProcessed();

    /**
     * Get the currency for this game.
     * @return the currency name
     */
    String getCurrency();
}
