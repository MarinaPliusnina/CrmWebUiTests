package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    public String tabSelectorLogin = "//a[@id='login-form-link']";
    public String usernameInputLogin = "//input[@id='username']";
    public String passwordInputLogin = "//input[@id='password']";
    public String loginButton = "//input[@id='login-submit']";

    public String tabSelectorRegister = "//a[@id='register-form-link']";
    public String usernameInputRegister = "//input[@id='register-username']";
    public String emailInputRegister = "//input[@id='email']";
    public String passwordInputRegister = "//input[@id='register-password']";
    public String registerButton = "//input[@id='register-submit']";

    public void login(WebDriver driver, String url) {

        driver.get(url);
        driver.findElement(new By.ByXPath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(new By.ByXPath("//input[@id='password']")).sendKeys("admin");
        driver.findElement(new By.ByXPath("//input[@id='login-submit']")).click();
    }
}
