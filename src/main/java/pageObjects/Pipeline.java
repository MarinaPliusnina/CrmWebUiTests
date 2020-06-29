package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pipeline {

    private WebDriver driver;

    @FindBy(xpath = "//p[contains(text(),'Group Development')]")
    private WebElement tabSelectorGroupDevelopment;

    @FindBy(xpath = "//p[contains(text(),'Mentoring')]")
    private WebElement tabSelectorMentoring;

    @FindBy(xpath = "//p[contains(text(),'Personal Mentor')]")
    private WebElement tabSelectorPersonalMentor;

    public Pipeline (WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
