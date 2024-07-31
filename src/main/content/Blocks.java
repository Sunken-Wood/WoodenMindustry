package main.content;

import main.ContentList;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static mindustry.content.Blocks.coreBastion;
import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {
    public static LaunchPad launchPad_erekir;
    public static Unloader unloader_erekir;


    @Override
    public void load() {
        launchPad_erekir = new LaunchPad("launchpad-erekir"){{
            requirements(Category.effect, with(Items.beryllium, 360, Items.silicon, 360, Items.oxide, 160));
            size = 3;
            itemCapacity = 200;
            launchTime = 60f * 40;
            hasPower = true;
            consumePower(4f);
        }};
        unloader_erekir = new Unloader("unloader-erekir"){{
            requirements(Category.effect, with(Items.graphite, 20, Items.silicon, 20, Items.tungsten, 10));
            speed = 60f / 11f;
            group = BlockGroup.transportation;
        }};
    }
}
