package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='login-form-link']")
    private WebElement tabSelectorLogin;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInputLogin;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputLogin;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='register-form-link']")
    private WebElement tabSelectorRegister;

    @FindBy(xpath = "//input[@id='register-username']")
    private WebElement usernameInputRegister;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInputRegister;

    @FindBy(xpath = "//input[@id='register-password']")
    private WebElement passwordInputRegister;

    @FindBy(xpath = "//input[@id='register-submit']")
    private WebElement registerButton;

    public LogInPage(WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(WebDriver driver, String url) {

        driver.get(url);

        usernameInputLogin.sendKeys("admin");

        passwordInputLogin.sendKeys("admin");

        loginButton.click();
    }
}
