import com.sun.tools.javac.util.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.Clients;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientsTests extends BaseTest{

    private Clients clients;

    public ClientsTests() throws Exception {
        super();

        clients = new Clients(driver);
    }

    @Test
    public void newClientCreation() throws Exception {

        mainNavigation.navigateClientsPage(driver);

        //declare constants values (test data)
        String timestamp = Long.toString((new Date().getTime())/1000);

        String firstName = "Meryl" +timestamp;

        String lastName = "Streep" + timestamp;

        String email = "meril_streep@gmail.com";

        String country = "USA";

        String phone ="987654321";

        String skype = "meryl_streep";

        //put first name to text field
        clients.createClient(firstName, lastName);

        clients.saveButtonPopUp();

        //"Go back" button click
        clients.goToClientsPage();

        //filter by name
        clients.filterByName(firstName);

        //navigate to the table
        List<String> vals = clients.getColumnValues("Name");

        //check if they are equal
        Assert.check(vals.contains(firstName + " " + lastName));
    }
}
