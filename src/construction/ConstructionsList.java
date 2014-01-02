package construction;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import construction.facility.AllianceDepot;
import construction.facility.MissileSilo;
import construction.facility.NaniteFactory;
import construction.facility.ResearchLab;
import construction.facility.RoboticsFactory;
import construction.facility.Shipyard;
import construction.facility.Terraformer;
import construction.resourcebuilding.den.SeabedDeuteriumDen;
import construction.resourcebuilding.den.ShieldedMetalDen;
import construction.resourcebuilding.den.UndergroundCrystalDen;
import construction.resourcebuilding.mine.CrystalMine;
import construction.resourcebuilding.mine.DeuteriumSynthesizer;
import construction.resourcebuilding.mine.MetalMine;
import construction.resourcebuilding.mine.Mine;
import construction.resourcebuilding.producer.EnergyProducer;
import construction.resourcebuilding.producer.FusionReactor;
import construction.resourcebuilding.producer.SolarPlant;
import construction.resourcebuilding.producer.SolarSatellite;
import construction.resourcebuilding.storage.CrystalStorage;
import construction.resourcebuilding.storage.DeuteriumTank;
import construction.resourcebuilding.storage.MetalStorage;

public class ConstructionsList
{
    private Map<String, Construction> constructionMap       = new HashMap<String, Construction>();
    private String                    planetId;

    public Mine                       metalMineStruct       = new MetalMine();
    public Mine                       crystalMineStruct     = new CrystalMine();
    public Mine                       deuteriumMineStruct   = new DeuteriumSynthesizer();

    public EnergyProducer             solarPlantStruct      = new SolarPlant();
    public EnergyProducer             fusionReactorStruct   = new FusionReactor();
    public EnergyProducer             SolarSatelliteStruct  = new SolarSatellite();

    public Construction               metalStorageStruct    = new MetalStorage();
    public Construction               crystalStorageStruct  = new CrystalStorage();
    public Construction               deuteriumTankStruct   = new DeuteriumTank();

    public Construction               metalDenStruct        = new ShieldedMetalDen();
    public Construction               crystalDenStruct      = new UndergroundCrystalDen();
    public Construction               deuteriumDenStruct    = new SeabedDeuteriumDen();

    public Construction               allianceDepotStruct   = new AllianceDepot();
    public Construction               missileSiloStruct     = new MissileSilo();
    public Construction               naniteFactoryStruct   = new NaniteFactory();
    public Construction               researchLabStruct     = new ResearchLab();
    public Construction               roboticsFactoryStruct = new RoboticsFactory();
    public Construction               shipyardStruct        = new Shipyard();
    public Construction               terraformerStruct     = new Terraformer();

    public ConstructionsList(String planetId)
    {
        setPlanetId(planetId);
        
        put(metalMineStruct);
        put(metalMineStruct);
        put(crystalMineStruct);
        put(deuteriumMineStruct);

        put(solarPlantStruct);
        put(fusionReactorStruct);
        put(SolarSatelliteStruct);

        put(metalStorageStruct);
        put(crystalStorageStruct);
        put(deuteriumTankStruct);

        put(metalDenStruct);
        put(crystalDenStruct);
        put(deuteriumDenStruct);

        put(allianceDepotStruct);
        put(missileSiloStruct);
        put(naniteFactoryStruct);
        put(researchLabStruct);
        put(roboticsFactoryStruct);
        put(shipyardStruct);
        put(terraformerStruct);
    }

    private void put(Construction construction)
    {
        constructionMap.put(construction.getRef(), construction);
    }

    public String getPlanetId()
    {
        return planetId;
    }

    public void setPlanetId(String planetId)
    {
        this.planetId = planetId;
    }

    public Construction getConstruction(String ref)
    {
        return constructionMap.get(ref);
    }
    
    public Collection<Construction> getConstructions()
    {
        return constructionMap.values();
    }

}
