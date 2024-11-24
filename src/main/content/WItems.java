package main.content;

import arc.graphics.Color;
import arc.struct.Seq;
import main.ContentList;
import mindustry.type.Item;

public class WItems implements ContentList {
    public static Item
        iron, gold, silver,aluminum,aluminum_mineral;

    public static final Seq<Item> destructionItems = new Seq<>();


    @Override
    public void load() {
        // 铁
        iron = new Item("iron"){{
            hardness = 3; // 开采等级
            color = Color.valueOf("7E7B7A");
        }};
        // 铝
        aluminum = new Item("aluminum"){{
            hardness = 3;
            color = Color.valueOf("C0C0C0");
        }};
        // 铝土矿
        aluminum_mineral = new Item("aluminum-mineral"){{
           hardness = 4;
           color = Color.valueOf("A52A2A");
        }};
        // 金
        gold = new Item("gold"){{
            hardness = 4;
            color = Color.valueOf("ffd700");
        }};
        // 银
        silver = new Item("silver"){{
            hardness = 4;
            color = Color.valueOf("D3D3D3");
        }};
        destructionItems.addAll(iron, gold, silver, aluminum,aluminum_mineral);
    }

}
