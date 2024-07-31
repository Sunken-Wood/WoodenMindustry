package main.content;

import main.ContentList;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;

import static mindustry.content.Blocks.payloadMassDriver;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;

public class Techtree implements ContentList {
    public static TechTree.TechNode context = null;
    public static void addToNode(UnlockableContent p, Runnable c) {
        context = TechTree.all.find(t -> t.content == p);
        c.run();
    }

    @Override
    public void load() {
        addToNode(payloadMassDriver, () -> {
            node(Blocks.launchPad_erekir, () -> {

            });
        });
    }
}
