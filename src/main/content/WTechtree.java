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


        erekir.techTree.children.add(node(launchPad_erekir, () -> {
            node(fortify_the_defensive_wall,() -> {
                node(fortify_the_defensive_wall_large,() -> {
                    node(strengthened_gates);
                });
                    });
            node(sand_maker, () -> {
                node(steam_turbine, () -> {
                    node(reinforce_pump_plus, () -> {
                        node(water_extractor_erekir);
                        node(t2_vent_condenser);
                    });
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
