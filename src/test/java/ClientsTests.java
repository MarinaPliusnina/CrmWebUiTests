import com.sun.tools.javac.util.Assert;
import dto.NewClientTestData;
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

        NewClientTestData clientTestData = NewClientTestData.createTestData1();

        clients.createClient(clientTestData);

        clients.saveButtonPopUp();

        clients.goToClientsPage();

        clients.filterByName(clientTestData.getFirstName());

        // Assert
        List<String> vals = clients.getColumnValues("Name");

        Assert.check(vals.contains(clientTestData.getFullName()));
    }
}
