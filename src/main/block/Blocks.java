package main.block;

import main.ContentList;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {
    public static LaunchPad launchPad;

    @Override
    public void load() {
        launchPad = new LaunchPad("launch-pad"){
            {
//                alwaysUnlocked = true;
                requirements(Category.effect, BuildVisibility.campaignOnly, with(Items.beryllium, 360, Items.silicon, 360, Items.oxide, 120, Items.tungsten, 360));
                size = 3;
                itemCapacity = 100;
                launchTime = 60f * 1;
                hasPower = true;
                consumePower(4f);
            }
        };
    }
}
