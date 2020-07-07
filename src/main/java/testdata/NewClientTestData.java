package testdata;

import java.util.Date;

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

    public static NewClientTestData createTestData1()
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
}