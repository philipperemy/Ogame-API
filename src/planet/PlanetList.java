package planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetList
{
    private static List<Planet> planetsList = new ArrayList<>();

    public static Planet        homeWorld   = new Planet();

    public static Planet        colony1     = new Planet();
    public static Planet        colony2     = new Planet();
    public static Planet        colony3     = new Planet();
    public static Planet        colony4     = new Planet();
    public static Planet        colony5     = new Planet();
    public static Planet        colony6     = new Planet();
    public static Planet        colony7     = new Planet();
    public static Planet        colony8     = new Planet();

    static
    {
        planetsList.add(homeWorld);
        
        planetsList.add(colony1);
        planetsList.add(colony2);
        planetsList.add(colony3);
        planetsList.add(colony4);
        planetsList.add(colony5);
        planetsList.add(colony6);
        planetsList.add(colony7);
        planetsList.add(colony8);
    }

    public static List<Planet> getPlanetsList()
    {
        return planetsList;
    }
    
    public static List<Planet> getExistingPlanets()
    {
        List<Planet> existingPlanets = new ArrayList<>();
        for(Planet planet : getPlanetsList())
        {
            if(planet.getPlanetId() != null)
            {
                existingPlanets.add(planet);
            }
        }
        return existingPlanets;
    }
    

    public static Planet getPlanetById(int id)
    {
        return planetsList.get(id);
    }
}
