package main.ui;

import main.ui.StoryUi.Basic;
import mindustry.gen.Icon;
import mindustry.ui.dialogs.BaseDialog;
import main.Utils.*;

import static main.Utils.toText;

public class WUI extends BaseDialog {
    Basic.TextField textField = new Basic.TextField();

    public WUI(String title) {
        super(title);
        buttons.button(toText("ui.cancel"), Icon.cancel, this::hide).pad(10).colspan(2).width(200).row();
        buttons.button(toText("ui.next"), Icon.ok, () -> {
            textField.clear();
            textField.addString(toText("ui.story-mode.text.1"));
            change();
            changed(() -> {
                textField.clear();
                textField.addString("虽然有最基础的部件");
                textField.addString("但是仍未开发完成");
            });
        }).pad(10).colspan(2).width(200).row();
    }

    public void Show(){
        cont.clear();

        textField.addString("Welcome");
        cont.add(textField.getTable());

        show();
    }
}
