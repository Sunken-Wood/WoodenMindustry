package main.content;

// 导入主内容列表类
import arc.Core;
import arc.struct.Seq;
import main.ContentList;

// 导入Mindustry游戏内容类
import mindustry.content.*;

// 导入Mindustry类型类
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;

// 导入Mindustry世界块类
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad; // 导入类：发射台
import mindustry.world.blocks.defense.Door;//门
import mindustry.world.blocks.power.ThermalGenerator;//导入类：热能发电机
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter; // 导入类：生产
import mindustry.world.blocks.power.PowerGenerator; // 导入类：发电机
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.blocks.storage.CoreBlock; // 导入类：核心
import mindustry.world.blocks.storage.Unloader; // 导入类：装卸器
import mindustry.world.blocks.defense.Wall;//防御墙

// 导入Mindustry世界元数据类
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.production.Pump;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;

//导入动画包
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawBlurSpin;


import static mindustry.type.ItemStack.with;

public class WBlocks implements ContentList {
//    ============ Erekir ============
    public static LaunchPad launchPad_erekir;
    public static Unloader unloader_erekir;
    public static GenericCrafter sand_maker;
    public static PowerGenerator steam_turbine ;
    public static Pump reinforce_pump_plus;
    public static DuctBridge duct_bridge_plus;
    public static DirectionLiquidBridge reinforced_bridge_conduit_plus;
    public static SolidPump water_extractor_erekir;
    public static AttributeCrafter t2_vent_condenser;
    public static Wall fortify_the_defensive_wall,fortify_the_defensive_wall_large;
    public static Door strengthened_gates;

//    ============ Destruction ============
    public static CoreBlock destruction_core;
    public static Seq<Block> destructionBlocks = new Seq<>();

    @Override
    public void load() {

//        =============================== Erekir Tools ===============================

// 创建一个新的防御墙对象，命名为 "fortify-the-defensive-wall"
        fortify_the_defensive_wall = new Wall("fortify-the-defensive-wall") {{
            // 设置建造需求，包括铍、钨、硅和石墨
            requirements(Category.defense, with(Items.beryllium, 10, Items.tungsten, 5, Items.silicon, 15, Items.graphite, 5));
            // 设置大小为 1*1
            size = 1;
            // 设置装甲值为 5
            armor = 5;
            // 设置血量为 1000
            health = 800;
            // 设置建造成本倍率为 1.7
            buildCostMultiplier = 1.7f;
            // 设置描述信息
            description = "强化防御墙";
        }};

// 创建一个新的大型防御墙对象，命名为 "fortify-the-defensive-wall-large"
        fortify_the_defensive_wall_large = new Wall("fortify-the-defensive-wall-large") {{
            // 设置建造需求，包括铍、钨、硅和石墨
            requirements(Category.defense, with(Items.beryllium, 30, Items.tungsten, 10, Items.silicon, 30, Items.graphite, 10));
            // 设置大小为 2*2
            size = 2;
            // 设置装甲值为 20
            armor = 20;
            // 设置血量为 5000
            health = 4000;
            // 设置建造成本倍率为 1.5
            buildCostMultiplier = 1.5f;
            // 设置描述信息
            description = "大型强化防御墙";
        }};

// 创建一个新的强化门对象，命名为 "strengthened-gates"
        strengthened_gates = new Door("strengthened-gates") {{
            // 设置建造需求，包括铍、钨、硅和石墨
            requirements(Category.defense, with(Items.beryllium, 30, Items.tungsten, 20, Items.silicon, 40, Items.graphite, 5));
            // 设置开门时的音效
            openfx = Fx.dooropenlarge;
            // 设置关门时的音效
            closefx = Fx.doorcloselarge;
            // 设置大小为 2*2
            size = 2;
            // 设置血量为 4096
            health = 4096;
            // 设置建造成本倍率为 1.3
            buildCostMultiplier = 1.3f;
            // 设置描述信息
            description = "供单位穿越的门，需要手动开关，可以连携开关";
        }};

        // 创建一个新的 LaunchPad 实例，并将其命名为 "launchpad-erekir"（发射台）
        launchPad_erekir = new LaunchPad("launchpad-erekir")
        {{
            // 类型：影响 设置建造需求：需要 360 个 Beryllium、360 个 Silicon 和 160 个 Oxide
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
            // 类型：生产 建造需求： 40*beryllium 30*graphite
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
            description = "平地挖沙机，可以生产沙子，需要电力";
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f)
            {{
                // 设置模糊阈值为0.01
                blurThresh = 0.03f;
            }});
        }};

