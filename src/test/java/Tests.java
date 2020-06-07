
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tests {

    @Test
    public void ChromeExample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }

    @Test
    public void FirefoxExample() {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }
}