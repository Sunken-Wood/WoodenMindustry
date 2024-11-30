package main.ui;

import arc.input.KeyCode;
import arc.scene.Element;
import arc.scene.event.ChangeListener;
import arc.scene.event.ClickListener;
import arc.scene.ui.Button;
import arc.scene.ui.Label;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import mindustry.gen.Icon;
import mindustry.ui.dialogs.BaseDialog;
import main.Utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static main.Utils.toText;

public class WUI extends BaseDialog {
    Using storyUsing = new Using("ui.story-mode.");

    public WUI(String title) {
        super(title);
    }

    public void Show(){
        cont.clear();
        buttons.clear();
        ArrayList<String> strings = new ArrayList<>();
        strings.add(storyUsing.toText("text.0"));
        strings.add(storyUsing.toText("text.1"));
        strings.add(storyUsing.toText("text.2"));
        strings.add(storyUsing.toText("text.3"));

        Table table = new Table();
        Button next = new TextButton("Next");
        Button cancel = new TextButton("Cancel");
        final int[] ptr = {1};
        table.add(strings.get(0));


        next.changed(() -> {
            if(next.isChecked()){
            }
        });
        cancel.changed(() -> {
            if (cancel.isChecked()){
                this.hide();
            }
        });

        buttons.add(next);
        buttons.add(cancel);
        cont.add(table);
        show();
    }
}
