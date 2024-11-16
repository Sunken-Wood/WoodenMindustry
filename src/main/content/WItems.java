package main.content;

import arc.graphics.Color;
import arc.struct.Seq;
import main.ContentList;
import mindustry.type.Item;

public class WItems implements ContentList {
    public static Item
        iron, gold, silver,copper,aluminum,leab;

    public static final Seq<Item> destructionItems = new Seq<>();


    @Override
    public void load() {
        // 铁
        iron = new Item("iron"){{
            hardness = 1; // 开采等级
            color = Color.valueOf("7E7B7A");
        }};
        // 铜
        copper = new Item("copper"){{
            hardness = 1;
            color = Color.valueOf("B87333");
        }};
        // 铝
        aluminum = new Item("aluminum"){{
            hardness = 1;
            color = Color.valueOf("C0C0C0");
        }};
        //铅
        leab = new Item("leab"){{
            hardness = 1;
            color = Color.valueOf("7A7B7D");
        }};
        // 金
        gold = new Item("gold"){{
            hardness = 2;
            color = Color.valueOf("ffd700");
        }};
        // 银
        silver = new Item("silver"){{
            hardness = 3;
            color = Color.valueOf("D3D3D3");
        }};
        destructionItems.addAll(
                iron, gold, silver
        );
    }

}
