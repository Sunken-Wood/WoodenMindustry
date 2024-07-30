package main;

import mindustry.type.SectorPreset;

import static main.Planets.era_rebuild;

public class SectorPresets implements ContentList {
    public SectorPreset sectorPreset;

    @Override
    public void load() {
        sectorPreset = new SectorPreset("rebuild-init-sector", era_rebuild, 1){{
            alwaysUnlocked = true;
        }};
    }

}
