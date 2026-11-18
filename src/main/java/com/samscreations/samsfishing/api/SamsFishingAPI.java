package com.samscreations.samsfishing.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

/**
 * The SamsFishing developer API. Get it with {@link SamsFishingProvider#get()} once SamsFishing is enabled
 * (add {@code softdepend: [SamsFishing]} or {@code depend} to your plugin.yml).
 *
 * <p>Ids are the keys used in SamsFishing's files: catch ids from {@code catches/*.yml}, gear ids from
 * {@code gear/*.yml} (rods, baits, hooks and totems).
 */
public interface SamsFishingAPI {

    // ------------------------------------------------------------------ catches

    /** Every catch id currently loaded. */
    Set<String> catchIds();

    /** A catch item as players get it, with its size (cm), rarity lore and tag. Null for an unknown id. */
    ItemStack createCatch(String catchId, double size, Player catcher);

    /** The catch id of a SamsFishing catch item, or null for any other item. */
    String catchId(ItemStack item);

    /** The size (cm) of a SamsFishing catch item, or 0 for any other item. */
    double catchSize(ItemStack item);

    /** The rarity id (common, rare, epic, legendary, ...) of a catch, or null for an unknown id. */
    String rarity(String catchId);

    /** What the market pays for this stack (all of it), or 0 when it is not a fish or the market is off. */
    double worth(ItemStack item);

    // ------------------------------------------------------------------ gear

    /** Every rod, bait, hook and totem id. */
    Set<String> gearIds();

    /** A rod, bait, hook or totem item; null for an unknown id. */
    ItemStack createGear(String gearId, int amount);

    /** The gear id of a SamsFishing rod, bait, hook or totem item, or null. */
    String gearId(ItemStack item);

    // ------------------------------------------------------------------ players

    /** Fish caught in all (online players). */
    int totalCaught(Player player);

    /** Different species caught (online players). */
    int speciesCaught(Player player);

    /** The biggest fish of one catch the player landed (cm), or 0. */
    double personalBest(Player player, String catchId);

    /** The player's fishing level (1 and up). */
    int level(Player player);

    /** The player's fishing XP in total. */
    long xp(Player player);

    /** Gives fishing XP (level ups, rewards and messages happen as for a catch). */
    void addXp(Player player, long amount);

    // ------------------------------------------------------------------ competitions

    /** The id of the running competition, or null. */
    String runningCompetition();

    /** Starts a competition from competitions.yml; false when the id is unknown or one is already running. */
    boolean startCompetition(String id, int minutes);
}
