package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private WebDriver driver;

    public String tabSelectorLogin = "//a[@id='login-form-link']";

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInputLogin;

    public String passwordInputLogin = "//input[@id='password']";
    public String loginButton = "//input[@id='login-submit']";

    public String tabSelectorRegister = "//a[@id='register-form-link']";
    public String usernameInputRegister = "//input[@id='register-username']";
    public String emailInputRegister = "//input[@id='email']";
    public String passwordInputRegister = "//input[@id='register-password']";
    public String registerButton = "//input[@id='register-submit']";

    public LogInPage(WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(WebDriver driver, String url) {

        driver.get(url);

        usernameInputLogin.sendKeys("admin");
        driver.findElement(new By.ByXPath("//input[@id='password']")).sendKeys("admin");
        driver.findElement(new By.ByXPath("//input[@id='login-submit']")).click();
    }
}
