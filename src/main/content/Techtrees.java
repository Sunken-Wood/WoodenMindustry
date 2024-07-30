package main.content;

import main.ContentList;

import static main.content.Blocks.destruction_core;
import static main.content.Planets.destruction;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class Techtrees implements ContentList {
    @Override
    public void load() {
        destruction.techTree = nodeRoot("Destruction", destruction, ()->{
            node(destruction_core, () -> {

            });
        });
    }
}
