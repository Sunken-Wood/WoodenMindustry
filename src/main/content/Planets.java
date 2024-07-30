package main.content;

import arc.graphics.Color;
import main.ContentList;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

import static main.content.Blocks.destruction_core;
import static mindustry.content.Planets.*;

public class Planets implements ContentList {
    public static Planet
        destruction,
        rebuilds;

    @Override
    public void load() {
        destruction = new Planet("destruction", sun, 1f, 2){{
            alwaysUnlocked = true;
            generator = new ErekirPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5); // division 划分
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 0.5f, 0.15f, 5, Color.rgb(150,150,255).a(0.72f), 2, 0.42f, 1f, 0.43f),
                    new HexSkyMesh(this, 3, 0.8f, 0.17f, 5, Color.rgb(100, 100, 255).a(0.72f), 2, 0.42f, 1f, 0.44f)
            );
            landCloudColor = Color.rgb(120, 120, 255);
            atmosphereColor =Color.rgb(255, 150, 150);
            defaultEnv = Env.scorching | Env.terrestrial;
            startSector = 5;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut =0.3f;
            tidalLock = true;
            orbitSpacing = 2f;
            totalRadius += 3.0f;
            lightSrcTo = 0.5f;
            lightDstFrom =0.2f;
            clearSectorOnLose = true;
            defaultCore = destruction_core;
            iconColor = Color.rgb(150, 150 ,255);
            enemyBuildSpeedMultiplier = 0.4f;

            allowLaunchToNumbered = false;

            updateLighting = false;

            defaultAttributes.set(Attribute.heat, 0.8f);

            ruleSetter = r -> {
                r.waveTeam = Team.malis;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };
        }};
    }
}
