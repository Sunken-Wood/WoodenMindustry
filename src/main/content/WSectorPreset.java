package main.content;

import arc.util.Log;
import main.ContentList;
import mindustry.maps.generators.FileMapGenerator;
import mindustry.type.SectorPreset;

public class WSectorPreset implements ContentList {
    public static SectorPreset sector_v;
    @Override
    public void load() {
        sector_v = new SectorPreset("sector_v", WPlanets.destruction, 5){{
            alwaysUnlocked = true;
            Log.info(this.generator.map.file.exists());
            Log.info(this.generator.map.name());
            difficulty = 0;
        }};
    }
}
