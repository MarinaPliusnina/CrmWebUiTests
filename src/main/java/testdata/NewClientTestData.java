package testdata;

import utils.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NewClientTestData {

    private String firstName;

    private String lastName;

    private String email;

    private String country;

    private String phone;

    private String skype;

    public String getFirstName(){

        return this.firstName;
    }

    public String getLastName(){

        return this.lastName;
    }

    public String getFullName(){

        return this.firstName + " " + this.lastName;
    }

    public static NewClientTestData createNewClientTestData()
    {
        NewClientTestData newClientTestData = new NewClientTestData();

        String timestamp = Long.toString((new Date().getTime())/1000);

        newClientTestData.firstName = "Meryl" +timestamp;
        newClientTestData.lastName = "Streep" + timestamp;
        newClientTestData.email = "meril_streep@gmail.com";
        newClientTestData.country = "USA";
        newClientTestData.phone ="987654321";
        newClientTestData.skype = "meryl_streep";

        return newClientTestData;

    }

    private static String getRandomString() {

        return getRandomString(30);
    }

    private static String getRandomString(int maxLength) {

        Utils ut = new Utils();

        Integer firstNameLength = ut.getRandomInteger(maxLength,3);
        String rndString = ut.getRandomString(firstNameLength,true,false);
        rndString = ut.firstUpperOtherLower(rndString);

        return rndString;
    }

    private static String getRandomPhoneNumber(int maxLength) {

        Utils ut = new Utils();

        Integer firstNameLength = ut.getRandomInteger(maxLength,10);
        String rndString = ut.getRandomString(firstNameLength,false,true);
        rndString = ut.firstUpperOtherLower(rndString);

        return rndString;
    }

    private static String getRandomSkype(int maxLength) {

        Utils ut = new Utils();

        Integer firstNameLength = ut.getRandomInteger(maxLength,3);
        String rndString = ut.getRandomString(firstNameLength,true,true);
        rndString = ut.firstUpperOtherLower(rndString);

        return rndString;
    }

    public static Map<String,String> createMapClientTestData()
    {
        Map<String,String> mapClientTestData = new HashMap<String, String>();
        Utils ut = new Utils();

        String firstName = getRandomString();
        mapClientTestData.put("FirstName", firstName);

        String lastName = getRandomString();
        mapClientTestData.put("LastName",lastName);

        String country = getRandomString();
        mapClientTestData.put("Country", country);

        String city = getRandomString();
        mapClientTestData.put("City", city);

        String email = getRandomString(20) + "@" + getRandomString(20) + ".com";
        mapClientTestData.put("Email", email);

        String phone = getRandomPhoneNumber(10);
        mapClientTestData.put("Phone", phone);

        String skype = getRandomSkype(15);
        mapClientTestData.put("Skype", skype);

        return mapClientTestData;

    }
}