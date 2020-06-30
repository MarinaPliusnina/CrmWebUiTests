package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Clients {

    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Create Client')]")
    private WebElement createNewClientButton;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

    public Clients (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
