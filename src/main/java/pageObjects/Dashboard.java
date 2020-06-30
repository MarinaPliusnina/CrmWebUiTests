package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Home')]/..")
    private WebElement homePageButton;

    @FindBy(xpath = "//i[@class='fa fa-minus']/..")
    private WebElement tableCollapseButton;

    @FindBy(xpath = "//i[@class='fa fa-times']/..")
    private WebElement tableRemoveButton;

    public Dashboard (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
