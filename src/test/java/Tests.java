import org.junit.Test;

public class Tests extends BaseTest {

    @Test
    public void ChromeExample() {

        driver.get(testUrl);
    }

    @Test
    public void FirefoxExample() {

        // ???
        // WebDriver driver = new FirefoxDriver();

        driver.get(testUrl);
    }
}