package main.ui;

import main.ui.StoryUi.Basic;
import mindustry.gen.Icon;
import mindustry.ui.dialogs.BaseDialog;
import main.Utils.*;

import static main.Utils.toText;

public class WUI extends BaseDialog {
    Basic.TextField textField = new Basic.TextField();
    Using storyUsing = new Using("ui.story-mode.");

    public WUI(String title) {
        super(title);
    }

    public void Show(){
        cont.clear();
        buttons.clear();
        textField.clear();
        buttons.button(toText("ui.cancel"), Icon.cancel, this::hide).pad(10).colspan(2).width(200);
        buttons.button(toText("ui.next"), Icon.ok, () -> {
            textField.clear();
            textField.addString(storyUsing.toText("text.1"));
            textField.addString(storyUsing.toText("text.2"));
            textField.addString(storyUsing.toText("text.3"));
            buttons.clear();
            buttons.button(toText("ui.finish"), Icon.cancel, this::hide).pad(10).colspan(2).width(200);
        }).pad(10).colspan(2).width(200);

        textField.addString(storyUsing.toText("text.0"));
        cont.add(textField.getTable());

        show();
    }
}
