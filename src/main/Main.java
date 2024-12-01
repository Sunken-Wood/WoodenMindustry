package main;

import arc.util.Log;
import main.content.*;
//import main.ui.WUI;
import main.ui.WUI_beckup;
import mindustry.gen.Icon;
import mindustry.mod.Mod;

import static main.Utils.toText;
import static mindustry.Vars.ui;

public class Main extends Mod {
    public static WItems wItems;
    public static WBlocks WBlocks;
    public static WPlanets WPlanets;
    public static WTechtree WTechtree;
    public static WSectorPreset WSectorPresets;
    public static WUI_beckup wuiBeckup;

    public Main(){
        Log.info("[WoodenMindustry] Loaded WoodenMindustry Mod");
        wItems = new WItems();
        WBlocks = new WBlocks();
        WPlanets = new WPlanets();
        WTechtree = new WTechtree();
        WSectorPresets = new WSectorPreset();
    }
    @Override
    public void loadContent() {
        super.loadContent();
        wItems.load();
        WBlocks.load();
        WPlanets.load();
        WTechtree.load();
        WSectorPresets.load();
    }

    @Override
    public void init() {
        super.init();
//        wuiBeckup = new WUI_beckup(toText("ui.story-mode"));
//        wuiBeckup.init();
//        if (ui != null){
//            ui.menufrag.addButton(toText("ui.story-mode"), Icon.book, () ->
//            {
//                wuiBeckup.Show();
//            });
//        }
    }
}
