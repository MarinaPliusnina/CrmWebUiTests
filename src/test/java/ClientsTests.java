import com.sun.tools.javac.util.Assert;
import testdata.NewClientTestData;
import org.junit.Test;

import pageObjects.Clients;

import java.util.List;


public class ClientsTests extends BaseTest{

    private Clients clients;

    public ClientsTests() throws Exception {

        super();

        clients = new Clients(driver);

    }

    @Test
    public void newClientCreation() throws Exception {

        // Act
        mainNavigation.navigateClientsPage(driver);

        NewClientTestData clientTestData = NewClientTestData.createNewClientTestData();

        clients.createClient(clientTestData);

        clients.saveButtonPopUp();

        clients.goToClientsPage();

        clients.filterByName(clientTestData.getFirstName());

        // Assert
        List<String> vals = clients.getColumnValues("Name");

        Assert.check(vals.contains(clientTestData.getFullName()));
    }
}
