package main.content;

import arc.Core;
import main.ContentList;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.TechTree;

import static main.Utils.addToNode;
import static main.Utils.toText;
import static main.content.WBlocks.*;
import static main.content.WPlanets.destruction;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class WTechtree implements ContentList {

    @Override
    public void load() {
        erekir.techTree.children.add(node(launchPad_erekir, () -> {
            node(sand_maker, () -> {
                node(steam_turbine, () -> {
                    node(sand_maker);
                    node(reinforce_pump_plus);
                });
                node(duct_bridge_plus, () -> {
                   node(reinforced_bridge_conduit_plus);
                });
            });
        }));

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
