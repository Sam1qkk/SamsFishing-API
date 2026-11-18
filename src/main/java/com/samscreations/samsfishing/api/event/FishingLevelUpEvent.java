package com.samscreations.samsfishing.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/** A player reached a new fishing level (once per level, after its rewards ran). */
public final class FishingLevelUpEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final int level;

    public FishingLevelUpEvent(Player player, int level) {
        this.player = player;
        this.level = level;
    }

    public Player getPlayer() {
        return player;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
