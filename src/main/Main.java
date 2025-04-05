package main;

import arc.util.Log;
import content.WBlocks;
import content.WItems;
import content.WTechTrees;
import mindustry.mod.Mod;

public class Main extends Mod {
    public Main(){
        Log.info("Loaded Wooden Mindustry");
    }

    @Override
    public void loadContent() {
        super.loadContent();
        WItems.load();
        WBlocks.load();
        WTechTrees.load();
    }
}
