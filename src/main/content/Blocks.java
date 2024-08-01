package main.content;

import arc.Core;
import main.ContentList;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static mindustry.content.Blocks.coreBastion;
import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {
    public static LaunchPad launchPad_erekir;
    public static Unloader unloader_erekir;
    public static HeatProducer pneumatic_drill_erekir;


    @Override
    public void load() {
        launchPad_erekir = new LaunchPad("launchpad-erekir"){{
            requirements(Category.effect, with(Items.beryllium, 360, Items.silicon, 360, Items.oxide, 160));
            size = 3;
            itemCapacity = 200;
            launchTime = 60f * 30;
            hasPower = true;
            consumePower(4f);
        }};
        unloader_erekir = new Unloader("unloader-erekir"){{
            requirements(Category.effect, with(Items.graphite, 20, Items.silicon, 20, Items.tungsten, 10));
            speed = 60f / 11f;
            group = BlockGroup.transportation;
        }};
        pneumatic_drill_erekir = new HeatProducer("pneumatic-drill-erekir"){{
            requirements(Category.production, with(Items.beryllium, 40, Items.graphite, 30));
            size = 2;
            outputItem = new ItemStack(Items.sand, 1);
            craftTime = 60f * 1;


            consumeLiquid(Liquids.water, 0.06f).boost();
        }};
    }
}
