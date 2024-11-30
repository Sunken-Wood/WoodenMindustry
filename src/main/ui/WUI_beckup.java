package main.ui;

import arc.scene.ui.Button;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import mindustry.ui.dialogs.BaseDialog;
import main.Utils.*;
import mindustry.ui.dialogs.MapPlayDialog;

import java.util.ArrayList;

public class WUI_beckup extends BaseDialog {
    Using storyUsing = new Using("ui.story-mode.");
    ArrayList<String> strings = new ArrayList<>();
    Table table = new Table();
    int ptr = 0;

    public WUI_beckup(String title) {
        super(title);
    }

    public void init(){
        table.clear();
        strings.add(storyUsing.toText("text.0"));
        strings.add(storyUsing.toText("text.1"));
        strings.add(storyUsing.toText("text.2"));
        strings.add(storyUsing.toText("text.3"));
    }

    public void nextText(){

    }

    public void Show(){
        cont.clear();
        buttons.clear();
        Log.info("[WoodenMindustry]cont.clear");
        Log.info("[WoodenMindustry]buttons.clear");

        Button next = new TextButton("Next");
        Button back = new TextButton("Back");
        Button finish = new TextButton("Finish");

        next.changed(() -> {
            Log.info("[WoodenMindustry]next.changed");
            if (next.isPressed()){
                Log.info("[WoodenMindustry]next.pressed");
                if (ptr >= strings.size()){
                    ptr = 0;
                    buttons.clear();
                    buttons.add(finish).width(200);
                    return;
                }
                table.add(strings.get(ptr)).left().row();
                Log.info(ptr);
                ptr+=1;
            }
        });
        next.change();
        back.changed(() -> {
            if (back.isChecked()){
                this.hide();
                ptr = 0;
                return;
            }
        });
        finish.changed(() -> {
            table.clear();
            buttons.clear();
            buttons.add(back).width(200).row();
            table.add(new MapPlayDialog().show());
        });


        buttons.add(next).width(200);
        buttons.add(back).width(200);
        cont.add(table);
        show();
    }
}
