package com.samscreations.samsfishing.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * A fish bit and SamsFishing picked a catch for it, before the minigame starts (or before it is handed over when
 * its rarity plays none). Cancel it to let vanilla fishing happen instead (in lava: nothing).
 */
public final class FishHookedEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final String catchId;
    private final String rarity;
    private final boolean lava;
    private boolean cancelled;

    public FishHookedEvent(Player player, String catchId, String rarity, boolean lava) {
        this.player = player;
        this.catchId = catchId;
        this.rarity = rarity;
        this.lava = lava;
    }

    public Player getPlayer() {
        return player;
    }

    /** The catch id from catches/*.yml. */
    public String getCatchId() {
        return catchId;
    }

    public String getRarity() {
        return rarity;
    }

    /** True when the bobber is in lava. */
    public boolean isLava() {
        return lava;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
