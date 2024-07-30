package main.content;

import main.ContentList;
import mindustry.world.blocks.storage.CoreBlock;

public class Blocks implements ContentList {
    public static CoreBlock destruction_core;

    @Override
    public void load() {
        destruction_core = new CoreBlock("destruction-core"){{
            alwaysUnlocked = true;
        }};
    }
}
