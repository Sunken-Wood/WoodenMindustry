package main.content;

import mindustry.content.Blocks;
import mindustry.content.Items;

import static main.Utils.*;
import static main.content.WBlocks.*;
import static main.content.WPlanets.destruction;
import static mindustry.content.TechTree.*;

public class WTechtree {

    public static void load() {
        addToNode(Blocks.turbineCondenser, node(steam_turbine));
        addToNode(Blocks.payloadMassDriver, node(launchPad_erekir));
        addToNode(Blocks.cliffCrusher, node(sand_maker));
        addToNode(Blocks.reinforcedPump, node(reinforce_pump_plus, () -> node(water_extractor_erekir)));
        addToNode(Blocks.ventCondenser, node(t2_vent_condenser));
        addToNode(Blocks.ductBridge, node(duct_bridge_plus));
        addToNode(Blocks.reinforcedBridgeConduit, node(reinforced_bridge_conduit_plus));
        addToNode(Blocks.ductUnloader, node(unloader_erekir));
        addToNode(Blocks.sublimate, node(spear));
        addToNode(Blocks.ductBridge, node(junction));
        addToNode(Blocks.carbideWall, node(fortify_the_defensive_wall, () -> {
            node(fortify_the_defensive_wall_large);
            node(strengthened_gates);
        }));
//        destruction
        destruction.techTree = nodeRoot(toText("planet.wooden-mindustry-destruction.name"), destruction_core, () -> {
            node(basic_ion_drill);
            node(Items.copper, () -> {
                node(Items.lead, () -> {
                    nodeProduce(WItems.iron, () -> {
                        node(WItems.gold, () -> {
                            node(WItems.silver, () -> {
                                node(WItems.aluminum_mineral, () ->{
                                    node(WItems.aluminum);
                                });
                            });
                        });
                    });
                });
            });
            node(WSectorPreset.sector_v, () -> {

            });
        });
    }}
