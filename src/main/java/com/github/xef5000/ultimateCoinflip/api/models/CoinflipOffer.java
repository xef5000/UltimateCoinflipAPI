package com.github.xef5000.ultimateCoinflip.api.models;

import java.util.UUID;

public interface CoinflipOffer {

    UUID getPlayerUUID();
    String getPlayerName();
    double getAmount();
    long getCreationTime();
    boolean isExpired();
    long getTimeRemaining();
    int getTimeRemainingSeconds();

    /**
     * Get the timeout seconds for this offer
     *
     * @return The timeout seconds
     */
    int getTimeoutSeconds();

    /**
     * Get the selected color for this offer
     *
     * @return The selected color
     */
    CoinflipColor getSelectedColor();

    /**
     * Get the currency for this offer
     *
     * @return The currency name
     */
    String getCurrency();
}
