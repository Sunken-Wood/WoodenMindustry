package main.content;

import main.ContentList;
import mindustry.type.Planet;
import static mindustry.content.Planets.*;

public class Planets implements ContentList {
    public static Planet
        destruction,
        rebuilds;

    @Override
    public void load() {
        destruction = new Planet("destruction", sun, 0.4f, 2){{
            alwaysUnlocked = true;
        }};
    }
}
