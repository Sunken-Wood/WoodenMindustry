package main.ui;

import arc.Core;
import arc.scene.ui.layout.Table;
import arc.util.Time;
import mindustry.gen.Tex;
import mindustry.ui.dialogs.BaseDialog;

public class UnloaderUi extends BaseDialog {

    public void toShow(){
        cont.clear();

        Table hello = new Table();
        hello.add("Hello").colspan(2);
        hello.row();

        hello.table(Tex.button, diff -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }


    public UnloaderUi() {
        super("hello");
    }
}
