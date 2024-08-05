package main.content;

// 导入主内容列表类
import arc.Core;
import main.ContentList;

// 导入Mindustry游戏内容类
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;

// 导入Mindustry类型类
import mindustry.type.Category;
import mindustry.type.ItemStack;

// 导入Mindustry世界块类
import mindustry.type.LiquidStack;
import mindustry.world.blocks.campaign.LaunchPad; // 导入类：发射台
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.GenericCrafter; // 导入类：生产
import mindustry.world.blocks.power.PowerGenerator; // 导入类：发电机
import mindustry.world.blocks.storage.CoreBlock; // 导入类：核心
import mindustry.world.blocks.storage.Unloader; // 导入类：装卸器

// 导入Mindustry世界元数据类
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Pump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;


import static mindustry.type.ItemStack.with;

public class WBlocks implements ContentList {
//    ============ Erekir ============
    // 定义 Erekir 版本的 LaunchPad、Unloader 和 HeatProducer 块
    public static LaunchPad launchPad_erekir;
    public static Unloader unloader_erekir;
    public static GenericCrafter sand_maker;
    public static PowerGenerator steam_turbine;
    public static Pump reinforce_pump_plus;
    public static DuctBridge duct_bridge_plus;

    public static DirectionLiquidBridge reinforced_bridge_conduit_plus;

//    ============ Destruction ============
    public static CoreBlock destruction_core;

    @Override
    public void load() {

//        =============================== Erekir Tools ===============================
        // 创建一个新的 LaunchPad 实例，并将其命名为 "launchpad-erekir"（发射台）
        launchPad_erekir = new LaunchPad("launchpad-erekir")
        {{
            // 设置建造需求：需要 360 个 Beryllium、360 个 Silicon 和 160 个 Oxide
            requirements(Category.effect, with(Items.beryllium, 360, Items.silicon, 360, Items.oxide, 160));
            // 设置块的大小为 3x3
            size = 3;
            // 设置物品容量为 200
            itemCapacity = 200;
            // 设置发射台的生命值300
            health = 300;
            // 设置发射时间为 30 秒（60 帧/秒 * 30 秒）
            launchTime = 60f * 30;
            // 启用电力消耗
            hasPower = true;
            // 设置电力消耗为 4 单位/秒
            consumePower(30f / 60f);
            description = "来自赛普罗的发射台，可以将资源发射到其他区块";
        }};

        // 创建一个新的 Unloader 实例，并将其命名为 "unloader-erekir"（装卸器）
        unloader_erekir = new Unloader("unloader-erekir")
        {{
            // 设置建造需求：需要 20 个 Graphite、20 个 Silicon 和 10 个 Tungsten
            requirements(Category.effect, with(Items.graphite, 20, Items.silicon, 20, Items.tungsten, 10));
            // 设置卸载速度为 60 帧/秒 / 11 帧/秒
            speed = 60f / 11f;
            // 设置块组为 Transportation
            group = BlockGroup.transportation;
            description = "来自赛普罗的装卸器，打破了资源不能从核心卸载的历史";
        }};

        // 创建一个新的 GenericCrafter 实例，并将其命名为 "sand-maker"（采沙机）
        sand_maker = new GenericCrafter("sand-maker")
        {{
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
            description = "平地挖沙机，可以产生沙子，本来只能在黑沙地上放置，*但由于作者的疏忽，它甚至可以放在浅水上*(划掉)";
        }};

        // 创建一个新的发电机实例，并将其命名为 "steam-turbine"（蒸汽涡轮机）
        steam_turbine = new ThermalGenerator("steam_turbine")
        {{
            attribute = Attribute.steam;
            // 设置建造需求：需要 100 个 Beryllium、50 个 Silicon 和 30 个 Graphite
            requirements(Category.power, with(Items.beryllium, 100, Items.silicon, 50, Items.graphite, 30));
            // 设置块的大小为 3x3
            size = 3;
            displayEfficiencyScale = 1f / 9f;
            // 设置发电机的生命值为 200
            health = 200;
            // 设置发电量为 360 单位/秒
            outputsPower = true;
            powerProduction = 360f / 60f;
            //每秒产生40水
            hasLiquids = true;
            liquidCapacity = 40f;
            outputLiquid = new LiquidStack(Liquids.water, 60f / 60f / 9f);
            // 将发电机添加到电源块组
            group = BlockGroup.power;
            description = "更高效的发电机，能产生双倍涡轮冷凝器的电力和大量的水";
        }};


// 强化泵 Plus
        reinforce_pump_plus = new Pump("reinforce-pump-plus"){{
            // 定义方块的资源需求，属于液体类别，需要40单位的铍、30单位的钨和20单位的硅
            requirements(Category.liquid, with(Items.beryllium, 40, Items.tungsten, 30, Items.silicon, 20));
            // 每分钟消耗1.5单位的氢气
            consumeLiquid(Liquids.hydrogen, 1.5f / 60f);
            // 设置方块的图标
            fullIcon = Core.atlas.find("reinforce_pump_plus");
            // 每分钟泵送160单位的液体，除以4表示每秒泵送的量
            pumpAmount = 160f / 60f / 4f;
            // 液体容量为320单位
            liquidCapacity = 320f;
            // 方块尺寸为2x2
            size = 2;
            squareSprite = false;
            // 方块的描述
            description = "更好的流体泵";
        }};

// 强化流体桥 Plus
        reinforced_bridge_conduit_plus = new DirectionLiquidBridge("reinforced-bridge-conduit-plus"){{
            // 定义方块的资源需求，属于液体类别，需要10单位的石墨和20单位的铍
            requirements(Category.liquid, with(Items.graphite, 10, Items.beryllium, 20, Items.silicon, 20));
            // 方块尺寸为1x1
            size = 1;
            // 方块的生命值为90
            health = 130;
            // 传输范围为8格
            range = 8;
            // 不需要电力
            hasPower = false;
            // 研究成本乘数为1
            researchCostMultiplier = 1;
            // 可以在子弹下方传输液体
            underBullets = true;
            // 方块的描述
            description = "更长的流体桥";
        }};

// 物品管道桥 Plus
        duct_bridge_plus = new DuctBridge("duct-bridge-plus"){{
            // 定义方块的资源需求，属于分配类别，需要20单位的铍
            requirements(Category.distribution, with(Items.graphite, 10, Items.beryllium, 20, Items.silicon, 20));
            // 方块尺寸为1x1
            size = 1;
            // 传输范围为6格
            range = 8;
            // 方块的生命值为90
            health = 130;
            // 传输速度为4单位每秒
            speed = 4f;
            // 建造成本乘数为2
            buildCostMultiplier = 2f;
            // 研究成本乘数为0.3
            researchCostMultiplier = 0.3f;
            // 物品容量为8单位
            itemCapacity = 8;
            // 方块的描述
            description = "更长的物品桥";
        }};

//        =============================== Destruction ===============================
        // 【毁灭】核心
        destruction_core = new CoreBlock("destruction-core")
        {{
            requirements(Category.effect, with(WItems.iron, 1000, Items.copper, 1000, Items.silicon, 1000));
            researchCost = with(WItems.iron, 1000, Items.copper, 1000, Items.silicon, 1000);

            size = 6;// 大小
            hasItems = true;
            itemCapacity = 7000;// 物品容量
            health = 4000;// 生命值
            unitType = UnitTypes.evoke;

            incinerateNonBuildable = true;//焚烧不可重建
            requiresCoreZone = true;//需要核心区
            alwaysUnlocked = true;//总是解锁
            unitCapModifier = 20;//单位数量

        }};

    }
}
