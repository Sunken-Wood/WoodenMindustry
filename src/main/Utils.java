package main;

import arc.Core;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import static mindustry.content.Planets.erekir;
import static mindustry.content.TechTree.node;

public class Utils {
    public static String toText(String str){
        return Core.bundle.format(str);
    }
    public static void addToNode(UnlockableContent parent, TechTree.TechNode child){
        TechTree.all.find(t -> t.content == parent).children.add(child);
    }
}
