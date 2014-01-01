package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;
import construction.NamingFactory;

public class NodeDictionary
{
    private static List<Node> nodes = new ArrayList<>();

    public static void addNode(Node node)
    {
        nodes.add(node);
    }

    public static List<Node> getAll()
    {
        return nodes;
    }

    // Poor efficiency but it's all right
    public static Node getNode(String data)
    {
        for (Node node : nodes)
        {
            if (node.data.equals(data))
            {
                return node;
            }
        }

        // Already built and no dependencies if came there.
        return getNode();
    }

    public static Node getNode()
    {
        return rootNode;
    }

    public static final Node ResearchLab1                 = new Node(NamingFactory.ResearchLab + "1");
    public static final Node EnergyTechnology1            = new Node(NamingFactory.EnergyTechnology + "1");
    public static final Node ResearchLab2                 = new Node(NamingFactory.ResearchLab + "2");
    public static final Node ComputerTechnology1          = new Node(NamingFactory.ComputerTechnology + "1");

    public static final Node ArmourTechnology1            = new Node(NamingFactory.ArmourTechnology + "1");
    public static final Node ImpulseDrive1                = new Node(NamingFactory.ImpulseDrive + "1");
    public static final Node ResearchLab3                 = new Node(NamingFactory.ResearchLab + "3");

    public static final Node ComputerTechnology2          = new Node(NamingFactory.ComputerTechnology + "2");
    public static final Node ComputerTechnology3          = new Node(NamingFactory.ComputerTechnology + "3");
    public static final Node ComputerTechnology4          = new Node(NamingFactory.ComputerTechnology + "4");
    public static final Node ComputerTechnology5          = new Node(NamingFactory.ComputerTechnology + "5");
    public static final Node ComputerTechnology6          = new Node(NamingFactory.ComputerTechnology + "6");
    public static final Node ComputerTechnology7          = new Node(NamingFactory.ComputerTechnology + "7");
    public static final Node ComputerTechnology8          = new Node(NamingFactory.ComputerTechnology + "8");
    public static final Node ComputerTechnology9          = new Node(NamingFactory.ComputerTechnology + "9");
    public static final Node ComputerTechnology10         = new Node(NamingFactory.ComputerTechnology + "10");

    public static final Node RoboticsFactory1             = new Node(NamingFactory.RoboticsFactory + "1");
    public static final Node RoboticsFactory2             = new Node(NamingFactory.RoboticsFactory + "2");
    public static final Node RoboticsFactory3             = new Node(NamingFactory.RoboticsFactory + "3");
    public static final Node RoboticsFactory4             = new Node(NamingFactory.RoboticsFactory + "4");
    public static final Node RoboticsFactory5             = new Node(NamingFactory.RoboticsFactory + "5");
    public static final Node RoboticsFactory6             = new Node(NamingFactory.RoboticsFactory + "6");
    public static final Node RoboticsFactory7             = new Node(NamingFactory.RoboticsFactory + "7");
    public static final Node RoboticsFactory8             = new Node(NamingFactory.RoboticsFactory + "8");
    public static final Node RoboticsFactory9             = new Node(NamingFactory.RoboticsFactory + "9");
    public static final Node RoboticsFactory10            = new Node(NamingFactory.RoboticsFactory + "10");

    public static final Node Shipyard1                    = new Node(NamingFactory.Shipyard + "1");

    public static final Node CombustionDrive1             = new Node(NamingFactory.CombustionDrive + "1");

    public static final Node EnergyTechnology2            = new Node(NamingFactory.EnergyTechnology + "2");

    public static final Node ResearchLab4                 = new Node(NamingFactory.ResearchLab + "4");
    public static final Node ResearchLab5                 = new Node(NamingFactory.ResearchLab + "5");
    public static final Node ResearchLab6                 = new Node(NamingFactory.ResearchLab + "6");
    public static final Node ResearchLab7                 = new Node(NamingFactory.ResearchLab + "7");
    public static final Node ResearchLab8                 = new Node(NamingFactory.ResearchLab + "8");
    public static final Node ResearchLab9                 = new Node(NamingFactory.ResearchLab + "9");
    public static final Node ResearchLab10                = new Node(NamingFactory.ResearchLab + "10");
    public static final Node ResearchLab11                = new Node(NamingFactory.ResearchLab + "11");
    public static final Node ResearchLab12                = new Node(NamingFactory.ResearchLab + "12");

