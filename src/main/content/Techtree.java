package main.content;

import main.ContentList;
import mindustry.content.TechTree;

import java.lang.reflect.Array;

import static main.content.Blocks.*;
import static main.content.Planets.destruction;
import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;
import static mindustry.content.ErekirTechTree.*;

public class Techtree implements ContentList {

    @Override
    public void load() {
        erekir.techTree.children.add(node(launchPad_erekir, () -> {
            node(unloader_erekir);
            node(pneumatic_drill_erekir);
        }));
    }
}
