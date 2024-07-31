package main.ui;

import arc.Core;
import arc.scene.ui.Dialog;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Time;
import main.ContentList;
import mindustry.gen.Tex;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;

import static mindustry.Vars.mobile;

public class WUI implements ContentList {


    @Override
    public void load() {

        Table table = new Table();
        table.add("Test").colspan(2);
        table.row();

        table.table(Tex.button, diff -> {
            int i = 0;
            diff.button("Hello", () -> {
                Log.info("Emit Button Hello");
                Time.runTask(10f, () -> {
                    BaseDialog dialog = new BaseDialog("frog");
                    dialog.cont.add("behold").row();
                    //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                    dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
                    dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                    dialog.show();
                });
            });
        });

        BaseDialog dialog = new BaseDialog("Test");
        dialog.cont.add(table);

    }
}
