package main.content;

import main.ContentList;
import mindustry.content.TechTree;

import static main.content.Blocks.launchPad_erekir;
import static main.content.Blocks.wooden;
import static main.content.Planets.destruction;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class Techtree implements ContentList {
    public static TechTree.TechNode wooden_tools;

    @Override
    public void load() {
        wooden_tools = nodeRoot("wooden-tools", destruction, () -> {
            node(launchPad_erekir, () -> {

            });
        });
    }
}