    public static final Node GravitonTechnology           = new Node(NamingFactory.GravitonTechnology);

    public static final Node DeathStar                    = new Node(NamingFactory.DeathStar);

    public static final Node IntergalacticResearchNetwork = new Node(NamingFactory.IntergalacticResearchNetwork);

    public static final Node NaniteFactory1               = new Node(NamingFactory.NaniteFactory + "1");

    public static final Node Terraformer                  = new Node(NamingFactory.Terraformer);

    public static final Node LunarBase                    = new Node(NamingFactory.LunarBase);

    public static final Node JumpGate                     = new Node(NamingFactory.JumpGate);
    public static final Node SensorPhalanx                = new Node(NamingFactory.SensorPhalanx);

    public static final Node LaserTechnology1             = new Node(NamingFactory.LaserTechnology + "1");
    public static final Node LaserTechnology2             = new Node(NamingFactory.LaserTechnology + "2");
    public static final Node LaserTechnology3             = new Node(NamingFactory.LaserTechnology + "3");
    public static final Node LaserTechnology4             = new Node(NamingFactory.LaserTechnology + "4");
    public static final Node LaserTechnology5             = new Node(NamingFactory.LaserTechnology + "5");
    public static final Node LaserTechnology6             = new Node(NamingFactory.LaserTechnology + "6");
    public static final Node LaserTechnology7             = new Node(NamingFactory.LaserTechnology + "7");
    public static final Node LaserTechnology8             = new Node(NamingFactory.LaserTechnology + "8");
    public static final Node LaserTechnology9             = new Node(NamingFactory.LaserTechnology + "9");
    public static final Node LaserTechnology10            = new Node(NamingFactory.LaserTechnology + "10");
    public static final Node LaserTechnology11            = new Node(NamingFactory.LaserTechnology + "11");
    public static final Node LaserTechnology12            = new Node(NamingFactory.LaserTechnology + "12");

    public static final Node DeuteriumSynthesizer1        = new Node(NamingFactory.DeuteriumSynthesizer + "1");
    public static final Node DeuteriumSynthesizer2        = new Node(NamingFactory.DeuteriumSynthesizer + "2");
    public static final Node DeuteriumSynthesizer3        = new Node(NamingFactory.DeuteriumSynthesizer + "3");
    public static final Node DeuteriumSynthesizer4        = new Node(NamingFactory.DeuteriumSynthesizer + "4");
    public static final Node DeuteriumSynthesizer5        = new Node(NamingFactory.DeuteriumSynthesizer + "5");

    public static final Node FusionReactor                = new Node(NamingFactory.FusionReactor);

    public static final Node Shipyard2                    = new Node(NamingFactory.Shipyard + "2");

    public static final Node LightLaser                   = new Node(NamingFactory.LightLaser);
    public static final Node LightFighter                 = new Node(NamingFactory.LightFighter);

    public static final Node EnergyTechnology3            = new Node(NamingFactory.EnergyTechnology + "3");
    public static final Node EnergyTechnology4            = new Node(NamingFactory.EnergyTechnology + "4");
    public static final Node EnergyTechnology5            = new Node(NamingFactory.EnergyTechnology + "5");
    public static final Node EnergyTechnology6            = new Node(NamingFactory.EnergyTechnology + "6");
    public static final Node EnergyTechnology7            = new Node(NamingFactory.EnergyTechnology + "7");
    public static final Node EnergyTechnology8            = new Node(NamingFactory.EnergyTechnology + "8");
    public static final Node EnergyTechnology9            = new Node(NamingFactory.EnergyTechnology + "9");
    public static final Node EnergyTechnology10           = new Node(NamingFactory.EnergyTechnology + "10");
    public static final Node EnergyTechnology11           = new Node(NamingFactory.EnergyTechnology + "11");
    public static final Node EnergyTechnology12           = new Node(NamingFactory.EnergyTechnology + "12");

