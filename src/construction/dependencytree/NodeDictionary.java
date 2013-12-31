package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;

public class NodeDictionary
{
    private static List<Node> nodes = new ArrayList<>();
    
    public static void addNode(Node node)
    {
        nodes.add(node);
    }
    
    //Poor efficiency but it's all right
    public static Node getNode(String data)
    {
        for(Node node : nodes)
        {
            if(node.data.equals(data))
            {
                return node;
            }
        }
        
        //Already built and no dependencies if came there.
        return getNode();
    }
    
    public static Node getNode()
    {
        return rootNode;
    }
    
    public static final Node ResearchLab1                 = new Node("ResearchLab1");
    public static final Node EnergyTechnology1            = new Node("EnergyTechnology1");
    public static final Node ResearchLab2                 = new Node("ResearchLab2");
    public static final Node ComputerTechnology1          = new Node("ComputerTechnology1");

    public static final Node ArmourTechnology1            = new Node("ArmourTechnology1");
    public static final Node ImpulseDrive1                = new Node("ImpulseDrive1");
    public static final Node ResearchLab3                 = new Node("ResearchLab3");

    public static final Node ComputerTechnology2          = new Node("ComputerTechnology2");
    public static final Node ComputerTechnology3          = new Node("ComputerTechnology3");
    public static final Node ComputerTechnology4          = new Node("ComputerTechnology4");
    public static final Node ComputerTechnology5          = new Node("ComputerTechnology5");
    public static final Node ComputerTechnology6          = new Node("ComputerTechnology6");
    public static final Node ComputerTechnology7          = new Node("ComputerTechnology7");
    public static final Node ComputerTechnology8          = new Node("ComputerTechnology8");
    public static final Node ComputerTechnology9          = new Node("ComputerTechnology9");
    public static final Node ComputerTechnology10         = new Node("ComputerTechnology10");

    public static final Node RoboticsFactory1             = new Node("RoboticsFactory1");
    public static final Node RoboticsFactory2             = new Node("RoboticsFactory2");
    public static final Node RoboticsFactory3             = new Node("RoboticsFactory3");
    public static final Node RoboticsFactory4             = new Node("RoboticsFactory4");
    public static final Node RoboticsFactory5             = new Node("RoboticsFactory5");
    public static final Node RoboticsFactory6             = new Node("RoboticsFactory6");
    public static final Node RoboticsFactory7             = new Node("RoboticsFactory7");
    public static final Node RoboticsFactory8             = new Node("RoboticsFactory8");
    public static final Node RoboticsFactory9             = new Node("RoboticsFactory9");
    public static final Node RoboticsFactory10            = new Node("RoboticsFactory10");

    public static final Node Shipyard1                    = new Node("Shipyard1");

    public static final Node CombustionDrive1             = new Node("CombustionDrive1");

    public static final Node EnergyTechnology2            = new Node("EnergyTechnology2");

    public static final Node ResearchLab4                 = new Node("ResearchLab4");
    public static final Node ResearchLab5                 = new Node("ResearchLab5");
    public static final Node ResearchLab6                 = new Node("ResearchLab6");
    public static final Node ResearchLab7                 = new Node("ResearchLab7");
    public static final Node ResearchLab8                 = new Node("ResearchLab8");
    public static final Node ResearchLab9                 = new Node("ResearchLab9");
    public static final Node ResearchLab10                = new Node("ResearchLab10");
    public static final Node ResearchLab11                = new Node("ResearchLab11");
    public static final Node ResearchLab12                = new Node("ResearchLab12");

    public static final Node GravitonTechnology           = new Node("GravitonTechnology");

    public static final Node DeathStar                    = new Node("DeathStar");

    public static final Node IntergalacticResearchNetwork = new Node("IntergalacticResearchNetwork");

    public static final Node NaniteFactory1               = new Node("NaniteFactory1");

    public static final Node Terraformer                  = new Node("Terraformer");

    public static final Node LunarBase                    = new Node("LunarBase");
    public static final Node baseLunaire                  = new Node("baseLunaire");

    public static final Node JumpGate                     = new Node("JumpGate");
    public static final Node SensorPhalanx                = new Node("SensorPhalanx");

