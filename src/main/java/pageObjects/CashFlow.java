package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CashFlow {

    private WebDriver driver;

    @FindBy(xpath = "//select[@id='selectedConsultancyField']")
    private WebElement serviceSelector;

    @FindBy(xpath = "//input[@id='beginDateField']")
    private WebElement beginDateInput;

    @FindBy(xpath = "//input[@id='endDateField']")
    private WebElement endDateInput;

    @FindBy(xpath = "//button[contains(text(),'Make report')]")
    private WebElement makeReportButton;

    public CashFlow (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
