import config.Config;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LogInPage;
import pageObjects.MainNavigation;

public class BaseTest {

    protected LogInPage logInPage;

    protected WebDriver driver;

    protected MainNavigation mainNavigation;

    protected String testUrl;

    private String driverBrowser;

    public BaseTest() throws Exception {

        testUrl = Config.getProperty("test.url");

        initBrowserDriver();

        logInPage = new LogInPage(driver);

        mainNavigation = new MainNavigation(driver);
    }

    @Before
    public void beforeClassBase()  {

        logInPage.login(driver, testUrl);
    }

    @After
    public void afterClass() {

        driver.close();
    }

    private void initBrowserDriver() throws Exception {

        driverBrowser = Config.getProperty("driver.browser");

        if (driverBrowser.equals("ChromeDriver")) {

            driver = new ChromeDriver();

        } else if (driverBrowser.equals("FirefoxDriver")) {

            driver = new FirefoxDriver();

        } else {

            throw new Exception("Unknown driver browser type");

        }
    }
}