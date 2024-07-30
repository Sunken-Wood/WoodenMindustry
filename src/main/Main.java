package main;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import main.content.Blocks;
import main.content.Planets;
import main.content.Techtrees;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class Main extends Mod {

    public static Blocks blocks;
    public static Planets planets;
    public static Techtrees techtrees;


    public Main(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
        blocks = new Blocks();
        planets = new Planets();
        techtrees = new Techtrees();
    }
    @Override
    public void loadContent() {
        super.loadContent();
        blocks.load();
        planets.load();
        techtrees.load();
    }
}
