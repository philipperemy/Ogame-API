package construction.resourcebuilding.mine;

import java.math.BigInteger;
import logger.Logger;
import construction.Construction;

public abstract class Mine extends Construction
{

    private BigInteger energyNeeded;

    public BigInteger getEnergyNeeded()
    {
        return energyNeeded;
    }

    public void setEnergyNeeded(BigInteger energyNeeded)
    {
        this.energyNeeded = energyNeeded;
    }

    /**
     * Tables storing useful info.
     */
    private static final int METAL_COST_COLUMN_ID   = 0;
    private static final int CRYSTAL_COST_COLUMN_ID = 1;
    private static final int DEUTERIUM_COLUMN_ID    = 2;
    private static final int ENERGY_USE             = 3;
    private static final int PRODUCTION_VALUE       = 4;

    private static final int MAX_LEVEL              = 41;
    private static final int ACCELERATOR_FACTOR     = 1;

    public static class CrystalMineConstants
    {
        private static final long BASE_COST_METAL   = 48;
        private static final long BASE_COST_CRYSTAL = 24;

        public static long[][]    values            = new long[MAX_LEVEL][5];

        static
        {
            Logger.traceINFO(CrystalMineConstants.class.getSimpleName());
            Logger.traceINFO("Metal Cost", "Crystal Cost", "Deuterium Cost", "Energy Used", "Production Value per Hour");
            for (int i = 1; i < MAX_LEVEL; i++)
            {
                values[i][METAL_COST_COLUMN_ID] = getMetalCost(i);
                values[i][CRYSTAL_COST_COLUMN_ID] = getCrystalCost(i);
                values[i][DEUTERIUM_COLUMN_ID] = 0;
                values[i][ENERGY_USE] = getEnergyNeeded(i);
                values[i][PRODUCTION_VALUE] = getProduction(i);
                Logger.traceINFO(i, values[i]);
            }
        }

        private static long getMetalCost(int level)
        {
            return (long) (BASE_COST_METAL * Math.pow(1.6, level - 1));
        }

        private static long getCrystalCost(int level)
        {
            return (long) (BASE_COST_CRYSTAL * Math.pow(1.6, level - 1));
        }

        private static long getProduction(int level)
        {
            return (long) (ACCELERATOR_FACTOR * 20 * level * Math.pow(1.1, level));
        }

        private static long getEnergyNeeded(int level)
        {
            return (long) (10 * level * Math.pow(1.1, level));
        }
    }

    public static class MetalMineConstants
    {
        private static final long BASE_COST_METAL   = 60;
        private static final long BASE_COST_CRYSTAL = 15;

        public static long[][]    values            = new long[MAX_LEVEL][5];

        static
        {
            Logger.traceINFO(MetalMineConstants.class.getSimpleName());
            Logger.traceINFO("Metal Cost", "Crystal Cost", "Deuterium Cost", "Energy Used", "Production Value per Hour");
            for (int i = 1; i < MAX_LEVEL; i++)
            {
                values[i][METAL_COST_COLUMN_ID] = getMetalCost(i);
                values[i][CRYSTAL_COST_COLUMN_ID] = getCrystalCost(i);
                values[i][DEUTERIUM_COLUMN_ID] = 0;
                values[i][ENERGY_USE] = getEnergyNeeded(i);
                values[i][PRODUCTION_VALUE] = getProduction(i);
                Logger.traceINFO(i, values[i]);
            }
        }

        private static long getMetalCost(int level)
        {
            return (long) (BASE_COST_METAL * Math.pow(1.5, level - 1));
        }

        private static long getCrystalCost(int level)
        {
            return (long) (BASE_COST_CRYSTAL * Math.pow(1.5, level - 1));
        }

        private static long getProduction(int level)
        {
            return (long) (ACCELERATOR_FACTOR * 30 * level * Math.pow(1.1, level));
        }

        private static long getEnergyNeeded(int level)
        {
            return (long) (10 * level * Math.pow(1.1, level));
        }
    }

    public static class DeuteriumSynthetiserConstants
    {
        private static final long BASE_COST_METAL   = 225;
        private static final long BASE_COST_CRYSTAL = 75;

        public static long[][]    values            = new long[MAX_LEVEL][4];

        static
        {
            Logger.traceINFO(MetalMineConstants.class.getSimpleName());
            Logger.traceINFO("Metal Cost", "Crystal Cost", "Deuterium Cost", "Energy Used", "Production Value per Hour");
            for (int i = 1; i < MAX_LEVEL; i++)
            {
                values[i][METAL_COST_COLUMN_ID] = getMetalCost(i);
                values[i][CRYSTAL_COST_COLUMN_ID] = getCrystalCost(i);
                values[i][DEUTERIUM_COLUMN_ID] = 0;
                values[i][ENERGY_USE] = getEnergyNeeded(i);
                Logger.traceINFO(i, values[i]);
            }
        }

        private static long getMetalCost(int level)
        {
            return (long) (BASE_COST_METAL * Math.pow(1.5, level - 1));
        }

        private static long getCrystalCost(int level)
        {
            return (long) (BASE_COST_CRYSTAL * Math.pow(1.5, level - 1));
        }

        // Used by the user
        public static long getProduction(int level, int tAvg)
        {
            return (long) (ACCELERATOR_FACTOR * getEnergyNeeded(level) * (0.68 - 0.002 * tAvg));
        }

        private static long getEnergyNeeded(int level)
        {
            return (long) (20 * level * Math.pow(1.1, level));
        }
    }
}
