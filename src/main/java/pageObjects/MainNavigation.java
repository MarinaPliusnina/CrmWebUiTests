package pageObjects;

public class MainNavigation {

    public String XPathBtnDashboard = "//span[contains(text(),'Dashboard')]/..";
    public String XPathBtnTransactions = "//*[contains(text(),'Сделки')]/..";
    public String XPathBtnTransactionsNew = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Новые')]";
    public String XPathBtnTransactionsArchive = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Архив')]";
    public String XPathBtnTransactionsAll = "//span[contains(text(),'Сделки')]/../..//a[contains(text(),'Все')]";
    public String XPathBtnPipeline = "//span[contains(text(),'Очередь')]/..";
    public String XPathBtnClients = "//span[contains(text(),'Клиенты')]/..";
    public String XPathBtnMentors = "//span[contains(text(),'Менторы')]/..";
    public String XPathBtnContracts = "//span[contains(text(),'Договора')]/..";
    public String XPathBtnContractsAll = "//span[contains(text(),'Договора')]/../..//a[contains(text(),'Все')]";
    public String XPathBtnContractsTest = "//span[contains(text(),'Договора')]/../..//a[contains(text(),'Тестовые')]";
    public String XPathBtnServices = "//span[contains(text(),'Услуги')]/..";
    public String XPathBtnInvoices = "//span[contains(text(),'Счета')]/..";
    public String XPathBtnInvoicesAll = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Все')]";
    public String XPathBtnInvoicesBill = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Выставить')]]";
    public String XPathBtnInvoicesExpired = "//span[contains(text(),'Счета')]/../..//a[contains(text(),'Просроченные')]";
    public String XPathSalariesBtn = "//span[contains(text(),'Зарплаты')]/..";
    public String XPathSalariesBtnSalary= "//span[contains(text(),'Зарплаты')]/../..//a[contains(text(),'Зарплата')]";
    public String XPathSalariesBtnCalculation= "//span[contains(text(),'Зарплаты')]/../..//a[contains(text(),'Формирование зарплаты')]";
    public String XPathBtnPayments= "//span[contains(text(),'Платежи')]";
    public String XPathBtnUsers= "//span[contains(text(),'Пользователи')]";
    public String XPathBtnCashFlow= "//span[contains(text(),'Движение денег')]";
}
