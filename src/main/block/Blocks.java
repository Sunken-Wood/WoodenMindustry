package main.block;

import main.ContentList;
import mindustry.world.blocks.campaign.LaunchPad;

public class Blocks implements ContentList {
    public static LaunchPad launchPad;

    @Override
    public void load() {
        launchPad = new LaunchPad("launch-pad"){
            {
                alwaysUnlocked = true;
            }
        };
    }
}
