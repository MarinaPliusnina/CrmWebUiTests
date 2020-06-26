package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainNavigation {

    public String dashboardButton = "//span[contains(text(),'Dashboard')]/..";
    public String transactionsButton = "//*[contains(text(),'Сделки')]/..";
    public String transactionsButtonNew = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Новые')]";
    public String transactionsButtonArchive = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Архив')]";
    public String transactionsButtonAll = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Все')]";
    public String pipelineButton = "//span[contains(text(),'Очередь')]/..";
    public String clientsButton = "//span[contains(text(),'Клиенты')]/..";
    public String mentorsButton = "//span[contains(text(),'Менторы')]/..";
    public String contractsButton = "//span[contains(text(),'Договора')]/..";
    public String contractsButtonAll = "//span[contains(text(),'Договора')]/../..//a[contains(text(),'Все')]";
    public String contractsButtonTest = "//span[contains(text(),'Договора')]/../..//a[contains(text(),'Тестовые')]";
    public String servicesButton = "//span[contains(text(),'Услуги')]/..";
    public String invoicesButton = "//span[contains(text(),'Счета')]/..";
    public String invoicesButtonAll = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Все')]";
    public String invoicesButtonBill = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Выставить')]]";
    public String invoicesButtonExpired = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Просроченные')]";
    public String salariesButton = "//span[contains(text(),'Зарплаты')]/..";
    public String salariesButtonSalary= "//span[contains(text(),'Зарплаты')]/../..//a[contains(text(),'Зарплата')]";
    public String salariesButtonCalculation= "//span[contains(text(),'Зарплаты')]/../..//a[contains(text(),'Формирование зарплаты')]";
    public String paymentsButton= "//span[contains(text(),'Платежи')]";
    public String usersButton= "//span[contains(text(),'Пользователи')]";
    public String cashFlowButton= "//span[contains(text(),'Движение денег')]";

    public void navigateMentorsPage(WebDriver driver) {

        By byMentorsButton = new By.ByXPath(mentorsButton);

        driver.findElement(byMentorsButton).click();
    }
}
