import config.Config;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LogInPage;
import pageObjects.MainNavigation;

public class BaseTest {

    protected static LogInPage logInPage;

    protected static WebDriver driver;

    protected static MainNavigation mainNavigation;

    protected static String testUrl;

    @BeforeClass
    public static void beforeClassBase() {

        testUrl = Config.getProperty("test.url");
        driver = new ChromeDriver();
        logInPage = new LogInPage();
        mainNavigation = new MainNavigation();

        logInPage.login(driver, testUrl);
    }

    @AfterClass
    public static void afterClass() {

        driver.close();
    }
}