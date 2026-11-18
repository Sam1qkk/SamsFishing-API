package com.samscreations.samsfishing.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;
import java.util.UUID;

/** A fishing competition ended. */
public final class CompetitionEndEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final String id;
    private final List<UUID> standings;
    private final boolean rewarded;

    public CompetitionEndEvent(String id, List<UUID> standings, boolean rewarded) {
        this.id = id;
        this.standings = List.copyOf(standings);
        this.rewarded = rewarded;
    }

    public String getId() {
        return id;
    }

    /** Everyone who scored, best first. */
    public List<UUID> getStandings() {
        return standings;
    }

    /** False when it was stopped without rewards (server shutdown). */
    public boolean isRewarded() {
        return rewarded;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
