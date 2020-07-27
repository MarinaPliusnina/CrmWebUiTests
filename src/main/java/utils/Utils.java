package utils;

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

    public Double getRandomInteger(Integer min, Integer max, Integer precision) {

        int k =(int) Math.pow(10, precision);

        int kmin = k*min;
        int kmax = k*max;

        double randomNumber = 1.0 * ( random.nextInt(kmax + 1 - kmin) + kmin ) / k;

        return randomNumber;
    }

    public String getRandomString(Integer length) {

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
