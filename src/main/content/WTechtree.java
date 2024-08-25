package main.content;

import main.ContentList;
import mindustry.content.Blocks;

import static main.Utils.*;
import static main.content.WBlocks.*;
import static main.content.WPlanets.destruction;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class WTechtree implements ContentList {

    @Override
    public void load() {
        addToNode(Blocks.turbineCondenser, node(steam_turbine));
        addToNode(Blocks.payloadMassDriver,node(launchPad_erekir));

//        destruction
        destruction.techTree = nodeRoot(toText("planet.wooden-mindustry-destruction.name"), destruction_core, () -> {
            node(WItems.iron, () -> {
                node(WItems.silver, () -> {
                    node(WItems.gold);
                });
            });
        });
    }
}
