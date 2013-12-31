package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RequirementFactory
{

    private static Tree tree = loadDependencyTree();
    
    public static synchronized List<Node> getOrderedRequiredItems(Node item)
    {
        List<Node> pendingQueue = new ArrayList<Node>();

        while (func(item, pendingQueue));
        pendingQueue.add(item);
        return pendingQueue;
    }
    
    private static boolean func(Node buildNode, List<Node> pendingQueue)
    {
        TreeTool treeTool = new TreeTool();
        Set<Node> requiredNodes = treeTool.getRequirementsBuild(tree, buildNode);

        for (Node requiredNode : requiredNodes)
        {
            treeTool = new TreeTool();
            Set<Node> requiredNodes2 = treeTool.getRequirementsBuild(tree, requiredNode);

            if (requiredNodes2.isEmpty())
            {
                pendingQueue.add(requiredNode);
                requiredNode.built = true;
            }
        }

        return !requiredNodes.isEmpty();
    }

    private static Tree loadDependencyTree()
    {
        Node ResearchLab1 = new Node("ResearchLab1");
        Node EnergyTechnology1 = new Node("EnergyTechnology1");
        Node ResearchLab2 = new Node("ResearchLab2");
        Node ComputerTechnology1 = new Node("ComputerTechnology1");

        ResearchLab1.addChild(EnergyTechnology1);
        ResearchLab1.addChild(ResearchLab2);
        ResearchLab1.addChild(ComputerTechnology1);

        Node ArmourTechnology1 = new Node("ArmourTechnology1");
        Node ImpulseDrive1 = new Node("ImpulseDrive1");
        Node ResearchLab3 = new Node("ResearchLab3");

        ResearchLab2.addChild(ArmourTechnology1);
        ResearchLab2.addChild(ImpulseDrive1);
        ResearchLab2.addChild(ResearchLab3);

        Node ComputerTechnology2 = new Node("ComputerTechnology2");
        ComputerTechnology1.addChild(ComputerTechnology2);

        Node ComputerTechnology3 = new Node("ComputerTechnology3");
        ComputerTechnology2.addChild(ComputerTechnology3);

        Node ComputerTechnology4 = new Node("ComputerTechnology4");
        ComputerTechnology3.addChild(ComputerTechnology4);

        Node ComputerTechnology5 = new Node("ComputerTechnology5");
        ComputerTechnology4.addChild(ComputerTechnology5);

        Node ComputerTechnology6 = new Node("ComputerTechnology6");
        ComputerTechnology5.addChild(ComputerTechnology6);

        Node ComputerTechnology7 = new Node("ComputerTechnology7");
        ComputerTechnology6.addChild(ComputerTechnology7);

        Node ComputerTechnology8 = new Node("ComputerTechnology8");
        ComputerTechnology7.addChild(ComputerTechnology8);

        Node ComputerTechnology9 = new Node("ComputerTechnology9");
        ComputerTechnology8.addChild(ComputerTechnology9);

        Node ComputerTechnology10 = new Node("ComputerTechnology10");
        ComputerTechnology9.addChild(ComputerTechnology10);

        Node RoboticsFactory1 = new Node("RoboticsFactory1");

        Node RoboticsFactory2 = new Node("RoboticsFactory2");
        RoboticsFactory1.addChild(RoboticsFactory2);

        Node RoboticsFactory3 = new Node("RoboticsFactory3");
        RoboticsFactory2.addChild(RoboticsFactory3);

        Node RoboticsFactory4 = new Node("RoboticsFactory4");
        RoboticsFactory3.addChild(RoboticsFactory4);

        Node RoboticsFactory5 = new Node("RoboticsFactory5");
        RoboticsFactory4.addChild(RoboticsFactory5);

        Node RoboticsFactory6 = new Node("RoboticsFactory6");
        RoboticsFactory5.addChild(RoboticsFactory6);

        Node RoboticsFactory7 = new Node("RoboticsFactory7");
        RoboticsFactory6.addChild(RoboticsFactory7);

        Node RoboticsFactory8 = new Node("RoboticsFactory8");
        RoboticsFactory7.addChild(RoboticsFactory8);

        Node RoboticsFactory9 = new Node("RoboticsFactory9");
        RoboticsFactory8.addChild(RoboticsFactory9);

        Node RoboticsFactory10 = new Node("RoboticsFactory10");
        RoboticsFactory9.addChild(RoboticsFactory10);

        Node Shipyard1 = new Node("Shipyard1");
        RoboticsFactory2.addChild(Shipyard1);

        Node CombustionDrive1 = new Node("CombustionDrive1");
        EnergyTechnology1.addChild(CombustionDrive1);

        Node EnergyTechnology2 = new Node("EnergyTechnology2");

        EnergyTechnology1.addChild(ImpulseDrive1);
        EnergyTechnology1.addChild(EnergyTechnology2);

        Node ResearchLab4 = new Node("ResearchLab4");
        ResearchLab3.addChild(ResearchLab4);

        Node ResearchLab5 = new Node("ResearchLab5");
        ResearchLab4.addChild(ResearchLab5);

        Node ResearchLab6 = new Node("ResearchLab6");
        ResearchLab5.addChild(ResearchLab6);

        Node ResearchLab7 = new Node("ResearchLab7");
        ResearchLab6.addChild(ResearchLab7);

        Node ResearchLab8 = new Node("ResearchLab8");
        ResearchLab7.addChild(ResearchLab8);

        Node ResearchLab9 = new Node("ResearchLab9");
        ResearchLab8.addChild(ResearchLab9);

        Node ResearchLab10 = new Node("ResearchLab10");
        ResearchLab9.addChild(ResearchLab10);

        Node ResearchLab11 = new Node("ResearchLab11");
        ResearchLab10.addChild(ResearchLab11);

        Node ResearchLab12 = new Node("ResearchLab12");
        ResearchLab11.addChild(ResearchLab12);

        Node GravitonTechnology = new Node("GravitonTechnology");
        ResearchLab12.addChild(GravitonTechnology);

        Node DeathStar = new Node("DeathStar");
        GravitonTechnology.addChild(DeathStar);

        Node IntergalacticResearchNetwork = new Node("IntergalacticResearchNetwork");
        ResearchLab10.addChild(IntergalacticResearchNetwork);

        Node NaniteFactory1 = new Node("NaniteFactory1");
        RoboticsFactory10.addChild(NaniteFactory1);
        ComputerTechnology10.addChild(NaniteFactory1);

        Node Terraformer = new Node("Terraformer");
        NaniteFactory1.addChild(Terraformer);

        ComputerTechnology8.addChild(IntergalacticResearchNetwork);

        Node LunarBase = new Node("LunarBase");
        Node baseLunaire = new Node("baseLunaire");
        LunarBase.addChild(baseLunaire);

        Node JumpGate = new Node("JumpGate");
        Node SensorPhalanx = new Node("SensorPhalanx");

        baseLunaire.addChild(JumpGate);
        baseLunaire.addChild(SensorPhalanx);

        Node LaserTechnology1 = new Node("LaserTechnology1");

        Node LaserTechnology2 = new Node("LaserTechnology2");
        LaserTechnology1.addChild(LaserTechnology2);

        Node LaserTechnology3 = new Node("LaserTechnology3");
        LaserTechnology2.addChild(LaserTechnology3);

        Node LaserTechnology4 = new Node("LaserTechnology4");
        LaserTechnology3.addChild(LaserTechnology4);

        Node LaserTechnology5 = new Node("LaserTechnology5");
        LaserTechnology4.addChild(LaserTechnology5);

        Node LaserTechnology6 = new Node("LaserTechnology6");
        LaserTechnology5.addChild(LaserTechnology6);

        Node LaserTechnology7 = new Node("LaserTechnology7");
        LaserTechnology6.addChild(LaserTechnology7);

        Node LaserTechnology8 = new Node("LaserTechnology8");
        LaserTechnology7.addChild(LaserTechnology8);

        Node LaserTechnology9 = new Node("LaserTechnology9");
        LaserTechnology8.addChild(LaserTechnology9);

        Node LaserTechnology10 = new Node("LaserTechnology10");
        LaserTechnology9.addChild(LaserTechnology10);

        Node LaserTechnology11 = new Node("LaserTechnology11");
        LaserTechnology10.addChild(LaserTechnology11);

        Node LaserTechnology12 = new Node("LaserTechnology12");
        LaserTechnology11.addChild(LaserTechnology12);

        EnergyTechnology2.addChild(LaserTechnology1);

        Node DeuteriumSynthesizer1 = new Node("DeuteriumSynthesizer1");

        Node DeuteriumSynthesizer2 = new Node("DeuteriumSynthesizer2");
        DeuteriumSynthesizer1.addChild(DeuteriumSynthesizer2);

        Node DeuteriumSynthesizer3 = new Node("DeuteriumSynthesizer3");
        DeuteriumSynthesizer2.addChild(DeuteriumSynthesizer3);

        Node DeuteriumSynthesizer4 = new Node("DeuteriumSynthesizer4");
        DeuteriumSynthesizer3.addChild(DeuteriumSynthesizer4);

        Node DeuteriumSynthesizer5 = new Node("DeuteriumSynthesizer5");
        DeuteriumSynthesizer4.addChild(DeuteriumSynthesizer5);

        Node fusionReactor = new Node("fusionReactor");
        DeuteriumSynthesizer5.addChild(fusionReactor);

        Node Shipyard2 = new Node("Shipyard2");
        Shipyard1.addChild(Shipyard2);

        Node LightLaser = new Node("LightLaser");
        LaserTechnology3.addChild(LightLaser);
        Shipyard2.addChild(LightLaser);

        Node LightFighter = new Node("LightFighter");

        CombustionDrive1.addChild(LightFighter);
        Shipyard1.addChild(LightFighter);

        Node EnergyTechnology3 = new Node("EnergyTechnology3");
        EnergyTechnology2.addChild(EnergyTechnology3);

        Node EnergyTechnology4 = new Node("EnergyTechnology4");
        EnergyTechnology3.addChild(EnergyTechnology4);

        Node EnergyTechnology5 = new Node("EnergyTechnology5");
        EnergyTechnology4.addChild(EnergyTechnology5);

        Node EnergyTechnology6 = new Node("EnergyTechnology6");
        EnergyTechnology5.addChild(EnergyTechnology6);

        Node EnergyTechnology7 = new Node("EnergyTechnology7");
        EnergyTechnology6.addChild(EnergyTechnology7);

        Node EnergyTechnology8 = new Node("EnergyTechnology8");
        EnergyTechnology7.addChild(EnergyTechnology8);

        Node EnergyTechnology9 = new Node("EnergyTechnology9");
        EnergyTechnology8.addChild(EnergyTechnology9);

        Node EnergyTechnology10 = new Node("EnergyTechnology10");
        EnergyTechnology9.addChild(EnergyTechnology10);

        Node EnergyTechnology11 = new Node("EnergyTechnology11");
        EnergyTechnology10.addChild(EnergyTechnology11);

        Node EnergyTechnology12 = new Node("EnergyTechnology12");
        EnergyTechnology11.addChild(EnergyTechnology12);

        EnergyTechnology12.addChild(Terraformer);

        Node ShieldingTechnology1 = new Node("ShieldingTechnology1");

        ResearchLab6.addChild(ShieldingTechnology1);
        EnergyTechnology3.addChild(ShieldingTechnology1);

        Node ShieldingTechnology2 = new Node("ShieldingTechnology2");
        ShieldingTechnology1.addChild(ShieldingTechnology2);

        Node ShieldingTechnology3 = new Node("ShieldingTechnology3");
        ShieldingTechnology2.addChild(ShieldingTechnology3);

        Node ShieldingTechnology4 = new Node("ShieldingTechnology4");
        ShieldingTechnology3.addChild(ShieldingTechnology4);

        Node ShieldingTechnology5 = new Node("ShieldingTechnology5");
        ShieldingTechnology4.addChild(ShieldingTechnology5);

        Node ShieldingTechnology6 = new Node("ShieldingTechnology6");
        ShieldingTechnology5.addChild(ShieldingTechnology6);

        Node ImpulseDrive2 = new Node("ImpulseDrive2");
        ImpulseDrive1.addChild(ImpulseDrive2);

        Node ImpulseDrive3 = new Node("ImpulseDrive3");
        ImpulseDrive2.addChild(ImpulseDrive3);

        Node EspionageTechnology1 = new Node("EspionageTechnology1");
        ResearchLab3.addChild(EspionageTechnology1);
        Node EspionageTechnology2 = new Node("EspionageTechnology2");
        EspionageTechnology1.addChild(EspionageTechnology2);
        Node EspionageTechnology3 = new Node("EspionageTechnology3");
        EspionageTechnology2.addChild(EspionageTechnology3);
        Node EspionageTechnology4 = new Node("EspionageTechnology4");
        EspionageTechnology3.addChild(EspionageTechnology4);

        Node technologieExpeditions = new Node("technologieExpeditions");
        ImpulseDrive3.addChild(technologieExpeditions);
        EspionageTechnology4.addChild(technologieExpeditions);

        Node HyperspaceDrive1 = new Node("HyperspaceDrive1");

        Node HyperspaceDrive2 = new Node("HyperspaceDrive2");
        HyperspaceDrive1.addChild(HyperspaceDrive2);

        Node HyperspaceDrive3 = new Node("HyperspaceDrive3");
        HyperspaceDrive2.addChild(HyperspaceDrive3);

        Node HyperspaceDrive4 = new Node("HyperspaceDrive4");
        HyperspaceDrive3.addChild(HyperspaceDrive4);

        Node HyperspaceDrive5 = new Node("HyperspaceDrive5");
        HyperspaceDrive4.addChild(HyperspaceDrive5);

        Node HyperspaceDrive6 = new Node("HyperspaceDrive6");
        HyperspaceDrive5.addChild(HyperspaceDrive6);

        Node HyperspaceDrive7 = new Node("HyperspaceDrive7");
        HyperspaceDrive6.addChild(HyperspaceDrive7);

        HyperspaceDrive7.addChild(DeathStar);

        Node HyperspaceTechnology1 = new Node("HyperspaceTechnology1");

        Node HyperspaceTechnology2 = new Node("HyperspaceTechnology2");
        HyperspaceTechnology1.addChild(HyperspaceTechnology2);

        Node HyperspaceTechnology3 = new Node("HyperspaceTechnology3");
        HyperspaceTechnology2.addChild(HyperspaceTechnology3);

        Node HyperspaceTechnology4 = new Node("HyperspaceTechnology4");
        HyperspaceTechnology3.addChild(HyperspaceTechnology4);

        Node HyperspaceTechnology5 = new Node("HyperspaceTechnology5");
        HyperspaceTechnology4.addChild(HyperspaceTechnology5);

        Node HyperspaceTechnology6 = new Node("HyperspaceTechnology6");
        HyperspaceTechnology5.addChild(HyperspaceTechnology6);

        Node HyperspaceTechnology7 = new Node("HyperspaceTechnology7");
        HyperspaceTechnology6.addChild(HyperspaceTechnology7);

        Node HyperspaceTechnology8 = new Node("HyperspaceTechnology8");
        HyperspaceTechnology7.addChild(HyperspaceTechnology8);

        HyperspaceTechnology3.addChild(HyperspaceDrive1);

        HyperspaceTechnology6.addChild(DeathStar);
        HyperspaceTechnology7.addChild(JumpGate);

        HyperspaceTechnology8.addChild(IntergalacticResearchNetwork);

        Node Shipyard3 = new Node("Shipyard3");
        Shipyard2.addChild(Shipyard3);

        Node Shipyard4 = new Node("Shipyard4");
        Shipyard3.addChild(Shipyard4);

        Node Shipyard5 = new Node("Shipyard5");
        Shipyard4.addChild(Shipyard5);

        Node Shipyard6 = new Node("Shipyard6");
        Shipyard5.addChild(Shipyard6);

        Node Shipyard7 = new Node("Shipyard7");
        Shipyard6.addChild(Shipyard7);

        Node Shipyard8 = new Node("Shipyard8");
        Shipyard7.addChild(Shipyard8);

        Node Shipyard9 = new Node("Shipyard9");
        Shipyard8.addChild(Shipyard9);

        Node Shipyard10 = new Node("Shipyard10");
        Shipyard9.addChild(Shipyard10);

        Node Shipyard11 = new Node("Shipyard11");
        Shipyard10.addChild(Shipyard11);

        Node Shipyard12 = new Node("Shipyard12");
        Shipyard11.addChild(Shipyard12);

        Shipyard12.addChild(DeathStar);

        Node IonTechnology1 = new Node("IonTechnology1");

        Node IonTechnology2 = new Node("IonTechnology2");
        IonTechnology1.addChild(IonTechnology2);

        Node IonTechnology3 = new Node("IonTechnology3");
        IonTechnology2.addChild(IonTechnology3);

        Node IonTechnology4 = new Node("IonTechnology4");
        IonTechnology3.addChild(IonTechnology4);

        Node IonTechnology5 = new Node("IonTechnology5");
        IonTechnology4.addChild(IonTechnology5);

        Node PlasmaTechnology1 = new Node("PlasmaTechnology1");
        IonTechnology5.addChild(PlasmaTechnology1);

        Node PlasmaTechnology2 = new Node("PlasmaTechnology2");
        PlasmaTechnology1.addChild(PlasmaTechnology2);

        Node PlasmaTechnology3 = new Node("PlasmaTechnology3");
        PlasmaTechnology2.addChild(PlasmaTechnology3);

        Node PlasmaTechnology4 = new Node("PlasmaTechnology4");
        PlasmaTechnology3.addChild(PlasmaTechnology4);

        Node PlasmaTechnology5 = new Node("PlasmaTechnology5");
        PlasmaTechnology4.addChild(PlasmaTechnology5);

        Node PlasmaTechnology6 = new Node("PlasmaTechnology6");
        PlasmaTechnology5.addChild(PlasmaTechnology6);

        Node PlasmaTechnology7 = new Node("PlasmaTechnology7");
        PlasmaTechnology6.addChild(PlasmaTechnology7);

        LaserTechnology10.addChild(PlasmaTechnology1);

        EnergyTechnology8.addChild(PlasmaTechnology1);

        Node traquer = new Node("traquer");

        LaserTechnology12.addChild(traquer);
        Shipyard8.addChild(traquer);
        HyperspaceTechnology5.addChild(traquer);
        HyperspaceDrive5.addChild(traquer);

        Node BattleShip = new Node("BattleShip");
        Shipyard7.addChild(BattleShip);
        HyperspaceDrive4.addChild(BattleShip);

        Node Destroyer = new Node("Destroyer");
        Shipyard9.addChild(Destroyer);
        HyperspaceTechnology5.addChild(Destroyer);
        HyperspaceDrive6.addChild(Destroyer);

        Node LargeShieldDome = new Node("LargeShieldDome");
        ShieldingTechnology6.addChild(LargeShieldDome);
        Shipyard6.addChild(LargeShieldDome);

        Node PlasmaTurret = new Node("PlasmaTurret");
        PlasmaTechnology7.addChild(PlasmaTurret);
        Shipyard8.addChild(PlasmaTurret);

        Node Bomber = new Node("Bomber");
        PlasmaTechnology5.addChild(Bomber);
        Shipyard8.addChild(Bomber);

        Node ImpulseDrive4 = new Node("ImpulseDrive4");
        ImpulseDrive3.addChild(ImpulseDrive4);

        Node ImpulseDrive5 = new Node("ImpulseDrive5");
        ImpulseDrive4.addChild(ImpulseDrive5);

        Node ImpulseDrive6 = new Node("ImpulseDrive6");
        ImpulseDrive5.addChild(ImpulseDrive6);

        ImpulseDrive6.addChild(Bomber);

        Node IonCannon = new Node("IonCannon");
        IonTechnology4.addChild(IonCannon);
        Shipyard4.addChild(IonCannon);

        Node Cruiser = new Node("Cruiser");
        IonTechnology2.addChild(Cruiser);
        ImpulseDrive4.addChild(Cruiser);
        Shipyard5.addChild(Cruiser);

        ShieldingTechnology5.addChild(HyperspaceTechnology1);
        ResearchLab7.addChild(HyperspaceTechnology1);

        Node WeaponsTechnology1 = new Node("WeaponsTechnology1");

        Node WeaponsTechnology2 = new Node("WeaponsTechnology2");
        WeaponsTechnology1.addChild(WeaponsTechnology2);

        Node WeaponsTechnology3 = new Node("WeaponsTechnology3");
        WeaponsTechnology2.addChild(WeaponsTechnology3);

        ResearchLab4.addChild(WeaponsTechnology1);

        Node GaussCannon = new Node("GaussCannon");
        WeaponsTechnology3.addChild(GaussCannon);
        ShieldingTechnology1.addChild(GaussCannon);

        EnergyTechnology5.addChild(HyperspaceTechnology1);

        Node ArmourTechnology2 = new Node("ArmourTechnology2");
        ArmourTechnology1.addChild(ArmourTechnology2);

        Node HeavyFighter = new Node("HeavyFighter");
        ArmourTechnology2.addChild(HeavyFighter);
        ImpulseDrive2.addChild(HeavyFighter);
        Shipyard3.addChild(HeavyFighter);

        Node InterplanetaryMissiles = new Node("InterplanetaryMissiles");
        ImpulseDrive1.addChild(InterplanetaryMissiles);

        Node SmallShieldDome = new Node("SmallShieldDome");
        Shipyard1.addChild(SmallShieldDome);
        ShieldingTechnology2.addChild(SmallShieldDome);

        Node MissileSilo1 = new Node("MissileSilo1");

        Node MissileSilo2 = new Node("MissileSilo2");
        MissileSilo1.addChild(MissileSilo2);

        Node MissileSilo3 = new Node("MissileSilo3");
        MissileSilo2.addChild(MissileSilo3);

        Node MissileSilo4 = new Node("MissileSilo4");
        MissileSilo3.addChild(MissileSilo4);

        MissileSilo4.addChild(InterplanetaryMissiles);
        Shipyard1.addChild(MissileSilo1);

        Node Recycler = new Node("Recycler");
        ShieldingTechnology2.addChild(Recycler);

        Node ColonyShip = new Node("ColonyShip");
        ImpulseDrive3.addChild(ColonyShip);
        Shipyard4.addChild(ColonyShip);

        Node LargeCargoShip = new Node("LargeCargoShip");
        Shipyard4.addChild(LargeCargoShip);
        Shipyard4.addChild(Recycler);

        Node CombustionDrive2 = new Node("CombustionDrive2");
        CombustionDrive1.addChild(CombustionDrive2);

        Node CombustionDrive3 = new Node("CombustionDrive3");
        CombustionDrive2.addChild(CombustionDrive3);

        Node CombustionDrive4 = new Node("CombustionDrive4");
        CombustionDrive3.addChild(CombustionDrive4);

        Node CombustionDrive5 = new Node("CombustionDrive5");
        CombustionDrive4.addChild(CombustionDrive5);

        Node CombustionDrive6 = new Node("CombustionDrive6");
        CombustionDrive5.addChild(CombustionDrive6);

        CombustionDrive6.addChild(Recycler);
        CombustionDrive6.addChild(LargeCargoShip);

        Node SmallCargoShip = new Node("SmallCargoShip");
        Shipyard2.addChild(SmallCargoShip);
        CombustionDrive2.addChild(SmallCargoShip);

        Node EspionageProbe = new Node("EspionageProbe");
        CombustionDrive3.addChild(EspionageProbe);
        Shipyard3.addChild(EspionageProbe);
        EspionageTechnology2.addChild(EspionageProbe);

        LaserTechnology5.addChild(IonTechnology1);
        ResearchLab4.addChild(IonTechnology1);
        EnergyTechnology4.addChild(IonTechnology1);

        EnergyTechnology6.addChild(GaussCannon);
        Shipyard6.addChild(GaussCannon);

        EnergyTechnology3.addChild(fusionReactor);

        Node HeavyLaser = new Node("HeavyLaser");
        EnergyTechnology3.addChild(HeavyLaser);
        LaserTechnology6.addChild(HeavyLaser);
        Shipyard4.addChild(HeavyLaser);

        Node SolarSatellite = new Node("SolarSatellite");
        Node rocketLauncher = new Node("rocketLauncher");
        Shipyard1.addChild(SolarSatellite);
        Shipyard1.addChild(rocketLauncher);

        Node AntiBallisticMissiles = new Node("AntiBallisticMissiles");

        MissileSilo2.addChild(AntiBallisticMissiles);

        Node rootNode = new Node("RootNode");
        rootNode.addChild(ResearchLab1);
        rootNode.addChild(DeuteriumSynthesizer1);
        rootNode.addChild(RoboticsFactory1);
        rootNode.addChild(LunarBase);
        
        Tree tree = new Tree();
        tree.root = rootNode;
        return tree;
    }

    
    
}
