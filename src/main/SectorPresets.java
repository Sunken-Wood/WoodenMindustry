package main;

import mindustry.type.SectorPreset;

import static main.Planets.Era_Rebuild;

public class SectorPresets implements ContentList {
    public SectorPreset sectorPreset;

    @Override
    public void load() {
        sectorPreset = new SectorPreset("rebuild-init-sector", Era_Rebuild, 1){{
            alwaysUnlocked = true;
        }};
    }

}
