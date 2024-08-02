package main.content;

import main.ContentList;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Pump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class WBlocks implements ContentList {
//    ============ Erekir ============
    // 定义 Erekir 版本的 LaunchPad、Unloader 和 HeatProducer 块
    public static LaunchPad launchPad_erekir;
    public static Unloader unloader_erekir;
    public static GenericCrafter sand_maker;
    public static Pump reinforce_pump_plus;
    public static DuctBridge duct_bridge_plus;

    public static DirectionLiquidBridge reinforced_bridge_conduit_plus;

//    ============ Destruction ============
    public static CoreBlock destruction_core;

    @Override
    public void load() {

//        =============================== Erekir Tools ===============================
        // 初始化 Erekir 版本的 LaunchPad
        launchPad_erekir = new LaunchPad("launchpad-erekir"){{
            // 设置建造需求：需要 360 个 Beryllium、360 个 Silicon 和 160 个 Oxide
            requirements(Category.effect, with(Items.beryllium, 360, Items.silicon, 360, Items.oxide, 160));
            // 设置块的大小为 3x3
            size = 3;
            // 设置物品容量为 200
            itemCapacity = 200;
            // 设置发射时间为 30 秒（60 帧/秒 * 30 秒）
            launchTime = 60f * 30;
            // 启用电力消耗
            hasPower = true;
            // 设置电力消耗为 4 单位/秒
            consumePower(30f / 60f);
        }};

        // 初始化 Erekir 版本的 Unloader
        unloader_erekir = new Unloader("unloader-erekir"){{
            // 设置建造需求：需要 20 个 Graphite、20 个 Silicon 和 10 个 Tungsten
            requirements(Category.effect, with(Items.graphite, 20, Items.silicon, 20, Items.tungsten, 10));
            // 设置卸载速度为 60 帧/秒 / 11 帧/秒
            speed = 60f / 11f;
            // 设置块组为 Transportation
            group = BlockGroup.transportation;
        }};

        // 初始化 Erekir 版本的 Pneumatic Drill
        sand_maker = new GenericCrafter("sand-maker"){{
            // 设置建造需求：需要 40 个 Beryllium 和 30 个 Graphite
            requirements(Category.production, with(Items.beryllium, 40, Items.graphite, 30));
            // 设置块的大小为 2x2
            size = 2;
            // 设置输出物品为 1 个 Sand
            outputItem = new ItemStack(Items.sand, 1);
            // 设置制造时间为 1 秒（60 帧/秒 * 1 秒）
            craftTime = 60f * 1;

            // 消耗液体 Water，消耗速率为 0.06 单位/秒，并启用加速效果
            consumeLiquid(Liquids.water, 0.06f).boost();
            // 启用电力消耗
            hasPower = true;
            // 设置电力消耗为 4 单位/秒
            consumePower(10f / 60f);
        }};
        reinforce_pump_plus = new Pump("reinforce-pump-plus"){{
            requirements(Category.liquid, with(Items.beryllium, 40, Items.tungsten, 30, Items.silicon, 20));
            consumeLiquid(Liquids.hydrogen, 1.5f / 60f);

            pumpAmount = 160f / 120f / 8f;
            liquidCapacity = 320f;
            size = 2;
        }};
        reinforced_bridge_conduit_plus = new DirectionLiquidBridge("reinforced-bridge-conduit-plus"){{
            requirements(Category.liquid, with(Items.graphite, 8, Items.beryllium, 20));
            range = 8;
            hasPower = false;
            researchCostMultiplier = 1;
            underBullets = true;
        }};
        duct_bridge_plus = new DuctBridge("duct-bridge-plus"){{
            requirements(Category.distribution, with(Items.beryllium, 20));
            health = 90;
            speed = 8f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
            itemCapacity = 8;
        }};

//        =============================== Destruction ===============================
        // 【毁灭】核心
        destruction_core = new CoreBlock("destruction-core"){{
            requirements(Category.effect, with(WItems.iron, 1000, Items.copper, 1000, Items.silicon, 1000));
            researchCost = with(WItems.iron, 1000, Items.copper, 1000, Items.silicon, 1000);

            size = 3;// 大小
            hasItems = true;
            itemCapacity = 50000;// 物品容量
            health = 4000;// 生命值
            unitType = UnitTypes.evoke;

            incinerateNonBuildable = true;//焚烧不可重建
            requiresCoreZone = true;//需要核心区
            alwaysUnlocked = true;//总是解锁
            unitCapModifier = 20;//单位数量

        }};

    }
}
