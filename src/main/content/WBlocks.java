package main.content;

// 导入主内容列表类
import arc.Core;
import arc.graphics.Color;
import arc.struct.Seq;
import main.ContentList;

// 导入Mindustry游戏内容类
import mindustry.content.*;

// 导入Mindustry类型类
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;

// 导入Mindustry世界块类
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad; // 发射台
import mindustry.world.blocks.defense.Door;//门
import mindustry.world.blocks.power.ThermalGenerator;//发电机
import mindustry.world.blocks.production.AttributeCrafter;//T2排气冷凝器
import mindustry.world.blocks.production.GenericCrafter; // 生产
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.power.PowerGenerator; // 发电机
import mindustry.world.blocks.production.SolidPump;//抽水机
import mindustry.world.blocks.storage.CoreBlock; // 核心
import mindustry.world.blocks.storage.Unloader; // 装卸器
import mindustry.world.blocks.defense.Wall;//防御墙
import mindustry.world.blocks.defense.turrets.PowerTurret;//炮台

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
    public static PowerTurret spear;

//    ============ Destruction ============
    public static CoreBlock destruction_core;
    public static BeamDrill basic_ion_drill;
    public static Seq<Block> destructionBlocks = new Seq<>();

    @Override
    public void load() {

//        =============================== Erekir ===============================
//添加一个炮台
        spear = new PowerTurret("spear") {{
            requirements(Category.turret, with(Items.beryllium,450, Items.oxide, 50, Items.tungsten, 200, Items.graphite,30, Items.silicon, 250)); // 成本
            range = 165; // 射程
            shoot.firstShotDelay = 40f; // 射击延迟
            recoil = 1.5f; // 后坐力
            reload = 40f; // 装填时间
            shootEffect = Fx.lancerLaserShoot; // 射击效果
            heatColor = Color.blue; // 热量颜色
            size = 3; // 大小
            scaledHealth = 180; // 生命值
            consumePower(3f); // 能量消耗
            targetAir = false; // 攻空目标
            moveWhileCharging = true; // 可移动充电
            accurateDelay = true; // 精确延迟
            shootSound = Sounds.laser; // 射击声音


            shootType = new LaserBulletType(450) {{//伤害
                colors = new Color[]{Pal.lancerLaser.cpy().a(1f), Pal.lancerLaser, Color.white}; // 子弹颜色
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin); // 充电效果
                buildCostMultiplier = 0.4f; // 建造成本倍率
                hitEffect = Fx.hitLancer; // 命中效果
                hitSize = 3; // 命中效果大小
                lifetime = 8f; // 子弹生命时间
                drawSize = 400f; // 绘制大小
                collidesAir = false; // 是否与空气碰撞
                length = 173f; // 激光长度
                ammoMultiplier = 1f; // 弹药倍率
                pierceCap = -1; // 穿透上限为无限
                knockback = 2; //击退效果
                buildingDamageMultiplier = 0.2f;//对建筑的伤害倍率
            }};
            description = "发射能量束攻击地面单位，无限穿透，精度很高"; // 描述
        }};

// 创建一个新的防御墙对象，命名为 "fortify-the-defensive-wall"
        fortify_the_defensive_wall = new Wall("fortify-the-defensive-wall") {{
            // 设置建造需求
            requirements(Category.defense, with(Items.beryllium, 20, Items.tungsten, 10, Items.silicon, 30, Items.graphite, 10));
            // 设置大小为 1*1
            size = 1;
            // 设置装甲值为 5
            armor = 5;
            // 设置血量为 800
            health = 800;
            // 设置建造成本倍率为 1.7
            buildCostMultiplier = 1.7f;
            // 设置描述信息
            description = "防御子弹，保护建筑";
        }};
// 创建一个新的大型防御墙对象，命名为 "fortify-the-defensive-wall-large"
        fortify_the_defensive_wall_large = new Wall("fortify-the-defensive-wall-large") {{
            // 设置建造需求
            requirements(Category.defense, with(Items.beryllium, 40, Items.tungsten, 20, Items.silicon, 40, Items.graphite, 20));
            // 设置大小为 2*2
            size = 2;
            // 设置装甲值为 20
            armor = 20;
            // 设置血量为4000
            health = 4000;
            // 设置建造成本倍率为 1.5
            buildCostMultiplier = 1.5f;
            // 设置描述信息
            description = "防御子弹，保护建筑";
        }};
