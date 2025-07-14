package com.github.xef5000.ultimateCoinflip.api.events;

import com.github.xef5000.ultimateCoinflip.api.models.CoinflipColor;
import com.github.xef5000.ultimateCoinflip.api.models.CoinflipOffer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CoinflipAcceptedEvent extends Event implements Cancellable  {

    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled;

    private final Player creator;
    private final Player accepter;
    private final CoinflipOffer offer;
    private final CoinflipColor accepterColor;

    /**
     * Accepter will win if forceWin is true
     * */
    private boolean forceWin;

    public CoinflipAcceptedEvent(Player creator, Player accepter, CoinflipOffer offer, CoinflipColor accepterColor, boolean forceWin) {
        this.creator = creator;
        this.accepter = accepter;
        this.offer = offer;
        this.accepterColor = accepterColor;
        this.forceWin = forceWin;
    }

    public Player getCreator() {
        return creator;
    }

    public Player getAccepter() {
        return accepter;
    }

    public CoinflipOffer getOffer() {
        return offer;
    }

    public CoinflipColor getAccepterColor() {
        return accepterColor;
    }

    public boolean isForceWin() {
        return forceWin;
    }

    public void setForceWin(boolean forceWin) {
        this.forceWin = forceWin;
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
