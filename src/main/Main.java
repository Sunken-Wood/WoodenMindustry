package main;

import arc.Core;
import arc.util.Log;
import main.content.WBlocks;
import main.content.WPlanets;
import main.content.WTechtree;
import main.ui.WUI;
import mindustry.mod.Mod;

import static mindustry.Vars.ui;

public class Main extends Mod {

    public static WBlocks WBlocks;
    public static WPlanets WPlanets;
    public static WTechtree WTechtree;

    public Main(){
        Log.info("Loaded ExampleJavaMod constructor.");
        WBlocks = new WBlocks();
        WPlanets = new WPlanets();
        WTechtree = new WTechtree();
    }
    @Override
    public void loadContent() {
        super.loadContent();
        WBlocks.load();
        WPlanets.load();
        WTechtree.load();
    }
}
