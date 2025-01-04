package main;
import arc.util.Log;
import main.content.WBlocks;
import main.content.WItems;
import main.content.WPlanets;
import main.content.WTechtree;
import mindustry.mod.Mod;
public class Main extends Mod {

    public Main(){
        Log.info("Loaded ExampleJavaMod constructor.");
    }
    @Override
    public void loadContent() {
        super.loadContent();
        WItems.load();
        WBlocks.load();
        WPlanets.load();
        WTechtree.load();
    }

    @Override
    public void init() {
        super.init();
    }
}
