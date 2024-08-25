package main.ui;

import arc.Core;
import arc.scene.ui.layout.Table;
import arc.util.Time;
import mindustry.game.EventType;
import mindustry.gen.Tex;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;

import static mindustry.Vars.ui;

public class runSave extends BaseDialog {

    public runSave() {
        super("Hello World");
    }

    public void toShow(){
        cont.clear();

        Table save = new Table();
        save.add("Hello World").colspan(2);
        save.row();

        cont.add(save);
    }
}
