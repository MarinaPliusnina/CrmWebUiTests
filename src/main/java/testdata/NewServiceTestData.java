package testdata;

import java.util.Date;

public class NewServiceTestData {

    private String title;

    private String description;

    private String price;

    private String employeeRate;

    public String getTitle() {

        return this.title;
    }

    public String getDescription() {

        return this.description;
    }

    public String getPrice() {

        return this.price;
    }

    public String getEmployeeRate() {

        return this.employeeRate;
    }

    public static NewServiceTestData createTestData1() {

        NewServiceTestData newServiceTestData = new NewServiceTestData();

        String timestamp = Long.toString((new Date().getTime())/1000);

        newServiceTestData.title = "Travel arrangements" +timestamp;
        newServiceTestData.description = "Searching of travel options,booking hotels and tickets" + timestamp;
        newServiceTestData.price = "3000";
        newServiceTestData.employeeRate = "2000";

        return newServiceTestData;
    }
}