    public static final Node ShieldingTechnology1         = new Node(NamingFactory.ShieldingTechnology + "1");
    public static final Node ShieldingTechnology2         = new Node(NamingFactory.ShieldingTechnology + "2");
    public static final Node ShieldingTechnology3         = new Node(NamingFactory.ShieldingTechnology + "3");
    public static final Node ShieldingTechnology4         = new Node(NamingFactory.ShieldingTechnology + "4");
    public static final Node ShieldingTechnology5         = new Node(NamingFactory.ShieldingTechnology + "5");
    public static final Node ShieldingTechnology6         = new Node(NamingFactory.ShieldingTechnology + "6");

    public static final Node ImpulseDrive2                = new Node(NamingFactory.ImpulseDrive + "2");
    public static final Node ImpulseDrive3                = new Node(NamingFactory.ImpulseDrive + "3");

    public static final Node EspionageTechnology1         = new Node(NamingFactory.EspionageTechnology + "1");
    public static final Node EspionageTechnology2         = new Node(NamingFactory.EspionageTechnology + "2");
    public static final Node EspionageTechnology3         = new Node(NamingFactory.EspionageTechnology + "3");
    public static final Node EspionageTechnology4         = new Node(NamingFactory.EspionageTechnology + "4");

    public static final Node HyperspaceDrive1             = new Node(NamingFactory.HyperspaceDrive + "1");
    public static final Node HyperspaceDrive2             = new Node(NamingFactory.HyperspaceDrive + "2");
    public static final Node HyperspaceDrive3             = new Node(NamingFactory.HyperspaceDrive + "3");
    public static final Node HyperspaceDrive4             = new Node(NamingFactory.HyperspaceDrive + "4");
    public static final Node HyperspaceDrive5             = new Node(NamingFactory.HyperspaceDrive + "5");
    public static final Node HyperspaceDrive6             = new Node(NamingFactory.HyperspaceDrive + "6");
    public static final Node HyperspaceDrive7             = new Node(NamingFactory.HyperspaceDrive + "7");

    public static final Node HyperspaceTechnology1        = new Node(NamingFactory.HyperspaceTechnology + "1");
    public static final Node HyperspaceTechnology2        = new Node(NamingFactory.HyperspaceTechnology + "2");
    public static final Node HyperspaceTechnology3        = new Node(NamingFactory.HyperspaceTechnology + "3");
    public static final Node HyperspaceTechnology4        = new Node(NamingFactory.HyperspaceTechnology + "4");
    public static final Node HyperspaceTechnology5        = new Node(NamingFactory.HyperspaceTechnology + "5");
    public static final Node HyperspaceTechnology6        = new Node(NamingFactory.HyperspaceTechnology + "6");
    public static final Node HyperspaceTechnology7        = new Node(NamingFactory.HyperspaceTechnology + "7");
    public static final Node HyperspaceTechnology8        = new Node(NamingFactory.HyperspaceTechnology + "8");

    public static final Node Shipyard3                    = new Node(NamingFactory.Shipyard + "3");
    public static final Node Shipyard4                    = new Node(NamingFactory.Shipyard + "4");
    public static final Node Shipyard5                    = new Node(NamingFactory.Shipyard + "5");
    public static final Node Shipyard6                    = new Node(NamingFactory.Shipyard + "6");
    public static final Node Shipyard7                    = new Node(NamingFactory.Shipyard + "7");
    public static final Node Shipyard8                    = new Node(NamingFactory.Shipyard + "8");
    public static final Node Shipyard9                    = new Node(NamingFactory.Shipyard + "9");
    public static final Node Shipyard10                   = new Node(NamingFactory.Shipyard + "10");
    public static final Node Shipyard11                   = new Node(NamingFactory.Shipyard + "11");
    public static final Node Shipyard12                   = new Node(NamingFactory.Shipyard + "12");

    public static final Node IonTechnology1               = new Node(NamingFactory.IonTechnology + "1");
    public static final Node IonTechnology2               = new Node(NamingFactory.IonTechnology + "2");
    public static final Node IonTechnology3               = new Node(NamingFactory.IonTechnology + "3");
    public static final Node IonTechnology4               = new Node(NamingFactory.IonTechnology + "4");
    public static final Node IonTechnology5               = new Node(NamingFactory.IonTechnology + "5");

