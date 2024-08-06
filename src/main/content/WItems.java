package main.content;

import arc.struct.Seq;
import main.ContentList;
import mindustry.type.Item;

public class WItems implements ContentList {
    public static Item
        iron, gold, silver
            ;

    public static Seq<Item> destructionItems;


    @Override
    public void load() {
        // 铁
        iron = new Item("iron"){{
            hardness = 4; // 硬度
            cost = 0.7f;
        }};
        // 金
        gold = new Item("gold"){{
            hardness = 2;//金是很软的，你甚至可以用牙咬出一个口
        }};
        // 银
        silver = new Item("silver"){{
            hardness = 3;
        }};
        destructionItems.addAll(
                iron, gold, silver
        );
    }

}
