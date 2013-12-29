package tool;

import java.math.BigInteger;

public class Duration
{
    @Override
    public String toString()
    {
        return "Duration [hours=" + hours + ", mins=" + mins + ", secs=" + secs + " ]";
    }

    BigInteger              hours;
    BigInteger              mins;
    BigInteger              secs;
    final static BigInteger SECS_IN_HOUR = new BigInteger("3600");
    final static BigInteger SECS_IN_MIN  = new BigInteger("60");

    public Duration(BigInteger timeSec)
    {
        hours = timeSec.divide(SECS_IN_HOUR);
        BigInteger remainder = timeSec.subtract(hours.multiply(SECS_IN_HOUR));

        mins = remainder.divide(SECS_IN_MIN);
        remainder = remainder.subtract(mins.multiply(SECS_IN_MIN));

        secs = remainder;
    }

    public String display()
    {
        return hours + "h " + mins + "m " + secs + "s";
    }

    public BigInteger getHours()
    {
        return hours;
    }

    public BigInteger getMins()
    {
        return mins;
    }

    public BigInteger getSecs()
    {
        return secs;
    }

}
