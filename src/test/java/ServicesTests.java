import com.sun.tools.javac.util.Assert;
import testdata.NewServiceTestData;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pageObjects.Services;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServicesTests extends BaseTest{

    private Services services;

    public ServicesTests() throws Exception {

        super();

        services = new Services(driver);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void newServiceCreation() throws Exception {

        //Act
        mainNavigation.navigateServicesPage(driver);

        NewServiceTestData serviceTestData = NewServiceTestData.createNewServiceTestData();

        services.createService(serviceTestData);

        services.saveService();

        services.filterByTitle(serviceTestData.getTitle());

        //Assert
        List<String> vals = services.getColumnValues("Name");

        Assert.check(vals.contains(serviceTestData.getTitle()));
    }

    @After
    public void deleteOutputTestData() throws Exception {

        List<WebElement> record = services.getColumnLinks("Name");

        services.deleteService(record.get(0));
    }
}
