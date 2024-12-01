package main.content;

import main.ContentList;
import mindustry.maps.generators.FileMapGenerator;
import mindustry.type.SectorPreset;

public class WSectorPreset implements ContentList {
    public static SectorPreset SECTOR_V;
    @Override
    public void load() {
        SECTOR_V = new SectorPreset("SECTOR-V", WPlanets.destruction, 5){{

            alwaysUnlocked = true;
            generator = new FileMapGenerator("SECTOR-V", SECTOR_V);
            difficulty = 0;
        }};
    }
}
