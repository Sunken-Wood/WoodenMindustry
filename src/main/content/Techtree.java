package main.content;

import main.ContentList;
import mindustry.content.TechTree;

import static main.content.Blocks.launchPad_erekir;
import static main.content.Planets.destruction;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;
import static mindustry.content.ErekirTechTree.*;

public class Techtree implements ContentList {
    public static TechTree.TechNode wooden_tools;

    @Override
    public void load() {
        erekir.techTree.children.add(node(launchPad_erekir));
        wooden_tools = nodeRoot("wooden-tools", destruction, () -> {

        });
    }
}
