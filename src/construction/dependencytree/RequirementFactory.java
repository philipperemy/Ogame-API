package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RequirementFactory
{
    private static Tree tree = loadDependencyTree();

    public static synchronized List<Node> getOrderedRequiredItems(Set<Node> builtNodes, Node item)
    {
        if(builtNodes.contains(item))
        {
           return new ArrayList<>();
        }
        
        updateNodes(tree.root, builtNodes);
        return getOrderedRequiredItems(item);
    }
    
    public static synchronized List<Node> getOrderedRequiredItems(Node item)
    {
        List<Node> pendingQueue = new ArrayList<Node>();

        while (compute(item, pendingQueue));

        pendingQueue.add(item);
        reset();

        return pendingQueue;
    }

    //XXX: bug in the method
    private static void updateNodes(Node current, Set<Node> builtNodes)
    {
        /*for(Node builtNode : builtNodes)
        {
            if(builtNode.getData().equals(current.getData()))
            {
                builtNode.built = true;
                break;
            }
        }*/
        
        current.mark = true;
        for(Node child : current.childs)
        {
            if(!child.mark)
            {
                updateNodes(current, builtNodes);
            }
        }
    }
    
    private static void reset()
    {
        for (Node node : NodeDictionary.getAll())
        {
            node.built = false;
        }
    }

    private static boolean compute(Node buildNode, List<Node> pendingQueue)
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
        NodeDictionary.ResearchLab1.addChild(NodeDictionary.EnergyTechnology1);
        NodeDictionary.ResearchLab1.addChild(NodeDictionary.ResearchLab2);
        NodeDictionary.ResearchLab1.addChild(NodeDictionary.ComputerTechnology1);

        NodeDictionary.ResearchLab2.addChild(NodeDictionary.ArmourTechnology1);
        NodeDictionary.ResearchLab2.addChild(NodeDictionary.ImpulseDrive1);
        NodeDictionary.ResearchLab2.addChild(NodeDictionary.ResearchLab3);

        NodeDictionary.ComputerTechnology1.addChild(NodeDictionary.ComputerTechnology2);

        NodeDictionary.ComputerTechnology2.addChild(NodeDictionary.ComputerTechnology3);

        NodeDictionary.ComputerTechnology3.addChild(NodeDictionary.ComputerTechnology4);

        NodeDictionary.ComputerTechnology4.addChild(NodeDictionary.ComputerTechnology5);

        NodeDictionary.ComputerTechnology5.addChild(NodeDictionary.ComputerTechnology6);

        NodeDictionary.ComputerTechnology6.addChild(NodeDictionary.ComputerTechnology7);

        NodeDictionary.ComputerTechnology7.addChild(NodeDictionary.ComputerTechnology8);

        NodeDictionary.ComputerTechnology8.addChild(NodeDictionary.ComputerTechnology9);

        NodeDictionary.ComputerTechnology9.addChild(NodeDictionary.ComputerTechnology10);

        NodeDictionary.RoboticsFactory1.addChild(NodeDictionary.RoboticsFactory2);

        NodeDictionary.RoboticsFactory2.addChild(NodeDictionary.RoboticsFactory3);

        NodeDictionary.RoboticsFactory3.addChild(NodeDictionary.RoboticsFactory4);

        NodeDictionary.RoboticsFactory4.addChild(NodeDictionary.RoboticsFactory5);

        NodeDictionary.RoboticsFactory5.addChild(NodeDictionary.RoboticsFactory6);

        NodeDictionary.RoboticsFactory6.addChild(NodeDictionary.RoboticsFactory7);

        NodeDictionary.RoboticsFactory7.addChild(NodeDictionary.RoboticsFactory8);

        NodeDictionary.RoboticsFactory8.addChild(NodeDictionary.RoboticsFactory9);

        NodeDictionary.RoboticsFactory9.addChild(NodeDictionary.RoboticsFactory10);

        NodeDictionary.RoboticsFactory2.addChild(NodeDictionary.Shipyard1);

        NodeDictionary.EnergyTechnology1.addChild(NodeDictionary.CombustionDrive1);

        NodeDictionary.EnergyTechnology1.addChild(NodeDictionary.ImpulseDrive1);
        NodeDictionary.EnergyTechnology1.addChild(NodeDictionary.EnergyTechnology2);

        NodeDictionary.ResearchLab3.addChild(NodeDictionary.ResearchLab4);

        NodeDictionary.ResearchLab4.addChild(NodeDictionary.ResearchLab5);

        NodeDictionary.ResearchLab5.addChild(NodeDictionary.ResearchLab6);

        NodeDictionary.ResearchLab6.addChild(NodeDictionary.ResearchLab7);

        NodeDictionary.ResearchLab7.addChild(NodeDictionary.ResearchLab8);

        NodeDictionary.ResearchLab8.addChild(NodeDictionary.ResearchLab9);

        NodeDictionary.ResearchLab9.addChild(NodeDictionary.ResearchLab10);

        NodeDictionary.ResearchLab10.addChild(NodeDictionary.ResearchLab11);

        NodeDictionary.ResearchLab11.addChild(NodeDictionary.ResearchLab12);

        NodeDictionary.ResearchLab12.addChild(NodeDictionary.GravitonTechnology);

        NodeDictionary.GravitonTechnology.addChild(NodeDictionary.DeathStar);

        NodeDictionary.ResearchLab10.addChild(NodeDictionary.IntergalacticResearchNetwork);

        NodeDictionary.RoboticsFactory10.addChild(NodeDictionary.NaniteFactory1);
        NodeDictionary.ComputerTechnology10.addChild(NodeDictionary.NaniteFactory1);

        NodeDictionary.NaniteFactory1.addChild(NodeDictionary.Terraformer);

        NodeDictionary.ComputerTechnology8.addChild(NodeDictionary.IntergalacticResearchNetwork);

        NodeDictionary.LunarBase.addChild(NodeDictionary.JumpGate);
        NodeDictionary.LunarBase.addChild(NodeDictionary.SensorPhalanx);

        NodeDictionary.LaserTechnology1.addChild(NodeDictionary.LaserTechnology2);

        NodeDictionary.LaserTechnology2.addChild(NodeDictionary.LaserTechnology3);

        NodeDictionary.LaserTechnology3.addChild(NodeDictionary.LaserTechnology4);

        NodeDictionary.LaserTechnology4.addChild(NodeDictionary.LaserTechnology5);

        NodeDictionary.LaserTechnology5.addChild(NodeDictionary.LaserTechnology6);

        NodeDictionary.LaserTechnology6.addChild(NodeDictionary.LaserTechnology7);

        NodeDictionary.LaserTechnology7.addChild(NodeDictionary.LaserTechnology8);

        NodeDictionary.LaserTechnology8.addChild(NodeDictionary.LaserTechnology9);

        NodeDictionary.LaserTechnology9.addChild(NodeDictionary.LaserTechnology10);

        NodeDictionary.LaserTechnology10.addChild(NodeDictionary.LaserTechnology11);

        NodeDictionary.LaserTechnology11.addChild(NodeDictionary.LaserTechnology12);

        NodeDictionary.EnergyTechnology2.addChild(NodeDictionary.LaserTechnology1);

        NodeDictionary.DeuteriumSynthesizer1.addChild(NodeDictionary.DeuteriumSynthesizer2);
        NodeDictionary.DeuteriumSynthesizer2.addChild(NodeDictionary.DeuteriumSynthesizer3);
        NodeDictionary.DeuteriumSynthesizer3.addChild(NodeDictionary.DeuteriumSynthesizer4);
        NodeDictionary.DeuteriumSynthesizer4.addChild(NodeDictionary.DeuteriumSynthesizer5);

        NodeDictionary.DeuteriumSynthesizer5.addChild(NodeDictionary.FusionReactor);

        NodeDictionary.Shipyard1.addChild(NodeDictionary.Shipyard2);

        NodeDictionary.LaserTechnology3.addChild(NodeDictionary.LightLaser);
        NodeDictionary.Shipyard2.addChild(NodeDictionary.LightLaser);

        NodeDictionary.CombustionDrive1.addChild(NodeDictionary.LightFighter);
        NodeDictionary.Shipyard1.addChild(NodeDictionary.LightFighter);

        NodeDictionary.EnergyTechnology2.addChild(NodeDictionary.EnergyTechnology3);
        NodeDictionary.EnergyTechnology3.addChild(NodeDictionary.EnergyTechnology4);
        NodeDictionary.EnergyTechnology4.addChild(NodeDictionary.EnergyTechnology5);
        NodeDictionary.EnergyTechnology5.addChild(NodeDictionary.EnergyTechnology6);
        NodeDictionary.EnergyTechnology6.addChild(NodeDictionary.EnergyTechnology7);
        NodeDictionary.EnergyTechnology7.addChild(NodeDictionary.EnergyTechnology8);
        NodeDictionary.EnergyTechnology8.addChild(NodeDictionary.EnergyTechnology9);
        NodeDictionary.EnergyTechnology9.addChild(NodeDictionary.EnergyTechnology10);
        NodeDictionary.EnergyTechnology10.addChild(NodeDictionary.EnergyTechnology11);
        NodeDictionary.EnergyTechnology11.addChild(NodeDictionary.EnergyTechnology12);

        NodeDictionary.EnergyTechnology12.addChild(NodeDictionary.Terraformer);

        NodeDictionary.ResearchLab6.addChild(NodeDictionary.ShieldingTechnology1);
        NodeDictionary.EnergyTechnology3.addChild(NodeDictionary.ShieldingTechnology1);

        NodeDictionary.ShieldingTechnology1.addChild(NodeDictionary.ShieldingTechnology2);

        NodeDictionary.ShieldingTechnology2.addChild(NodeDictionary.ShieldingTechnology3);

        NodeDictionary.ShieldingTechnology3.addChild(NodeDictionary.ShieldingTechnology4);

        NodeDictionary.ShieldingTechnology4.addChild(NodeDictionary.ShieldingTechnology5);

        NodeDictionary.ShieldingTechnology5.addChild(NodeDictionary.ShieldingTechnology6);

        NodeDictionary.ImpulseDrive1.addChild(NodeDictionary.ImpulseDrive2);

        NodeDictionary.ImpulseDrive2.addChild(NodeDictionary.ImpulseDrive3);

        NodeDictionary.ResearchLab3.addChild(NodeDictionary.EspionageTechnology1);
        NodeDictionary.EspionageTechnology1.addChild(NodeDictionary.EspionageTechnology2);
        NodeDictionary.EspionageTechnology2.addChild(NodeDictionary.EspionageTechnology3);
        NodeDictionary.EspionageTechnology3.addChild(NodeDictionary.EspionageTechnology4);

        /*
         * NodeDictionary.ImpulseDrive3.addChild(NodeDictionary.technologieExpeditions);
         * NodeDictionary.EspionageTechnology4.addChild(NodeDictionary.technologieExpeditions);
         */

        NodeDictionary.HyperspaceDrive1.addChild(NodeDictionary.HyperspaceDrive2);

        NodeDictionary.HyperspaceDrive2.addChild(NodeDictionary.HyperspaceDrive3);

        NodeDictionary.HyperspaceDrive3.addChild(NodeDictionary.HyperspaceDrive4);

        NodeDictionary.HyperspaceDrive4.addChild(NodeDictionary.HyperspaceDrive5);

        NodeDictionary.HyperspaceDrive5.addChild(NodeDictionary.HyperspaceDrive6);

        NodeDictionary.HyperspaceDrive6.addChild(NodeDictionary.HyperspaceDrive7);

        NodeDictionary.HyperspaceDrive7.addChild(NodeDictionary.DeathStar);

        NodeDictionary.HyperspaceTechnology1.addChild(NodeDictionary.HyperspaceTechnology2);

        NodeDictionary.HyperspaceTechnology2.addChild(NodeDictionary.HyperspaceTechnology3);

        NodeDictionary.HyperspaceTechnology3.addChild(NodeDictionary.HyperspaceTechnology4);

        NodeDictionary.HyperspaceTechnology4.addChild(NodeDictionary.HyperspaceTechnology5);

        NodeDictionary.HyperspaceTechnology5.addChild(NodeDictionary.HyperspaceTechnology6);

        NodeDictionary.HyperspaceTechnology6.addChild(NodeDictionary.HyperspaceTechnology7);

        NodeDictionary.HyperspaceTechnology7.addChild(NodeDictionary.HyperspaceTechnology8);

        NodeDictionary.HyperspaceTechnology3.addChild(NodeDictionary.HyperspaceDrive1);

        NodeDictionary.HyperspaceTechnology6.addChild(NodeDictionary.DeathStar);
        NodeDictionary.HyperspaceTechnology7.addChild(NodeDictionary.JumpGate);

        NodeDictionary.HyperspaceTechnology8.addChild(NodeDictionary.IntergalacticResearchNetwork);

        NodeDictionary.Shipyard2.addChild(NodeDictionary.Shipyard3);

        NodeDictionary.Shipyard3.addChild(NodeDictionary.Shipyard4);

        NodeDictionary.Shipyard4.addChild(NodeDictionary.Shipyard5);

        NodeDictionary.Shipyard5.addChild(NodeDictionary.Shipyard6);

        NodeDictionary.Shipyard6.addChild(NodeDictionary.Shipyard7);

        NodeDictionary.Shipyard7.addChild(NodeDictionary.Shipyard8);

        NodeDictionary.Shipyard8.addChild(NodeDictionary.Shipyard9);

        NodeDictionary.Shipyard9.addChild(NodeDictionary.Shipyard10);

        NodeDictionary.Shipyard10.addChild(NodeDictionary.Shipyard11);

        NodeDictionary.Shipyard11.addChild(NodeDictionary.Shipyard12);

        NodeDictionary.Shipyard12.addChild(NodeDictionary.DeathStar);

        NodeDictionary.IonTechnology1.addChild(NodeDictionary.IonTechnology2);

        NodeDictionary.IonTechnology2.addChild(NodeDictionary.IonTechnology3);

        NodeDictionary.IonTechnology3.addChild(NodeDictionary.IonTechnology4);

        NodeDictionary.IonTechnology4.addChild(NodeDictionary.IonTechnology5);

        NodeDictionary.IonTechnology5.addChild(NodeDictionary.PlasmaTechnology1);

        NodeDictionary.PlasmaTechnology1.addChild(NodeDictionary.PlasmaTechnology2);

        NodeDictionary.PlasmaTechnology2.addChild(NodeDictionary.PlasmaTechnology3);

        NodeDictionary.PlasmaTechnology3.addChild(NodeDictionary.PlasmaTechnology4);

        NodeDictionary.PlasmaTechnology4.addChild(NodeDictionary.PlasmaTechnology5);

        NodeDictionary.PlasmaTechnology5.addChild(NodeDictionary.PlasmaTechnology6);

        NodeDictionary.PlasmaTechnology6.addChild(NodeDictionary.PlasmaTechnology7);

        NodeDictionary.LaserTechnology10.addChild(NodeDictionary.PlasmaTechnology1);

        NodeDictionary.EnergyTechnology8.addChild(NodeDictionary.PlasmaTechnology1);

        NodeDictionary.LaserTechnology12.addChild(NodeDictionary.BattleCruiser);
        NodeDictionary.Shipyard8.addChild(NodeDictionary.BattleCruiser);
        NodeDictionary.HyperspaceTechnology5.addChild(NodeDictionary.BattleCruiser);
        NodeDictionary.HyperspaceDrive5.addChild(NodeDictionary.BattleCruiser);

        NodeDictionary.Shipyard7.addChild(NodeDictionary.BattleShip);
        NodeDictionary.HyperspaceDrive4.addChild(NodeDictionary.BattleShip);

        NodeDictionary.Shipyard9.addChild(NodeDictionary.Destroyer);
        NodeDictionary.HyperspaceTechnology5.addChild(NodeDictionary.Destroyer);
        NodeDictionary.HyperspaceDrive6.addChild(NodeDictionary.Destroyer);

        NodeDictionary.ShieldingTechnology6.addChild(NodeDictionary.LargeShieldDome);
        NodeDictionary.Shipyard6.addChild(NodeDictionary.LargeShieldDome);

        NodeDictionary.PlasmaTechnology7.addChild(NodeDictionary.PlasmaTurret);
        NodeDictionary.Shipyard8.addChild(NodeDictionary.PlasmaTurret);

        NodeDictionary.PlasmaTechnology5.addChild(NodeDictionary.Bomber);
        NodeDictionary.Shipyard8.addChild(NodeDictionary.Bomber);

        NodeDictionary.ImpulseDrive3.addChild(NodeDictionary.ImpulseDrive4);

        NodeDictionary.ImpulseDrive4.addChild(NodeDictionary.ImpulseDrive5);

        NodeDictionary.ImpulseDrive5.addChild(NodeDictionary.ImpulseDrive6);

        NodeDictionary.ImpulseDrive6.addChild(NodeDictionary.Bomber);

        NodeDictionary.IonTechnology4.addChild(NodeDictionary.IonCannon);
        NodeDictionary.Shipyard4.addChild(NodeDictionary.IonCannon);

        NodeDictionary.IonTechnology2.addChild(NodeDictionary.Cruiser);
        NodeDictionary.ImpulseDrive4.addChild(NodeDictionary.Cruiser);
        NodeDictionary.Shipyard5.addChild(NodeDictionary.Cruiser);

        NodeDictionary.ShieldingTechnology5.addChild(NodeDictionary.HyperspaceTechnology1);
        NodeDictionary.ResearchLab7.addChild(NodeDictionary.HyperspaceTechnology1);

        NodeDictionary.WeaponsTechnology1.addChild(NodeDictionary.WeaponsTechnology2);

        NodeDictionary.WeaponsTechnology2.addChild(NodeDictionary.WeaponsTechnology3);

        NodeDictionary.ResearchLab4.addChild(NodeDictionary.WeaponsTechnology1);

        NodeDictionary.WeaponsTechnology3.addChild(NodeDictionary.GaussCannon);
        NodeDictionary.ShieldingTechnology1.addChild(NodeDictionary.GaussCannon);

        NodeDictionary.EnergyTechnology5.addChild(NodeDictionary.HyperspaceTechnology1);

        NodeDictionary.ArmourTechnology1.addChild(NodeDictionary.ArmourTechnology2);

        NodeDictionary.ArmourTechnology2.addChild(NodeDictionary.HeavyFighter);
        NodeDictionary.ImpulseDrive2.addChild(NodeDictionary.HeavyFighter);
        NodeDictionary.Shipyard3.addChild(NodeDictionary.HeavyFighter);

        NodeDictionary.ImpulseDrive1.addChild(NodeDictionary.InterplanetaryMissiles);

        NodeDictionary.Shipyard1.addChild(NodeDictionary.SmallShieldDome);
        NodeDictionary.ShieldingTechnology2.addChild(NodeDictionary.SmallShieldDome);

        NodeDictionary.MissileSilo1.addChild(NodeDictionary.MissileSilo2);

        NodeDictionary.MissileSilo2.addChild(NodeDictionary.MissileSilo3);

        NodeDictionary.MissileSilo3.addChild(NodeDictionary.MissileSilo4);

        NodeDictionary.MissileSilo4.addChild(NodeDictionary.InterplanetaryMissiles);
        NodeDictionary.Shipyard1.addChild(NodeDictionary.MissileSilo1);

        NodeDictionary.ShieldingTechnology2.addChild(NodeDictionary.Recycler);

        NodeDictionary.ImpulseDrive3.addChild(NodeDictionary.ColonyShip);
        NodeDictionary.Shipyard4.addChild(NodeDictionary.ColonyShip);

        NodeDictionary.Shipyard4.addChild(NodeDictionary.LargeCargoShip);
        NodeDictionary.Shipyard4.addChild(NodeDictionary.Recycler);

        NodeDictionary.CombustionDrive1.addChild(NodeDictionary.CombustionDrive2);

        NodeDictionary.CombustionDrive2.addChild(NodeDictionary.CombustionDrive3);

        NodeDictionary.CombustionDrive3.addChild(NodeDictionary.CombustionDrive4);

        NodeDictionary.CombustionDrive4.addChild(NodeDictionary.CombustionDrive5);

        NodeDictionary.CombustionDrive5.addChild(NodeDictionary.CombustionDrive6);

        NodeDictionary.CombustionDrive6.addChild(NodeDictionary.Recycler);
        NodeDictionary.CombustionDrive6.addChild(NodeDictionary.LargeCargoShip);

        NodeDictionary.Shipyard2.addChild(NodeDictionary.SmallCargoShip);
        NodeDictionary.CombustionDrive2.addChild(NodeDictionary.SmallCargoShip);

        NodeDictionary.CombustionDrive3.addChild(NodeDictionary.EspionageProbe);
        NodeDictionary.Shipyard3.addChild(NodeDictionary.EspionageProbe);
        NodeDictionary.EspionageTechnology2.addChild(NodeDictionary.EspionageProbe);

        NodeDictionary.LaserTechnology5.addChild(NodeDictionary.IonTechnology1);
        NodeDictionary.ResearchLab4.addChild(NodeDictionary.IonTechnology1);
        NodeDictionary.EnergyTechnology4.addChild(NodeDictionary.IonTechnology1);

        NodeDictionary.EnergyTechnology6.addChild(NodeDictionary.GaussCannon);
        NodeDictionary.Shipyard6.addChild(NodeDictionary.GaussCannon);

        NodeDictionary.EnergyTechnology3.addChild(NodeDictionary.FusionReactor);

        NodeDictionary.EnergyTechnology3.addChild(NodeDictionary.HeavyLaser);
        NodeDictionary.LaserTechnology6.addChild(NodeDictionary.HeavyLaser);
        NodeDictionary.Shipyard4.addChild(NodeDictionary.HeavyLaser);

        NodeDictionary.Shipyard1.addChild(NodeDictionary.SolarSatellite);
        NodeDictionary.Shipyard1.addChild(NodeDictionary.RocketLauncher);

        NodeDictionary.MissileSilo2.addChild(NodeDictionary.AntiBallisticMissiles);

        NodeDictionary.rootNode.addChild(NodeDictionary.ResearchLab1);
        NodeDictionary.rootNode.addChild(NodeDictionary.DeuteriumSynthesizer1);
        NodeDictionary.rootNode.addChild(NodeDictionary.RoboticsFactory1);
        NodeDictionary.rootNode.addChild(NodeDictionary.LunarBase);

        Tree tree = new Tree();
        tree.root = NodeDictionary.rootNode;
        return tree;
    }

}
