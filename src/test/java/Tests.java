
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Tests {

    private static String testUrl;

    @BeforeClass
    public static void BeforeClassInit() {

        InputStream input = Tests.class.getClassLoader().getResourceAsStream("config.properties");

        Properties prop = new Properties();

        try{
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        testUrl = prop.getProperty("test.url");
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