    public static final Node LaserTechnology1             = new Node("LaserTechnology1");
    public static final Node LaserTechnology2             = new Node("LaserTechnology2");
    public static final Node LaserTechnology3             = new Node("LaserTechnology3");
    public static final Node LaserTechnology4             = new Node("LaserTechnology4");
    public static final Node LaserTechnology5             = new Node("LaserTechnology5");
    public static final Node LaserTechnology6             = new Node("LaserTechnology6");
    public static final Node LaserTechnology7             = new Node("LaserTechnology7");
    public static final Node LaserTechnology8             = new Node("LaserTechnology8");
    public static final Node LaserTechnology9             = new Node("LaserTechnology9");
    public static final Node LaserTechnology10            = new Node("LaserTechnology10");
    public static final Node LaserTechnology11            = new Node("LaserTechnology11");
    public static final Node LaserTechnology12            = new Node("LaserTechnology12");

    public static final Node DeuteriumSynthesizer1        = new Node("DeuteriumSynthesizer1");
    public static final Node DeuteriumSynthesizer2        = new Node("DeuteriumSynthesizer2");
    public static final Node DeuteriumSynthesizer3        = new Node("DeuteriumSynthesizer3");
    public static final Node DeuteriumSynthesizer4        = new Node("DeuteriumSynthesizer4");
    public static final Node DeuteriumSynthesizer5        = new Node("DeuteriumSynthesizer5");

    public static final Node fusionReactor                = new Node("fusionReactor");

    public static final Node Shipyard2                    = new Node("Shipyard2");

    public static final Node LightLaser                   = new Node("LightLaser");
    public static final Node LightFighter                 = new Node("LightFighter");

    public static final Node EnergyTechnology3            = new Node("EnergyTechnology3");
    public static final Node EnergyTechnology4            = new Node("EnergyTechnology4");
    public static final Node EnergyTechnology5            = new Node("EnergyTechnology5");
    public static final Node EnergyTechnology6            = new Node("EnergyTechnology6");
    public static final Node EnergyTechnology7            = new Node("EnergyTechnology7");
    public static final Node EnergyTechnology8            = new Node("EnergyTechnology8");
    public static final Node EnergyTechnology9            = new Node("EnergyTechnology9");
    public static final Node EnergyTechnology10           = new Node("EnergyTechnology10");
    public static final Node EnergyTechnology11           = new Node("EnergyTechnology11");
    public static final Node EnergyTechnology12           = new Node("EnergyTechnology12");

    public static final Node ShieldingTechnology1         = new Node("ShieldingTechnology1");
    public static final Node ShieldingTechnology2         = new Node("ShieldingTechnology2");
    public static final Node ShieldingTechnology3         = new Node("ShieldingTechnology3");
    public static final Node ShieldingTechnology4         = new Node("ShieldingTechnology4");
    public static final Node ShieldingTechnology5         = new Node("ShieldingTechnology5");
    public static final Node ShieldingTechnology6         = new Node("ShieldingTechnology6");

    public static final Node ImpulseDrive2                = new Node("ImpulseDrive2");
    public static final Node ImpulseDrive3                = new Node("ImpulseDrive3");

    public static final Node EspionageTechnology1         = new Node("EspionageTechnology1");
    public static final Node EspionageTechnology2         = new Node("EspionageTechnology2");
    public static final Node EspionageTechnology3         = new Node("EspionageTechnology3");
    public static final Node EspionageTechnology4         = new Node("EspionageTechnology4");

    public static final Node technologieExpeditions       = new Node("technologieExpeditions");

    public static final Node HyperspaceDrive1             = new Node("HyperspaceDrive1");
    public static final Node HyperspaceDrive2             = new Node("HyperspaceDrive2");
    public static final Node HyperspaceDrive3             = new Node("HyperspaceDrive3");
    public static final Node HyperspaceDrive4             = new Node("HyperspaceDrive4");
    public static final Node HyperspaceDrive5             = new Node("HyperspaceDrive5");
    public static final Node HyperspaceDrive6             = new Node("HyperspaceDrive6");
    public static final Node HyperspaceDrive7             = new Node("HyperspaceDrive7");

    public static final Node HyperspaceTechnology1        = new Node("HyperspaceTechnology1");
    public static final Node HyperspaceTechnology2        = new Node("HyperspaceTechnology2");
    public static final Node HyperspaceTechnology3        = new Node("HyperspaceTechnology3");
    public static final Node HyperspaceTechnology4        = new Node("HyperspaceTechnology4");
    public static final Node HyperspaceTechnology5        = new Node("HyperspaceTechnology5");
    public static final Node HyperspaceTechnology6        = new Node("HyperspaceTechnology6");
    public static final Node HyperspaceTechnology7        = new Node("HyperspaceTechnology7");
    public static final Node HyperspaceTechnology8        = new Node("HyperspaceTechnology8");

