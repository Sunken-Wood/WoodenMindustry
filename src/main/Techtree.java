package main;

import static main.Planets.era_rebuild;
import static main.block.Blocks.launchPad;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class Techtree implements ContentList{


    @Override
    public void load() {
        era_rebuild.techTree = nodeRoot("Rebuild", launchPad, true, () -> {


        });
    }
}
