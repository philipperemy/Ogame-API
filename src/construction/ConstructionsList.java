package construction;

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
    public Mine           metalMine       = new MetalMine();
    public Mine           crystalMine     = new CrystalMine();
    public Mine           deuteriumMine   = new DeuteriumSynthesizer();

    public EnergyProducer solarPlant      = new SolarPlant();
    public EnergyProducer fusionReactor   = new FusionReactor();
    public EnergyProducer SolarSatellite  = new SolarSatellite();

    public Construction   metalStorage    = new MetalStorage();
    public Construction   crystalStorage  = new CrystalStorage();
    public Construction   deuteriumTank   = new DeuteriumTank();

    public Construction   metalDen        = new ShieldedMetalDen();
    public Construction   crystalDen      = new UndergroundCrystalDen();
    public Construction   deuteriumDen    = new SeabedDeuteriumDen();

    public Construction   allianceDepot   = new AllianceDepot();
    public Construction   missileSilo     = new MissileSilo();
    public Construction   naniteFactory   = new NaniteFactory();
    public Construction   researchLab     = new ResearchLab();
    public Construction   roboticsFactory = new RoboticsFactory();
    public Construction   shipyard        = new Shipyard();
    public Construction   terraformer     = new Terraformer();

}
