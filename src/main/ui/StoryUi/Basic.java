package main.ui.StoryUi;

import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;

public class Basic {
    public static class TextField {
        public String name;
        public final Table table;

        public TextField(){
            table = new Table();
        }

        public void addString(String Text){
            table.add(new Label(Text)).row();
        }

        public Table getTable() {
            return table;
        }

        public void clear(){
            table.clear();
        }
    }
}
