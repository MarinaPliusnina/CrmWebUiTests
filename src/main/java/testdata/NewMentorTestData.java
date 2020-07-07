package testdata;

import java.util.Date;

public class NewMentorTestData {

    private String firstName;

    private String lastName;

    private String maxClients;

    public String getFirstName(){

        return this.firstName;
    }

    public String getLastName(){

        return this.lastName;
    }

    public String getFullName(){

        return this.firstName + " " + this.lastName;
    }
    public String getMaxClients() {

        return this.maxClients;
    }

    public static NewMentorTestData createTestData1() {

        NewMentorTestData newMentorTestData = new NewMentorTestData();

        String timestamp = Long.toString((new Date().getTime())/1000);

        newMentorTestData.firstName = "Kira" +timestamp;
        newMentorTestData.lastName = "Knightley" + timestamp;
        newMentorTestData.maxClients = "5";

        return newMentorTestData;

    }
}
