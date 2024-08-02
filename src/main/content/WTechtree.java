package main.content;

import main.ContentList;
import mindustry.content.Items;
import mindustry.content.TechTree;

import static main.content.WBlocks.*;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class WTechtree implements ContentList {
    public static TechTree.TechNode destruction;

    @Override
    public void load() {
        // 在 Erekir 星球的科技树中添加新的节点
        erekir.techTree.children.add(node(launchPad_erekir, () -> {
            // 在 launchPad_erekir 节点下添加 unloader_erekir 节点
            node(unloader_erekir);
            // 在 launchPad_erekir 节点下添加 pneumatic_drill_erekir 节点
            node(sand_maker);
        }));
        destruction = nodeRoot("destruction", destruction_core, () -> {
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
