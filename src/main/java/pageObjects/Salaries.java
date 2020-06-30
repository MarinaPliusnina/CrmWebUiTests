package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Salaries {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = "//input[@name='dateFrom']")
    private WebElement dateFromDatePicker;

    @FindBy(xpath = "//input[@name='dateTo']")
    private WebElement dateToDatePicker;

    @FindBy(xpath = "//button[contains(text(),'Calculate salaries')]")
    private WebElement calculateSalariesButton;

    public Salaries (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
