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

public class WUI {
    public UnloaderUi unloaderUi;

    public void init(){
        unloaderUi = new UnloaderUi();
    }
}
