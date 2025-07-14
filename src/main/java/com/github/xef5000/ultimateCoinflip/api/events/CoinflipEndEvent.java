package com.github.xef5000.ultimateCoinflip.api.events;

import com.github.xef5000.ultimateCoinflip.api.models.CoinflipGame;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Used for tracking only
 * */
public class CoinflipEndEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final CoinflipGame coinflip;

    public CoinflipEndEvent(CoinflipGame coinflip) {
        this.coinflip = coinflip;
    }

    public CoinflipGame getCoinflip() {
        return coinflip;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
