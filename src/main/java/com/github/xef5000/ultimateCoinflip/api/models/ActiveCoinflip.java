package com.github.xef5000.ultimateCoinflip.api.models;

import java.util.UUID;

public interface ActiveCoinflip {

    /**
     * Get the creator's UUID
     * @return The creator's UUID
     */
    UUID getCreatorUUID();

    /**
     * Get the creator's name
     * @return The creator's name
     */
    String getCreatorName();

    /**
     * Get the accepter's UUID
     * @return The accepter's UUID
     */
    UUID getAccepterUUID();

    /**
     * Get the accepter's name
     * @return The accepter's name
     */
    String getAccepterName();

    /**
     * Get the bet amount
     * @return The bet amount
     */
    double getAmount();

    /**
     * Get the creator's selected color
     * @return The creator's color
     */
    CoinflipColor getCreatorColor();

    /**
     * Get the accepter's selected color
     * @return The accepter's color
     */
    CoinflipColor getAccepterColor();

    /**
     * Get the start time of this coinflip
     * @return The start time in milliseconds
     */
    long getStartTime();

    /**
     * Check if the creator wins this coinflip
     * @return True if creator wins, false if accepter wins
     */
    boolean doesCreatorWin();

    /**
     * Get the winner's UUID
     * @return The winner's UUID
     */
    UUID getWinnerUUID();

    /**
     * Get the winner's name
     * @return The winner's name
     */
    String getWinnerName();

    /**
     * Get the loser's UUID
     * @return The loser's UUID
     */
    UUID getLoserUUID();

    /**
     * Get the loser's name
     * @return The loser's name
     */
    String getLoserName();

    /**
     * Get the winner's color
     * @return The winner's color
     */
    CoinflipColor getWinnerColor();

    /**
     * Get the loser's color
     * @return The loser's color
     */
    CoinflipColor getLoserColor();

    /**
     * Get the currency for this coinflip
     * @return The currency name
     */
    String getCurrency();

    /**
     * Check if a player is involved in this coinflip
     * @param playerUUID The player's UUID
     * @return True if the player is either creator or accepter
     */
    boolean isPlayerInvolved(UUID playerUUID);
}
