import config.Config;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LogInPage;
import pageObjects.MainNavigation;

public class BaseTest {

    protected static LogInPage logInPage;

    protected static WebDriver driver;

    protected static MainNavigation mainNavigation;

    protected static String testUrl;

    private static String driverBrowser;

    @BeforeClass
    public static void beforeClassBase() throws Exception {

        testUrl = Config.getProperty("test.url");

        initBrowserDriver();

        logInPage = new LogInPage(driver);
        mainNavigation = new MainNavigation();

        logInPage.login(driver, testUrl);
    }

    @AfterClass
    public static void afterClass() {

        driver.close();
    }

    private static void initBrowserDriver() throws Exception {

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