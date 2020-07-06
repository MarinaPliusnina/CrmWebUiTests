import com.sun.tools.javac.util.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pageObjects.Services;

import java.util.Date;
import java.util.List;

public class ServicesTests extends BaseTest{

    private Services services;

    public ServicesTests() throws Exception {
        super();

        services = new Services(driver);
    }

    @Test
    public void newServiceCreation() throws Exception {

        mainNavigation.navigateServicesPage(driver);

        //declare constants values (test data)
        String timestamp = Long.toString((new Date().getTime())/1000);

        String title = "Travel arrangements" +timestamp;

        String description = "Searching of travel options,booking hotels and tickets" + timestamp;

        String price = "3000";

        String employeeRate = "2000";


        //put first name to text field
        services.createService(title, description, price, employeeRate);

        services.saveService();

        //filter by name
        services.filterByTitle(title);

        //navigate to the table

        List<String> vals = services.getColumnValues("Name");

        //check if they are equal
        Assert.check(vals.contains(title));
    }

    @After
     public void deleteOutputTestData() throws Exception {

        //navigate to record
        List<WebElement> record = services.getColumnLinks("Name");


        //delete record
        services.deleteService(record.get(0));

    }

}
