package main;

import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.Planet;

public class Planets implements ContentList{
    public static Planet
        Era_Rebuild;

    @Override
    public void load() {
        Era_Rebuild = new Planet("RebuildPlanet", mindustry.content.Planets.sun, 1f, 2){{
            generator = new ErekirPlanetGenerator();
        }};
    }
}
