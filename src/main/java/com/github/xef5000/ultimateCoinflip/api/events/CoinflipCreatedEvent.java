package com.github.xef5000.ultimateCoinflip.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a new coinflip game is created by a player.
 * <p>
 * This event is cancellable. If another plugin cancels this event,
 * the coinflip game will not be created or registered.
 */
public class CoinflipCreatedEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled;

    private final Player creator;
    private final double amount;
    private final String currency;

    /**
     * The default constructor.
     *
     * @param isAsync Whether this event is being called from an asynchronous thread.
     */
    public CoinflipCreatedEvent(boolean isAsync, Player creator, double amount, String currency) {
        super(isAsync);
        this.creator = creator;
        this.amount = amount;
        this.currency = currency;
        this.cancelled = false;
    }

    public Player getCreator() {
        return creator;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
