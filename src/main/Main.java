package main;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import main.content.Blocks;
import main.content.Techtree;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class Main extends Mod {

    public static Blocks blocks;
    public static Techtree techtree;


    public Main(){
        Log.info("Loaded ExampleJavaMod constructor.");
        blocks = new Blocks();
        techtree = new Techtree();
    }
    @Override
    public void loadContent() {
        super.loadContent();
        blocks.load();
        techtree.load();
    }
}
