package main.content;

import arc.util.Log;
import mindustry.type.SectorPreset;

public class WSectorPreset {
    public static SectorPreset sector_v;
    public static void load() {
        sector_v = new SectorPreset("sector-v", WPlanets.destruction, 5){{
            alwaysUnlocked = true;
            addStartingItems = true;
            difficulty = 1;
            Log.info("[WoodenMindustry]" + this.sector.planet.sectors);
            Log.info("[WoodenMindustry]" + this.sector.planet.sectors.get(5).preset.name);
        }};
    }
}
