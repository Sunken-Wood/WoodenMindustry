package main.content;

import arc.graphics.Color;
import main.ContentList;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

import static main.content.WBlocks.destruction_core;
import static main.content.WItems.destructionItems;
import static mindustry.content.Items.erekirItems;
import static mindustry.content.Items.serpuloItems;
import static mindustry.content.Planets.erekir;

public class WPlanets implements ContentList {
    // 定义一个新的星球：destruction
    public static Planet destruction,rebuild;

    @Override
    public void load() {
        // 初始化 destruction 星球
        destruction = new Planet("destruction", erekir, 1f, 1){{
            // 设置星球生成器为 ErekirPlanetGenerator
            generator = new ErekirPlanetGenerator();
            // 设置星球的网格生成器为 HexMesh，网格大小为 5
            meshLoader = () -> new HexMesh(this, 5);
            // 设置云层网格生成器为 MultiMesh，包含两个 HexSkyMesh
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.rgb(100, 100, 255).a(0.75f), 2, 0.42f, 1f, 0.43f),
                    new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.rgb(120, 120, 255).a(0.75f), 2, 0.42f, 1.2f, 0.45f)
            );
            // 隐藏物品
            hiddenItems.addAll(serpuloItems).addAll(erekirItems).removeAll(destructionItems);
            // 设置星球始终解锁
            alwaysUnlocked = true;
            // 设置陆地云层颜色
            landCloudColor = Color.rgb(150, 150, 255);
            // 设置大气颜色
            atmosphereColor = Color.rgb(150, 150, 255);
            // 设置默认环境为 scorching 和 terrestrial
            defaultEnv = Env.scorching | Env.terrestrial;
            // 设置起始 sector 为 10
            startSector = 10;
            // 设置大气半径（内）
            atmosphereRadIn = 0.02f;
            // 设置大气半径（外）
            atmosphereRadOut = 0.3f;
            // 设置星球为潮汐锁定
            tidalLock = false;
            // 设置轨道间距
            orbitSpacing = 2f;
            // 增加总半径
            totalRadius += 2.6f;
            // 设置光源到星球的距离
            lightSrcTo = 0.5f;
            // 设置光源从星球的距离
            lightDstFrom = 0.2f;
            // 设置在失败时清除 sector
            clearSectorOnLose = true;
            // 设置图标颜色
            iconColor = Color.rgb(150, 150, 255);
            // 设置敌对建筑速度乘数
            enemyBuildSpeedMultiplier = 0.4f;
            // 设置起始 sector 为 5
            startSector = 5;

            // 暂时不允许编号发射
            allowLaunchToNumbered = false;

            // 是否更新光照
            updateLighting = false;

            // 设置默认属性：heat 为 0.8
            defaultAttributes.set(Attribute.heat, 0.8f);

            // 设置规则设置器
            ruleSetter = r -> {
                // 设置 wave 队伍为 malis
                r.waveTeam = Team.malis;
                // 关闭放置范围检查
                r.placeRangeCheck = false;
                // 显示出生点
                r.showSpawns = true;
                // 启用雾效
                r.fog = true;
                // 启用静态雾效
                r.staticFog = true;
                // 关闭光照
                r.lighting = false;
                // 核心被摧毁时清除
                r.coreDestroyClear = true;
                // 仅在核心处存款
                r.onlyDepositCore = true;
            };

            unlockedOnLand.add(destruction_core);
        }};
    }
}
