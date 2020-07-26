package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNavigation {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]/..")
    private WebElement dashboardButton;

    @FindBy(xpath= "//*[contains(text(),'Сделки')]/..")
    private WebElement transactionsButton;

    @FindBy(xpath = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Новые')]")
    private WebElement transactionsButtonNew;

    @FindBy(xpath = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Архив')]")
    private WebElement transactionsButtonArchive;

    @FindBy(xpath = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Все')]")
    private WebElement transactionsButtonAll;

    @FindBy(xpath = "//span[contains(text(),'Очередь')]/..")
    private WebElement pipelineButton;

    @FindBy(xpath = "//span[contains(text(),'Клиенты')]/..")
    private WebElement clientsButton;

    @FindBy(xpath = "//span[contains(text(),'Менторы')]/..")
    private WebElement mentorsButton;

    @FindBy(xpath = "//span[contains(text(),'Договора')]/..")
    private WebElement contractsButton;

    @FindBy(xpath = "//span[contains(text(),'Договора')]/../..//a[contains(text(),'Все')]")
    private WebElement contractsButtonAll;

    @FindBy(xpath = "//span[contains(text(),'Договора')]/../..//a[contains(text(),'Тестовые')]")
    private WebElement contractsButtonTest;

    @FindBy(xpath = "//span[contains(text(),'Услуги')]/..")
    private WebElement servicesButton;

    @FindBy(xpath = "//span[contains(text(),'Счета')]/..")
    private WebElement invoicesButton;

    @FindBy(xpath = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Все')]")
    private WebElement invoicesButtonAll;

    @FindBy(xpath = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Выставить')]]")
    private WebElement invoicesButtonBill;

    @FindBy(xpath = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Просроченные')]")
    private WebElement invoicesButtonExpired;

    @FindBy(xpath = "//span[contains(text(),'Зарплаты')]/..")
    private WebElement salariesButton;

    @FindBy(xpath = "//span[contains(text(),'Зарплаты')]/../..//a[contains(text(),'Зарплата')]")
    private WebElement salariesButtonSalary;

    @FindBy(xpath = "//span[contains(text(),'Зарплаты')]/../..//a[contains(text(),'Формирование зарплаты')]")
    private WebElement salariesButtonCalculation;

    @FindBy(xpath = "//span[contains(text(),'Платежи')]")
    private WebElement paymentsButton;

    @FindBy(xpath = "//span[contains(text(),'Пользователи')]")
    private WebElement usersButton;

    @FindBy(xpath = "//span[contains(text(),'Движение денег')]")
    private WebElement cashFlowButton;

    public MainNavigation(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateMentorsPage(WebDriver driver) {

        mentorsButton.click();
    }
    public void navigateClientsPage(WebDriver driver) {

        clientsButton.click();
    }

    public void navigateServicesPage(WebDriver driver) {

        servicesButton.click();
    }
}
