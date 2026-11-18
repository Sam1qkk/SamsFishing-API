package com.samscreations.samsfishing.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/** A player landed a catch (won the minigame, or its rarity plays none). Fired after the item was given. */
public final class FishCaughtEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final String catchId;
    private final String rarity;
    private final double size;
    private final ItemStack item;
    private final boolean newSpecies;
    private final boolean newRecord;

    public FishCaughtEvent(Player player, String catchId, String rarity, double size, ItemStack item,
                           boolean newSpecies, boolean newRecord) {
        this.player = player;
        this.catchId = catchId;
        this.rarity = rarity;
        this.size = size;
        this.item = item;
        this.newSpecies = newSpecies;
        this.newRecord = newRecord;
    }

    public Player getPlayer() {
        return player;
    }

    public String getCatchId() {
        return catchId;
    }

    public String getRarity() {
        return rarity;
    }

    /** Size in cm. */
    public double getSize() {
        return size;
    }

    /** A copy of the item the player got (null when it is not known, e.g. vanilla handed it over). */
    public ItemStack getItem() {
        return item == null ? null : item.clone();
    }

    /** The first fish of this kind for the player. */
    public boolean isNewSpecies() {
        return newSpecies;
    }

    /** Bigger than the player's earlier best of this kind. */
    public boolean isNewRecord() {
        return newRecord;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
