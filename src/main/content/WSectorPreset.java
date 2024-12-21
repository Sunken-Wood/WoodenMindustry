package main.content;

import arc.util.Log;
import mindustry.type.SectorPreset;

public class WSectorPreset {
    public static SectorPreset sector_v;
    public static void load() {
        sector_v = new SectorPreset("sector_v"){{
            alwaysUnlocked = true;
            addStartingItems = true;
            difficulty = 0;

            this.initialize(WPlanets.destruction, 5);
            Log.info("[WoodenMindustry]" + this.sector.planet.sectors);
            Log.info("[WoodenMindustry]" + this.sector.planet.sectors.get(5).preset.name);
            this.sector = WPlanets.destruction.sectors.get(5);
        }};
    }
}
