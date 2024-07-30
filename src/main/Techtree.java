package main;

import static main.Planets.Era_Rebuild;
import static main.block.Blocks.launchPad;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class Techtree implements ContentList{


    @Override
    public void load() {
        erekir.techTree = nodeRoot("Rebuild", Era_Rebuild, true, () -> {
            node(launchPad, () -> {

            });
        });
    }
}
