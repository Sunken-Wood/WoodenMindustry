package main.content;

import main.ContentList;

import static main.content.Blocks.*;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;

public class Techtree implements ContentList {

    @Override
    public void load() {
        // 在 Erekir 星球的科技树中添加新的节点
        erekir.techTree.children.add(node(launchPad_erekir, () -> {
            // 在 launchPad_erekir 节点下添加 unloader_erekir 节点
            node(unloader_erekir);
            // 在 launchPad_erekir 节点下添加 pneumatic_drill_erekir 节点
            node(sand_maker);
        }));
    }
}
