import com.sun.tools.javac.util.Assert;
import org.junit.After;
import org.openqa.selenium.WebElement;
import testdata.NewClientTestData;
import org.junit.Test;

import pageObjects.Clients;

import java.util.List;
import java.util.Map;

public class ClientsTests extends BaseTest{

    private Clients clients;

    private String clientName;

    public ClientsTests() throws Exception {

        super();

        clients = new Clients(driver);
    }

    @Test
    public void newClientCreation() throws Exception {

        // Act
        mainNavigation.navigateClientsPage(driver);

        NewClientTestData clientTestData = NewClientTestData.createNewClientTestData();

        clientName = clientTestData.getFirstName();

        clients.createClient(clientTestData);

        clients.saveButtonPopUp();

        clients.goToClientsPage();

        clients.filterByName(clientTestData.getFirstName());

        // Assert
        List<String> vals = clients.getColumnValues("Name");

        Assert.check(vals.contains(clientTestData.getFullName()));
    }

    @Test
    public void newRandomClientCreation() throws Exception {

        // Act
        mainNavigation.navigateClientsPage(driver);

        Map<String,String> clientTestData = NewClientTestData.createMapClientTestData();

        clientName = clientTestData.get("FirstName");

        clients.createClient(clientTestData);

        clients.saveButtonPopUp();

        clients.fillClientDetailsForm(clientTestData);

        clients.saveNewClient();

        clients.filterByName(clientTestData.get("FirstName"));

        List<WebElement> links = clients.getColumnLinks("Name");

        links.get(0).click();

        Map<String, String> clientDetails = clients.getClientDetails();

        // Assert
       Assert.check(clientDetails.equals(clientTestData));

    }

    @After
    public void deleteRandomTestData() throws Exception {

        mainNavigation.navigateClientsPage(driver);

        clients.filterByName(clientName);

        List<WebElement> links = clients.getColumnLinks("Name");

        links.get(0).click();

        clients.deleteClient();
    }
}
