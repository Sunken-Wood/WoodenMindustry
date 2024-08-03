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
        // 在 Erekir 星球的科技树中添加新的节点
        erekir.techTree.children.add(node(launchPad_erekir, () ->
        {
            // 在 launchPad_erekir 节点下添加 unloader_erekir 节点
            node(unloader_erekir);
            // 在 launchPad_erekir 节点下添加 pneumatic_drill_erekir 节点
            node(sand_maker);
            //在 launchPad_erekir 节点下添加
            node(steam_turbine);
        erekir.techTree.children.add(node(sand_maker, () -> {
            node(unloader_erekir, () -> {
                node(reinforced_bridge_conduit_plus, () -> {
                    node(duct_bridge_plus);
                });
                node(reinforce_pump_plus);
            });
            node(launchPad_erekir);
        }));

        // 在 destruction 星球的科技树中添加新的根节点
        destruction.techTree = nodeRoot(String.valueOf(Core.atlas.find("planet.wooden-mindustry-destruction")), destruction_core, true, () -> {
        destruction.techTree = nodeRoot(toText("planet.wooden-mindustry-destruction.name"), destruction_core, true, () -> {
            node(Items.copper, () -> {
                node(WItems.iron, () -> {
                    node(WItems.silver, () -> {
                        node(WItems.gold);
                    });
                });
                node(Items.silicon);
            });
        });
    }
}