//       强化泵 Plus
        reinforce_pump_plus = new Pump("reinforce-pump-plus"){{
            // 定义方块的资源需求，属于液体类别，需要40单位的铍、30单位的钨和20单位的硅
            requirements(Category.liquid, with(Items.beryllium, 40, Items.tungsten, 30, Items.silicon, 30));
            // 启用电力消耗
            hasPower = true;
            // 设置电力消耗为 4 单位/秒
            consumePower(2.5f);
            // 设置方块的图标
            fullIcon = Core.atlas.find("reinforce_pump_plus");
            // 每分钟泵送160单位的液体，除以4表示每秒泵送的量
            pumpAmount = 160f / 60f / 4f;
            // 液体容量为320单位
            liquidCapacity = 70f;
            // 方块尺寸为2x2
            size = 2;
            squareSprite = false;
            // 方块的描述
            description = "更好的流体泵，需要电力";
        }};


//       蒸汽涡轮机
        steam_turbine = new ThermalGenerator("steam-turbine") {{
            // 设置建造需求：需要 100 个 Beryllium、50 个 Silicon 和 30 个 Graphite
            requirements(Category.power, with(Items.beryllium, 100, Items.silicon, 50, Items.graphite, 30));
            // 设置块的大小为 3x3
            size = 3;
            // 设置生成器的属性为蒸汽（steam）
            attribute = Attribute.steam;
            // 设置发电机的生命值为 200
            health = 200;
            // 输出电力：是
            outputsPower = true;
            // 设置显示效率的比例为1/9
            displayEfficiencyScale = 1f / 9f;
            // 设置最小效率为9 - 0.0001
            minEfficiency = 9f - 0.0001f;
            // 设置电力生产为6/9
            powerProduction = 6f / 9f;
            // 流体存储量：60
            liquidCapacity = 4800f / 60f ;
            // 输出流体：水 效率：15/s
            outputLiquid = new LiquidStack(Liquids.water, 15f / 60f / 9f);
            // 将发电机添加到电源块组
            group = BlockGroup.power;
            // 设置不显示效率
            displayEfficiency = false;
            // 设置生成效果为蒸汽喷口
            generateEffect = Fx.turbinegenerate ;
            // 必须全部放置在蒸汽喷口上
            placeableOn = true;
            // 设置效果触发几率为0.04
            effectChance = 0.04f;
            description = "更高效的发电机，能产生水和较多的电力";

            // 设置绘制器为DrawMulti，包含默认绘制和旋转模糊绘制
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f)
            {{
                // 设置模糊阈值为0.01
                blurThresh = 0.01f;
            }});
        }};
//       T2排气冷凝器
        t2_vent_condenser = new AttributeCrafter("t2-vent-condenser") {{
            // 设置需求物品和数量
            requirements(Category.liquid, with(Items.graphite, 80, Items.beryllium, 200, Items.silicon, 50));
            // 设置大小
            size = 3;
            // 设置属性
            attribute = Attribute.steam;
            // 设置生命值
            health = 200;

            minEfficiency = 9f - 0.0001f;
            // 设置显示效率比例
            baseEfficiency = 1f / 9f;
            // 设置加速比例
            boostScale = 1f / 9f;
            // 设置液体容量 80
            liquidCapacity = 80;
            // 设置输出液体及其数量 100/s
            outputLiquid = new LiquidStack(Liquids.water, 50f / 60f  );
            // 启用电力消耗
            hasPower = true;
            // 设置电力消耗为 150 单位/分钟（即 2.5 单位/秒）
            consumePower(150f / 60f);
            // 设置不显示效率
            displayEfficiency = false;
            // 必须全部放置在蒸汽喷口上
            placeableOn = true;

            researchCostMultiplier = 0.7f;
            description = "2级的排气冷凝器，消耗较多电力，产生大量水";

            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f)
            {{
                // 设置模糊阈值为0.01
                blurThresh = 0.01f;
            }});
        }};

//       流体管道桥Plus
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

//       物品管道桥 Plus
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
//       地下抽水机
        water_extractor_erekir = new SolidPump("water-extractor-erekir"){{
            requirements(Category.production, with()); //类型：生产类 建造需求：
            result = Liquids.water; // 输出
            pumpAmount = 30f / 60f; // 泵出速度 30/s
            size = 2; // 大小
            liquidCapacity = 30f; // 存储容量
            rotateSpeed = 1.4f; // 转速
            researchCostMultiplier = 0.7f;

            consumePower(100f / 60f); // 消耗电力 100/s
            description = "抽水机，开采地下水，需要电力";
        }};


//        =============================== Destruction ===============================
//       【毁灭】核心
        destruction_core = new CoreBlock("destruction-core")
        {{
            requirements(Category.effect, with(WItems.iron, 1000, WItems.silver, 1000));

            size = 6;
            hasItems = true;
            itemCapacity = 7000;
            health = 4000;
            unitType = UnitTypes.evoke;

            incinerateNonBuildable = true;
            requiresCoreZone = true;
            alwaysUnlocked = true;
            unitCapModifier = 20;

        }};
        destructionBlocks.add(
                destruction_core
        );
    }
}