    public static final Node Shipyard3                    = new Node("Shipyard3");
    public static final Node Shipyard4                    = new Node("Shipyard4");
    public static final Node Shipyard5                    = new Node("Shipyard5");
    public static final Node Shipyard6                    = new Node("Shipyard6");
    public static final Node Shipyard7                    = new Node("Shipyard7");
    public static final Node Shipyard8                    = new Node("Shipyard8");
    public static final Node Shipyard9                    = new Node("Shipyard9");
    public static final Node Shipyard10                   = new Node("Shipyard10");
    public static final Node Shipyard11                   = new Node("Shipyard11");
    public static final Node Shipyard12                   = new Node("Shipyard12");

    public static final Node IonTechnology1               = new Node("IonTechnology1");
    public static final Node IonTechnology2               = new Node("IonTechnology2");
    public static final Node IonTechnology3               = new Node("IonTechnology3");
    public static final Node IonTechnology4               = new Node("IonTechnology4");
    public static final Node IonTechnology5               = new Node("IonTechnology5");

    public static final Node PlasmaTechnology1            = new Node("PlasmaTechnology1");
    public static final Node PlasmaTechnology2            = new Node("PlasmaTechnology2");
    public static final Node PlasmaTechnology3            = new Node("PlasmaTechnology3");
    public static final Node PlasmaTechnology4            = new Node("PlasmaTechnology4");
    public static final Node PlasmaTechnology5            = new Node("PlasmaTechnology5");
    public static final Node PlasmaTechnology6            = new Node("PlasmaTechnology6");
    public static final Node PlasmaTechnology7            = new Node("PlasmaTechnology7");

    public static final Node traquer                      = new Node("traquer");
    public static final Node BattleShip                   = new Node("BattleShip");
    public static final Node Destroyer                    = new Node("Destroyer");
    public static final Node LargeShieldDome              = new Node("LargeShieldDome");
    public static final Node PlasmaTurret                 = new Node("PlasmaTurret");
    public static final Node Bomber                       = new Node("Bomber");
    public static final Node ImpulseDrive4                = new Node("ImpulseDrive4");
    public static final Node ImpulseDrive5                = new Node("ImpulseDrive5");

    public static final Node ImpulseDrive6                = new Node("ImpulseDrive6");

    public static final Node IonCannon                    = new Node("IonCannon");

    public static final Node Cruiser                      = new Node("Cruiser");

    public static final Node WeaponsTechnology1           = new Node("WeaponsTechnology1");

    public static final Node WeaponsTechnology2           = new Node("WeaponsTechnology2");

    public static final Node WeaponsTechnology3           = new Node("WeaponsTechnology3");
    public static final Node GaussCannon                  = new Node("GaussCannon");
    public static final Node ArmourTechnology2            = new Node("ArmourTechnology2");

    public static final Node HeavyFighter                 = new Node("HeavyFighter");
    public static final Node InterplanetaryMissiles       = new Node("InterplanetaryMissiles");

    public static final Node SmallShieldDome              = new Node("SmallShieldDome");

    public static final Node MissileSilo1                 = new Node("MissileSilo1");
    public static final Node MissileSilo2                 = new Node("MissileSilo2");
    public static final Node MissileSilo3                 = new Node("MissileSilo3");
    public static final Node MissileSilo4                 = new Node("MissileSilo4");

    public static final Node Recycler                     = new Node("Recycler");

    public static final Node ColonyShip                   = new Node("ColonyShip");

    public static final Node LargeCargoShip               = new Node("LargeCargoShip");

    public static final Node CombustionDrive2             = new Node("CombustionDrive2");
    public static final Node CombustionDrive3             = new Node("CombustionDrive3");
    public static final Node CombustionDrive4             = new Node("CombustionDrive4");
    public static final Node CombustionDrive5             = new Node("CombustionDrive5");
    public static final Node CombustionDrive6             = new Node("CombustionDrive6");
    
    public static final Node SmallCargoShip               = new Node("SmallCargoShip");

    public static final Node EspionageProbe               = new Node("EspionageProbe");

    public static final Node HeavyLaser                   = new Node("HeavyLaser");
    public static final Node SolarSatellite               = new Node("SolarSatellite");
    public static final Node rocketLauncher               = new Node("rocketLauncher");
    public static final Node AntiBallisticMissiles        = new Node("AntiBallisticMissiles");
    public static final Node rootNode                     = new Node("RootNode");
}
