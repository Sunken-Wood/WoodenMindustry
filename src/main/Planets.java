package main;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

public class Planets implements ContentList{
    public static Planet
        Era_Rebuild;

    @Override
    public void load() {
        Era_Rebuild = new Planet("RebuildPlanet", mindustry.content.Planets.sun, 1f, 2){{
            generator = new ErekirPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.rgb(1, 0, 0).a(0.75f), 2, 0.42f, 1f, 0.43f)
            );
//            alwaysUnlocked = true;
            landCloudColor = Color.rgb(0,1,0);
            atmosphereColor =Color.rgb(0,0,1);
            defaultEnv = Env.scorching | Env.terrestrial;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            tidalLock = true;
            totalRadius += 0.6f;
            lightSrcFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = Blocks.coreBastion;
            iconColor = Color.valueOf("ff9266");
            hiddenItems.addAll(Items.serpuloItems).removeAll(Items.erekirItems);
            enemyBuildSpeedMultiplier = 0.4f;

            //TODO disallowed for now
            allowLaunchToNumbered = false;

            //TODO SHOULD there be lighting?
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
