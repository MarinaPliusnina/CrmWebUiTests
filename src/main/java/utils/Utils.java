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
    public Integer getRandomInteger(Integer max, Integer min) throws InvalidArgumentException {

        if (max < min) {

            throw new InvalidArgumentException("Max should be greater than min");
        }

        int randomInteger = random.nextInt(max + 1 - min) + min;

        return randomInteger;

    }

    public Double getRandomDouble(Integer min, Integer max, Integer precision) throws InvalidArgumentException {

        if (!(max > min)) {

            throw new InvalidArgumentException("Max should be greater than min");

        }

        if (!(precision>=0)) {

            throw new InvalidArgumentException("Precision value should be greater than O");

        }

        int k =(int) Math.pow(10, precision);

        int kmin = k*min;
        int kmax = k*max;

        double randomNumber = 1.0 * ( random.nextInt(kmax + 1 - kmin) + kmin ) / k;

        return randomNumber;
    }

    public String getRandomString(Integer length) throws InvalidArgumentException {

        return getRandomString(length, true,true);
    }

    public String getRandomString(Integer length, Boolean useLetters, Boolean useNumbers) throws InvalidArgumentException {

        if (!(length > 0)) {

            throw new InvalidArgumentException("Length should be greater than 0");

        }

        if ((useLetters==Boolean.FALSE)&&(useNumbers==Boolean.FALSE)) {

            throw new InvalidArgumentException("One of parameters (useLetters, useNumbers) should be TRUE");
        }

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";
        String randomAlphabet = "";
        if (useLetters==true) {

            randomAlphabet+=letters;
        }
        if (useNumbers==true) {

            randomAlphabet+=numbers;
        }

        String randomString = "";

        for (int i = 0; i < length; i++) {
            int randomPosition = random.nextInt(randomAlphabet.length());

            randomString += randomAlphabet.charAt(randomPosition);
        }

        return randomString;
    }

    public String firstUpperOtherLower(String inputStr) {

        String result = inputStr.substring(1).toLowerCase();

        String firstLetter = inputStr.substring(0, 1).toUpperCase();

        result = firstLetter + result;

        return result;

    }

}
