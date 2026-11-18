package com.samscreations.samsfishing.api;

import org.bukkit.Bukkit;

/** Where to get the {@link SamsFishingAPI}: SamsFishing registers it with Bukkit's services manager. */
public final class SamsFishingProvider {

    private SamsFishingProvider() {
    }

    /** The API, or null when SamsFishing is not enabled. */
    public static SamsFishingAPI get() {
        return Bukkit.getServicesManager().load(SamsFishingAPI.class);
    }
}
