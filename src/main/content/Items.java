package main.content;

import main.ContentList;
import mindustry.type.Item;

public class Items implements ContentList {
    public Item
        iron, copper, gold, silver
            ;


    @Override
    public void load() {
        iron = new Item("iron"){{
            hardness = 4;
            cost = 0.7f;
        }};
        copper = new Item("copper"){{
            hardness = 3;
            cost = 0.7f;
        }};
        gold = new Item("gold"){{
            hardness = 3;
        }};
        silver = new Item("silver"){{
            hardness = 3;
        }};
    }
}
