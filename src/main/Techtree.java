package main;

import static main.Planets.Era_Rebuild;
import static main.block.Blocks.launchPad;
import static mindustry.content.TechTree.nodeRoot;

public class Techtree implements ContentList{


    @Override
    public void load() {
        Era_Rebuild.techTree = nodeRoot("Rebuild", launchPad, true, () -> {
        });
    }
}
