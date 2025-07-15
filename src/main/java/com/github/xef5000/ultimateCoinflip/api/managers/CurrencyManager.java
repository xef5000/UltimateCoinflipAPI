package com.github.xef5000.ultimateCoinflip.api.managers;

import com.github.xef5000.ultimateCoinflip.api.models.Currency;
import com.github.xef5000.ultimateCoinflip.api.models.CurrencyIntegration;
import com.github.xef5000.ultimateCoinflip.api.models.IntegrationFactory;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;

public interface CurrencyManager {

    /**
     * Registers a new custom currency integration. This allows other plugins
     * to add support for their own economy systems.
     *
     * @param name    The unique name for the integration (e.g., "MyCoolEconomy").
     * @param factory The factory that will create instances of this integration.
     */
    void registerIntegration(@NotNull String name, @NotNull IntegrationFactory factory);

    /**
     * Creates a CurrencyIntegration instance based on its registered name.
     * This is the method your config loading logic will now use.
     *
     * @param name   The name of the integration (e.g., "VAULT", "COINSENGINE").
     * @param config The ConfigurationSection for this currency.
     * @return An Optional containing the integration if successful, or empty if not found or an error occurred.
     */
    Optional<CurrencyIntegration> createIntegration(@NotNull String name, @NotNull ConfigurationSection config);

    Currency getCurrency(String currencyName);

    /**
     * Check if a currency is valid
     *
     * @param currencyName The currency name to check
     * @return true if the currency exists and is valid
     */
    boolean isValidCurrency(String currencyName);

    Collection<? extends Currency> getCurrencies();
}
