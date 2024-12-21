package main;

import arc.util.Log;
import main.content.*;
import mindustry.content.SectorPresets;
import mindustry.mod.Mod;
import mindustry.type.SectorPreset;


public class Main extends Mod {

    public Main(){
        Log.info("[WoodenMindustry] Loaded WoodenMindustry Mod");
    }
    @Override
    public void loadContent() {
        super.loadContent();
        WItems.load();
        WBlocks.load();
        WPlanets.load();
        WSectorPreset.load();
        WTechtree.load();
    }

    @Override
    public void init() {
        super.init();
    }
}
