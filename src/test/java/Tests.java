import config.Config;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Tests {

    private static String testUrl;

    @BeforeClass
    public static void BeforeClassInit() {

        testUrl = Config.getProperty("test.url");

    }

    @Test
    public void ChromeExample() {

        WebDriver driver = new ChromeDriver();

        driver.get(testUrl);

        driver.quit();
    }

    @Test
    public void FirefoxExample() {

        WebDriver driver = new FirefoxDriver();

        driver.get(testUrl);

        driver.quit();
    }
}