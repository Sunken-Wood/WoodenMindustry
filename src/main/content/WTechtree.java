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
        addToNode(Blocks.payloadUnloader, node(launchPad_erekir));
        addToNode(Blocks.siliconArcFurnace, node(sand_maker));
        addToNode(Blocks.reinforcedPump, node(water_extractor_erekir, () -> node(reinforce_pump_plus)));
        addToNode(Blocks.chemicalCombustionChamber, node(t2_vent_condenser, () -> node(steam_turbine)));
        addToNode(Blocks.armoredDuct, node(duct_bridge_plus));
        addToNode(Blocks.reinforcedBridgeConduit, node(reinforced_bridge_conduit_plus));
        addToNode(Blocks.ductUnloader, node(unloader_erekir));
        addToNode(Blocks.blastDoor, node(fortify_the_defensive_wall, () -> node(fortify_the_defensive_wall_large, () -> node(strengthened_gates))));
        addToNode(Blocks.sublimate, node(plasma_generator));

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
