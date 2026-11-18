# SamsFishing API

The developer API of [SamsFishing](https://docs.samscreations.eu/samsfishing), the custom fishing plugin by
SamsCreations: read and change players' fishing progress, create catches and gear, start competitions and listen
to fishing events.

The plugin itself is sold on BuiltByBit; this repository only contains the API your plugin compiles against.

## Adding it

Gradle (through [JitPack](https://jitpack.io)):

```groovy
repositories {
    maven { url = 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.Sam1qkk:SamsFishing-API:1.0.0'
}
```

Maven:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.Sam1qkk</groupId>
    <artifactId>SamsFishing-API</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

And in your `plugin.yml`:

```yaml
softdepend: [SamsFishing]
```

## Using it

```java
SamsFishingAPI fishing = SamsFishingProvider.get();   // null when SamsFishing is not installed
if (fishing != null) {
    int level = fishing.level(player);
    fishing.addXp(player, 50);
    ItemStack pike = fishing.createCatch("pike", 92.5, player);
    ItemStack rod = fishing.createGear("carbon_rod", 1);
}
```

| Method | What it does |
| --- | --- |
| `catchIds()`, `gearIds()` | Every catch / rod, bait, hook and totem id |
| `createCatch(id, size, catcher)`, `createGear(id, amount)` | Items exactly as players get them |
| `catchId(item)`, `catchSize(item)`, `gearId(item)` | Read a SamsFishing item |
| `rarity(catchId)`, `worth(item)` | Rarity id, market value |
| `totalCaught(player)`, `speciesCaught(player)`, `personalBest(player, catchId)` | Records |
| `level(player)`, `xp(player)`, `addXp(player, amount)` | Fishing levels |
| `runningCompetition()`, `startCompetition(id, minutes)` | Competitions |

## Events

| Event | When |
| --- | --- |
| `FishHookedEvent` | A catch was picked for a bite, before the minigame. Cancellable. |
| `FishCaughtEvent` | A catch was landed (with its size, item, new species / new record). |
| `FishingLevelUpEvent` | A player reached a new fishing level. |
| `CompetitionStartEvent` | A competition started. |
| `CompetitionEndEvent` | A competition ended (standings, rewarded or not). |

```java
@EventHandler
public void onCatch(FishCaughtEvent event) {
    if (event.getRarity().equals("legendary")) {
        Bukkit.broadcast(Component.text(event.getPlayer().getName() + " caught a legend!"));
    }
}
```

## Addons

SamsFishing also loads addon jars from `plugins/SamsFishing/addons/` (like its in-game editor). See
[Addons](https://docs.samscreations.eu/samsfishing/developers/addons) in the wiki.

## Support

Questions or ideas: [Discord](https://discord.gg/KrvMkMDE2W).
