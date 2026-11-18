package com.samscreations.samsfishing.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/** A fishing competition started (by schedule, command or API). */
public final class CompetitionStartEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final String id;
    private final String type;
    private final int minutes;

    public CompetitionStartEvent(String id, String type, int minutes) {
        this.id = id;
        this.type = type;
        this.minutes = minutes;
    }

    /** Its id in competitions.yml. */
    public String getId() {
        return id;
    }

    /** largest-fish, most-fish, total-size, specific-fish or specific-rarity (random is already resolved). */
    public String getType() {
        return type;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
