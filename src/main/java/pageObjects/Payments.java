package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payments {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchButton;

    public Payments (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}