// 创建一个新的强化门对象，命名为 "strengthened-gates"
        strengthened_gates = new Door("strengthened-gates") {{
            // 设置建造需求
            requirements(Category.defense, with(Items.beryllium, 40, Items.tungsten, 30, Items.silicon, 40, Items.graphite, 10));
            // 设置开门时的音效
            openfx = Fx.dooropenlarge;
            // 设置关门时的音效
            closefx = Fx.doorcloselarge;
            // 设置大小为 2*2
            size = 2;
            // 设置血量
            health = 4096;
            // 设置装甲值为 20
            armor = 20;
            // 设置建造成本倍率为 1.3
            buildCostMultiplier = 1.3f;
            // 设置描述信息
            description = "供单位穿越的门，需要手动开关，可以连携开关";
        }};

        // 创建一个新的 LaunchPad 实例，并将其命名为 "launchpad-erekir"（发射台）
        launchPad_erekir = new LaunchPad("launchpad-erekir")
        {{
            // 类型：影响 设置建造需求
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
            // 设置电力消耗
            consumePower(30f / 60f);

            description = "来自赛普罗的发射台，可以将资源发射到其他区块";
        }};

        // 创建一个新的 Unloader 实例，并将其命名为 "unloader-erekir"（装卸器）
        unloader_erekir = new Unloader("unloader-erekir")
        {{
            // 设置建造需求
            requirements(Category.effect, with(Items.graphite, 20, Items.silicon, 20, Items.tungsten, 10));
            // 设置卸载速度为 60 帧/秒 / 11 帧/秒
            speed = 60f / 11f;
            // 设置块组为 Transportation
            group = BlockGroup.transportation;
            description = "来自赛普罗的装卸器，现在可以从核心卸载资源了";
        }};

        // 创建一个新的 GenericCrafter 实例，并将其命名为 "sand-maker"（采沙机）
        sand_maker = new GenericCrafter("sand-maker")
        {{
            // 类型：生产 建造需求
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
            // 设置电力消耗
            consumePower(10f / 60f);
            description = "平地挖沙机，可以开采沙子，需要电力";
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f)
            {{
                // 设置模糊阈值为0.01
                blurThresh = 0.03f;
            }});
        }};

//       强化泵 Plus
        reinforce_pump_plus = new Pump("reinforce-pump-plus"){{
            // 定义方块的资源需求
            requirements(Category.liquid, with(Items.beryllium, 40, Items.tungsten, 30, Items.silicon, 30));
            // 启用电力消耗
            hasPower = true;
            // 设置电力消耗为 4 单位/秒
            consumePower(2.5f);
            // 设置方块的图标
            fullIcon = Core.atlas.find("reinforce_pump_plus");
            // 每分钟泵送100单位的液体，除以4表示每秒泵送的量
            pumpAmount = 100f / 60f / 4f;
            // 液体容量
            liquidCapacity = 50f;
            // 方块尺寸为2x2
            size = 2;
            squareSprite = false;
            // 方块的描述
            description = "更好的流体泵，需要电力";
        }};

//       蒸汽涡轮机
        steam_turbine = new ThermalGenerator("steam-turbine") {{
            // 设置建造需求
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
            // 设置输出液体及其数量
            outputLiquid = new LiquidStack(Liquids.water, 40f / 60f  );
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
            // 定义方块的资源需求
            requirements(Category.liquid, with(Items.oxide,5, Items.graphite, 10, Items.tungsten, 30, Items.beryllium, 20, Items.silicon, 20));
            // 方块尺寸为1x1
            size = 1;
            // 方块的生命值
            health = 70;
            // 传输范围为8格
            range = 8;
            // 研究成本乘数
            researchCostMultiplier = 0.5f;
            // 可以在子弹下方传输液体
            underBullets = true;
            // 方块的描述
            description = "更长的流体桥";
        }};
//       物品管道桥 Plus
        duct_bridge_plus = new DuctBridge("duct-bridge-plus"){{
            // 定义方块的资源需求
            requirements(Category.distribution, with(Items.oxide,5, Items.tungsten, 30,Items.graphite, 10, Items.beryllium, 20, Items.silicon, 20));
            // 方块尺寸为1x1
            size = 1;
            // 传输范围为8格
            range = 8;
            // 方块的生命值
            health = 70;
            // 传输速度为4单位每秒
            speed = 4f;
            // 建造成本乘数为2
            buildCostMultiplier = 2f;
            // 研究成本乘数为0.3
            researchCostMultiplier = 0.5f;
            // 物品容量为8单位
            itemCapacity = 8;
            // 方块的描述
            description = "更长的物品桥";
        }};

//       抽水机
        water_extractor_erekir = new SolidPump("water-extractor-erekir"){{
            requirements(Category.production, with(Items.silicon, 60, Items.beryllium, 60)); //类型：生产类
            result = Liquids.water; // 输出
            pumpAmount = 15f / 60f; // 泵出速度
            size = 2; // 大小
            liquidCapacity = 30f; // 存储容量
            rotateSpeed = 1.4f; // 转速
            consumePower(100f / 60f); // 消耗电力 100/s
            description = "抽水机，可以开采地下水，需要电力";
        }};

//        =============================== Destruction ===============================
//       【毁灭】核心(未完成)
        destruction_core = new CoreBlock("destruction-core")
        {{
            requirements(Category.effect, with(WItems.iron, 1000, WItems.silver, 1000));

            size = 6;//大小
            hasItems = true;//是否储存物品
            itemCapacity = 7000;//容量
            health = 4000;//血量
            unitType = UnitTypes.evoke;//单位类型
            incinerateNonBuildable = true;//焚烧不可建造的物体
            requiresCoreZone = true;//需要在核心区域内使用
            alwaysUnlocked = true;//始终解锁
            unitCapModifier = 20;//单位上限

        }};

        basic_ion_drill = new BeamDrill("basic-ion-drill")
        {{
            requirements(Category.production, with( Items.copper,30));
            size = 2;//大小
            itemCapacity = 5;//存储空间
            health = 200;//血量
            consumePower(0.2f);//电力消耗
            drillTime = 210f;//开采时间
            tier = 1;//开采等级
            range = 4;//开采范围
            researchCost = with(Items.copper,15);//研发成本
            consumeLiquid(Liquids.water,0.5f/60f).boost();//消耗水来加速
        }};

        destructionBlocks.add(
                destruction_core
        );
    }
}
