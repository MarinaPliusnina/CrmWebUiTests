package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Services {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'New consultancy')]")
    private WebElement newConsultancyButton;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

    public Services (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
