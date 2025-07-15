package com.github.xef5000.ultimateCoinflip.api.models;

public interface Currency {
    String getName();
    String getSymbol();
    double getMinBet();
    double getMaxBet();
    CurrencyIntegration getIntegration();
}
