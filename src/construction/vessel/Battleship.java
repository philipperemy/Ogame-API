package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Battleship extends Construction
{

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.BATTLESHIP_REF;
    }

    @Override
    protected String getDescription()
    {
        return "Battleships form the backbone of a fleet. Their heavy cannons, high speed, and large cargo holds make them opponents to be taken seriously.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.BattleShip);
    }

    @Override
    public String getName()
    {
        return NamingFactory.BattleShip;
    }

}
