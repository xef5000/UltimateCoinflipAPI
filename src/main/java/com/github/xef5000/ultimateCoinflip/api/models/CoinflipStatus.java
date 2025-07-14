package com.github.xef5000.ultimateCoinflip.api.models;

public enum CoinflipStatus {
    PENDING,    // Game created but not started
    ROLLING,    // Game is in progress (animation playing)
    COMPLETED,  // Game has completed and results processed
    CANCELLED   // Game was cancelled (e.g., player disconnected)
}