    public static final Node PlasmaTechnology1            = new Node(NamingFactory.PlasmaTechnology + "1");
    public static final Node PlasmaTechnology2            = new Node(NamingFactory.PlasmaTechnology + "2");
    public static final Node PlasmaTechnology3            = new Node(NamingFactory.PlasmaTechnology + "3");
    public static final Node PlasmaTechnology4            = new Node(NamingFactory.PlasmaTechnology + "4");
    public static final Node PlasmaTechnology5            = new Node(NamingFactory.PlasmaTechnology + "5");
    public static final Node PlasmaTechnology6            = new Node(NamingFactory.PlasmaTechnology + "6");
    public static final Node PlasmaTechnology7            = new Node(NamingFactory.PlasmaTechnology + "7");

    public static final Node BattleShip                   = new Node(NamingFactory.BattleShip);
    public static final Node Destroyer                    = new Node(NamingFactory.Destroyer);
    public static final Node LargeShieldDome              = new Node(NamingFactory.LargeShieldDome);
    public static final Node PlasmaTurret                 = new Node(NamingFactory.PlasmaTurret);
    public static final Node Bomber                       = new Node(NamingFactory.Bomber);
    public static final Node ImpulseDrive4                = new Node(NamingFactory.ImpulseDrive + "4");
    public static final Node ImpulseDrive5                = new Node(NamingFactory.ImpulseDrive + "5");

    public static final Node ImpulseDrive6                = new Node(NamingFactory.ImpulseDrive + "6");

    public static final Node IonCannon                    = new Node(NamingFactory.IonCannon);

    public static final Node Cruiser                      = new Node(NamingFactory.Cruiser);

    public static final Node WeaponsTechnology1           = new Node(NamingFactory.WeaponsTechnology + "1");
    public static final Node WeaponsTechnology2           = new Node(NamingFactory.WeaponsTechnology + "2");
    public static final Node WeaponsTechnology3           = new Node(NamingFactory.WeaponsTechnology + "3");

    public static final Node GaussCannon                  = new Node(NamingFactory.GaussCannon);
    public static final Node ArmourTechnology2            = new Node(NamingFactory.ArmourTechnology + "2");

    public static final Node HeavyFighter                 = new Node(NamingFactory.HeavyFighter);
    public static final Node InterplanetaryMissiles       = new Node(NamingFactory.InterplanetaryMissiles);

    public static final Node SmallShieldDome              = new Node(NamingFactory.SmallShieldDome);

    public static final Node MissileSilo1                 = new Node(NamingFactory.MissileSilo + "1");
    public static final Node MissileSilo2                 = new Node(NamingFactory.MissileSilo + "2");
    public static final Node MissileSilo3                 = new Node(NamingFactory.MissileSilo + "3");
    public static final Node MissileSilo4                 = new Node(NamingFactory.MissileSilo + "4");

    public static final Node Recycler                     = new Node(NamingFactory.Recycler);

    public static final Node ColonyShip                   = new Node(NamingFactory.ColonyShip);

    public static final Node LargeCargoShip               = new Node(NamingFactory.LargeCargoShip);

    public static final Node CombustionDrive2             = new Node(NamingFactory.CombustionDrive + "2");
    public static final Node CombustionDrive3             = new Node(NamingFactory.CombustionDrive + "3");
    public static final Node CombustionDrive4             = new Node(NamingFactory.CombustionDrive + "4");
    public static final Node CombustionDrive5             = new Node(NamingFactory.CombustionDrive + "5");
    public static final Node CombustionDrive6             = new Node(NamingFactory.CombustionDrive + "6");

    public static final Node SmallCargoShip               = new Node(NamingFactory.SmallCargoShip);

    public static final Node EspionageProbe               = new Node(NamingFactory.EspionageProbe);

    public static final Node HeavyLaser                   = new Node(NamingFactory.HeavyLaser);
    public static final Node SolarSatellite               = new Node(NamingFactory.SolarSatellite);
    public static final Node RocketLauncher               = new Node(NamingFactory.RocketLauncher);
    public static final Node AntiBallisticMissiles        = new Node(NamingFactory.AntiBallisticMissiles);
    public static final Node rootNode                     = new Node(NamingFactory.RootNode);
    public static final Node BattleCruiser                = new Node(NamingFactory.BattleCruiser);
}
