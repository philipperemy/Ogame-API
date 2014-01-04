package construction;

import java.util.HashMap;
import java.util.Map;

public class ConstructionRefManager
{
    private static Map<String, String> nameByRef = new HashMap<String, String>();

    public static String getNameByRef(String ref)
    {
        String constructionName = nameByRef.get(ref);
        if (constructionName == null)
        {
            throw new RuntimeException("Unknown construction ref");
        }

        return constructionName;
    }

    /**
     * buildings
     */
    public static final String ALLIANCE_DEPOT_REF          = "34";
    public static final String MISSILE_SILO_REF            = "44";
    public static final String NANITE_FACTORY_REF          = "15";
    public static final String RESEARCH_LAB_REF            = "31";
    public static final String ROBOTICS_FACTORY_REF        = "14";
    public static final String SHIPYARD_REF                = "21";
    public static final String TERRAFORMER_REF             = "33";
    public static final String SEABED_DEUTERIUM_DEN_REF    = "27";
    public static final String SHIELDED_METAL_DEN_REF      = "25";
    public static final String UNDERGROUND_CRYSTAL_DEN_REF = "26";
    public static final String CRYSTAL_MINE_REF            = "2";
    public static final String DEUTERIUM_SYNTHETISER_REF   = "3";
    public static final String METAL_MINE_REF_REF          = "1";
    public static final String FUSION_REACTOR_REF          = "12";
    public static final String SOLAR_PLANT_REF             = "4";
    public static final String SOLAR_SATELLITE_REF         = "212";
    public static final String CRYSTAL_STORAGE_REF         = "23";
    public static final String DEUTERIUM_TANK_REF          = "24";
    public static final String METAL_STORAGE_REF           = "22";

    /**
     * vessels
     */
    public static final String BATTLE_CRUISER_REF          = "215";
    public static final String BATTLESHIP_REF              = "207";
    public static final String BOMBER_REF                  = "211";
    public static final String COLONY_SHIP_REF             = "208";
    public static final String CRUISER_REF                 = "206";
    public static final String DEATH_STAR_REF              = "214";
    public static final String DESTROYER_REF               = "213";
    public static final String ESPIONAGE_PROBE_REF         = "210";
    public static final String HEAVY_FIGHTER_REF           = "205";
    public static final String LARGE_CARGO_REF             = "203";
    public static final String LIGHT_FIGHTER_REF           = "204";
    public static final String RECYCLER_REF                = "209";
    public static final String SMALL_CARGO_REF             = "202";

    static
    {
        nameByRef.put(ALLIANCE_DEPOT_REF, NamingFactory.AllianceDepot);
        nameByRef.put(MISSILE_SILO_REF, NamingFactory.MissileSilo);
        nameByRef.put(NANITE_FACTORY_REF, NamingFactory.NaniteFactory);
        nameByRef.put(RESEARCH_LAB_REF, NamingFactory.ResearchLab);
        nameByRef.put(ROBOTICS_FACTORY_REF, NamingFactory.RoboticsFactory);
        nameByRef.put(SHIPYARD_REF, NamingFactory.Shipyard);
        nameByRef.put(TERRAFORMER_REF, NamingFactory.Terraformer);
        nameByRef.put(SEABED_DEUTERIUM_DEN_REF, NamingFactory.SeabedDeuteriumDen);
        nameByRef.put(SHIELDED_METAL_DEN_REF, NamingFactory.ShieldedMetalDen);
        nameByRef.put(UNDERGROUND_CRYSTAL_DEN_REF, NamingFactory.UndergroundCrystalDen);
        nameByRef.put(CRYSTAL_MINE_REF, NamingFactory.CrystalMine);
        nameByRef.put(DEUTERIUM_SYNTHETISER_REF, NamingFactory.DeuteriumSynthesizer);
        nameByRef.put(METAL_MINE_REF_REF, NamingFactory.MetalMine);
        nameByRef.put(FUSION_REACTOR_REF, NamingFactory.FusionReactor);
        nameByRef.put(SOLAR_PLANT_REF, NamingFactory.SolarPlant);
        nameByRef.put(SOLAR_SATELLITE_REF, NamingFactory.SolarSatellite);
        nameByRef.put(CRYSTAL_STORAGE_REF, NamingFactory.CrystalStorage);
        nameByRef.put(DEUTERIUM_TANK_REF, NamingFactory.DeuteriumTank);
        nameByRef.put(METAL_STORAGE_REF, NamingFactory.MetalStorage);

        nameByRef.put(BATTLE_CRUISER_REF, NamingFactory.BattleCruiser);
        nameByRef.put(BATTLESHIP_REF, NamingFactory.BattleShip);
        nameByRef.put(BOMBER_REF, NamingFactory.Bomber);
        nameByRef.put(COLONY_SHIP_REF, NamingFactory.ColonyShip);
        nameByRef.put(CRUISER_REF, NamingFactory.Cruiser);
        nameByRef.put(DEATH_STAR_REF, NamingFactory.DeathStar);
        nameByRef.put(DESTROYER_REF, NamingFactory.Destroyer);
        nameByRef.put(ESPIONAGE_PROBE_REF, NamingFactory.EspionageProbe);
        nameByRef.put(HEAVY_FIGHTER_REF, NamingFactory.HeavyFighter);
        nameByRef.put(LARGE_CARGO_REF, NamingFactory.LargeCargoShip);
        nameByRef.put(LIGHT_FIGHTER_REF, NamingFactory.LightFighter);
        nameByRef.put(RECYCLER_REF, NamingFactory.Recycler);
        nameByRef.put(SMALL_CARGO_REF, NamingFactory.SmallCargoShip);

    }

}
