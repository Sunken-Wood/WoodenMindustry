package main;

import arc.Core;
import arc.Events;
import arc.util.Log;
import main.content.WBlocks;
import main.content.WItems;
import main.content.WPlanets;
import main.content.WTechtree;
//import main.ui.WUI;
import main.ui.WUI;
import mindustry.gen.Icon;
import mindustry.mod.Mod;

import static main.Utils.toText;
import static mindustry.Vars.ui;

public class Main extends Mod {
    public static WItems wItems;
    public static WBlocks WBlocks;
    public static WPlanets WPlanets;
    public static WTechtree WTechtree;
    public static WUI Wui;

    public Main(){
        Log.info("Loaded ExampleJavaMod constructor.");
        wItems = new WItems();
        WBlocks = new WBlocks();
        WPlanets = new WPlanets();
        WTechtree = new WTechtree();
    }
    @Override
    public void loadContent() {
        super.loadContent();
        wItems.load();
        WBlocks.load();
        WPlanets.load();
        WTechtree.load();
    }

    @Override
    public void init() {
        super.init();
        Wui = new WUI(toText("ui.story-mode"));
        if (ui != null){
            ui.menufrag.addButton(toText("ui.story-mode"), Icon.book, () -> Wui.Show());
        }
    }
}
