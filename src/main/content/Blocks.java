package main.content;

import main.ContentList;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {
    public static Block wooden;
    public static LaunchPad launchPad_erekir;


    @Override
    public void load() {
        launchPad_erekir = new LaunchPad("launchpad_erekir"){{
            requirements(Category.effect, BuildVisibility.campaignOnly, with(Items.beryllium, 360, Items.silicon, 360, Items.oxide, 160));
            size = 3;
            itemCapacity = 100;
            launchTime = 60f * 1;
            hasPower = true;
            consumePower(4f);
        }};
    }
}
