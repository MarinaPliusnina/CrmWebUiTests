package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


import static java.lang.Thread.sleep;

public class Clients {

    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Create Client')]")
    private WebElement createNewClientButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement newClientFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement newClientLastName;

    @FindBy(xpath = "//button[contains(text(),'save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryInput;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id='skype']")
    private WebElement skypeInput;

    @FindBy(xpath = "//input[@id='extraFields0.value']")
    private WebElement extraSkypeInput;

    @FindBy(xpath = "//input[@id='extraFields1.value']")
    private WebElement extraEmailInput;

    @FindBy(xpath = "//button[@class='btn btn-danger btn']")
    private WebElement buttonDelete;

    @FindBy(xpath = " //button[contains(text(),'Go back')]")
    private WebElement buttonGoToClientsPage;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement buttonNewDeal;

    @FindBy(xpath = "//div[@class='btn-group']//button[@class='btn btn-primary'][contains(text(),'Save')]")
    private WebElement buttonSave;

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover']//tr"))
    private List<WebElement> tableClientsRows;

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover']//th"))
    private List<WebElement> tableClientsHeaders;


    public Clients(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createClient(String firstName, String lastName) {

        createNewClientButton.click();

        newClientFirstName.sendKeys(firstName);

        newClientLastName.sendKeys(lastName);



    }

    public void filterByName(String name) throws InterruptedException {

        searchInput.sendKeys(name);
        Thread.sleep(2000);
    }

    public void saveButtonPopUp() {

        saveButton.click();
    }

    public void inputEmail(String email) {

        emailInput.sendKeys(email);
    }

    public void inputCountry(String country) {

        countryInput.sendKeys(country);
    }

    public void inputCity(String city) {

        cityInput.sendKeys(city);
    }

    public void inputPhone(String phone) {

        cityInput.sendKeys(phone);
    }

    public void inputSkype(String skype) {

        skypeInput.sendKeys(skype);
    }

    public void saveNewClient() {

        buttonSave.click();
    }
    public void goToClientsPage(){

        buttonGoToClientsPage.click();
    }

    public List<String>  getColumnValues(String columnName) throws Exception {

        int wantedColumnNumber = getColumnNumber(columnName);

        List<WebElement> tableRows = getEmployeeTableRows();

        List<String> resultArray = getColumnValues(wantedColumnNumber, tableRows);

        return resultArray;
    }

    private List<String> getColumnValues(int wantedColumnNumber, List<WebElement> tableRows) {

        List<String> resultArray = new ArrayList<String>();

        for (WebElement currentRow : tableRows) {

            List<WebElement> cells = currentRow.findElements(new By.ByTagName("td"));

            String cellText = cells.get(wantedColumnNumber).getText();

            resultArray.add(cellText);
        }

        return resultArray;
    }

    private List<WebElement> getEmployeeTableRows() {

        List<WebElement> tableRows = tableClientsRows;

        tableRows = tableRows.subList(1,tableRows.size());

        return tableRows;
    }

    private int getColumnNumber(String columnName) throws Exception {

        List<WebElement> headerRow = tableClientsHeaders;

        for (int i=0; i < headerRow.size(); i++) {

            WebElement currentWebElement = headerRow.get(i);

            String currentWebElementName = currentWebElement.getText();

            if (currentWebElementName.equals(columnName)) {

                return i;

            }
        }

        throw new Exception("Column name not found");
    }
}


