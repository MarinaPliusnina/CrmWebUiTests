package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoices {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = "//button[@id ='updateButton']")
    private WebElement createInvoiceButton;

    public Invoices (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
