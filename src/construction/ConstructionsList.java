package construction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import logger.Logger;
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
import construction.resourcebuilding.storage.CrystalStorage;
import construction.resourcebuilding.storage.DeuteriumTank;
import construction.resourcebuilding.storage.MetalStorage;

public class ConstructionsList
{
    // Do not change this attribute name.
    private String        planetId;
    
    public Mine           metalMineStruct       = new MetalMine();
    public Mine           crystalMineStruct     = new CrystalMine();
    public Mine           deuteriumMineStruct   = new DeuteriumSynthesizer();

    public EnergyProducer solarPlantStruct      = new SolarPlant();
    public EnergyProducer fusionReactorStruct   = new FusionReactor();

    public Construction   metalStorageStruct    = new MetalStorage();
    public Construction   crystalStorageStruct  = new CrystalStorage();
    public Construction   deuteriumTankStruct   = new DeuteriumTank();

    public Construction   metalDenStruct        = new ShieldedMetalDen();
    public Construction   crystalDenStruct      = new UndergroundCrystalDen();
    public Construction   deuteriumDenStruct    = new SeabedDeuteriumDen();

    public Construction   allianceDepotStruct   = new AllianceDepot();
    public Construction   missileSiloStruct     = new MissileSilo();
    public Construction   naniteFactoryStruct   = new NaniteFactory();
    public Construction   researchLabStruct     = new ResearchLab();
    public Construction   roboticsFactoryStruct = new RoboticsFactory();
    public Construction   shipyardStruct        = new Shipyard();
    public Construction   terraformerStruct     = new Terraformer();

    public ConstructionsList(String planetId)
    {
        setPlanetId(planetId);
    }

    public String getPlanetId()
    {
        return planetId;
    }

    public void setPlanetId(String planetId)
    {
        this.planetId = planetId;
    }

    public void update(String constructionName, int level)
    {
        try
        {
            switch (constructionName)
            {
                case NamingFactory.MetalMine:
                    initStruct(metalMineStruct, level);
                    break;

                case NamingFactory.CrystalMine:
                    initStruct(crystalMineStruct, level);
                    break;

                case NamingFactory.DeuteriumSynthesizer:
                    initStruct(deuteriumMineStruct, level);
                    break;

                case NamingFactory.SolarPlant:
                    initStruct(solarPlantStruct, level);
                    break;

                case NamingFactory.FusionReactor:
                    initStruct(fusionReactorStruct, level);
                    break;
                    
                case NamingFactory.MetalStorage:
                    initStruct(metalStorageStruct, level);
                    break;

                case NamingFactory.CrystalStorage:
                    initStruct(crystalStorageStruct, level);
                    break;

                case NamingFactory.DeuteriumTank:
                    initStruct(deuteriumTankStruct, level);
                    break;

                case NamingFactory.ShieldedMetalDen:
                    initStruct(metalDenStruct, level);
                    break;

                case NamingFactory.UndergroundCrystalDen:
                    initStruct(crystalDenStruct, level);
                    break;

                case NamingFactory.SeabedDeuteriumDen:
                    initStruct(deuteriumDenStruct, level);
                    break;

                case NamingFactory.AllianceDepot:
                    initStruct(allianceDepotStruct, level);
                    break;

                case NamingFactory.MissileSilo:
                    initStruct(missileSiloStruct, level);
                    break;

                case NamingFactory.NaniteFactory:
                    initStruct(naniteFactoryStruct, level);
                    break;

                case NamingFactory.ResearchLab:
                    initStruct(researchLabStruct, level);
                    break;

                case NamingFactory.RoboticsFactory:
                    initStruct(roboticsFactoryStruct, level);
                    break;

                case NamingFactory.Shipyard:
                    initStruct(shipyardStruct, level);
                    break;

                case NamingFactory.Terraformer:
                    initStruct(terraformerStruct, level);
                    break;

                default:
                    throw new RuntimeException("Unknown construction name : " + constructionName);
            }
        }
        catch (Exception e)
        {
            Logger.traceERROR(e);
        }
    }

    public List<Construction> listAllConstructions()
    {
        List<Construction> list = new ArrayList<>();
        for (Field structField : getClass().getDeclaredFields())
        {
            if (!structField.getName().equals("planetId") && !structField.getName().equals("allConstructionsList"))
            {
                try
                {
                    Construction struct = (Construction) structField.get(this);
                    do
                    {
                        list.add(struct);
                    }
                    while ((struct = struct.getPrevious()) != null);
                }
                catch (Exception e)
                {
                    Logger.traceERROR(e);
                }
            }
        }
        return list;
    }

    public void initStruct(Construction struct, int level) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException
    {
        if(level > 0)
        {
            Construction[] constructions = new Construction[level - 1];
            for (int i = 0; i < level - 1; i++)
            {
                Class<?> clazz = Class.forName(struct.getClass().getName());
                Constructor<?> ctor = clazz.getConstructors()[0];
                Object object = ctor.newInstance();
                constructions[i] = struct.getClass().cast(object);
            }
            
            if (struct.getLevel() == null)
            {
                Construction previousPtr = null;
                for (int i = 0; i < level - 1; i++)
                {
                    Construction current = constructions[i];
                    current.setLevel(i + 1);
                    
                    if (i != 0)
                    {
                        current.setPrevious(previousPtr);
                    }
                    
                    previousPtr = current;
                }
                
                struct.setLevel(level);
                struct.setPrevious(previousPtr);
            }            
        }
    }
}
