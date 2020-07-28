package utils;

import org.openqa.selenium.InvalidArgumentException;

import java.util.Random;

public class Utils {

    private Random random;

    public Utils()
    {
        random = new Random();
    }

    public boolean getRandomBoolean(){

        boolean randomBooleanValue = random.nextBoolean();

        return randomBooleanValue;
    }

    public Double getRandomDouble(Integer min, Integer max, Integer precision) throws InvalidArgumentException {

        if (!(max > min)) throw new InvalidArgumentException("Max should be greater than min");
        if (!(precision>=0)) throw new InvalidArgumentException("Precision value should be greater than O");

        int k =(int) Math.pow(10, precision);

        int kmin = k*min;
        int kmax = k*max;

        double randomNumber = 1.0 * ( random.nextInt(kmax + 1 - kmin) + kmin ) / k;

        return randomNumber;
    }

    public String getRandomString(Integer length) throws Exception {

        if (!(length>0)) throw new InvalidArgumentException("Length should be greater than 0");

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";

        String randomString = "";

        for (int i=0; i<length; i++)
        {
            int randomPosition = random.nextInt(chars.length());

            randomString += chars.charAt(randomPosition);
        }

        return randomString;
    }

}
