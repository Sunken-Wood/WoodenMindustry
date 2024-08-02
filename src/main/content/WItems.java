package main.content;

import main.ContentList;
import mindustry.type.Item;

public class WItems implements ContentList {
    public static Item
        iron, gold, silver
            ;


    @Override
    public void load() {
        // 铁
        iron = new Item("iron"){{
            hardness = 4; // 硬度
            cost = 0.7f;
        }};
        // 金
        gold = new Item("gold"){{
            hardness = 3;
        }};
        // 银
        silver = new Item("silver"){{
            hardness = 3;
        }};
    }
}
