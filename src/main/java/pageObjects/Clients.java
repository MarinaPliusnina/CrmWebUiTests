package pageObjects;

import testdata.NewClientTestData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class Clients extends PageObjects{

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

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover']/tbody/tr"))
    private List<WebElement> tableClientsRows;

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover']//th"))
    private List<WebElement> tableClientsHeaders;

    @FindBy(xpath = "//span[@class='pagination-info']")
    private WebElement recordsTotalNumber;

    @FindBy(xpath = "//div[@class =\"modal-footer\"]/button[contains(text(),'Yes')]")
    private WebElement deleteConfirmationButtonPopUp;

    public Clients(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void createClient(NewClientTestData newClientTestData) throws InterruptedException {

        createNewClientButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(newClientFirstName));

        newClientFirstName.sendKeys(newClientTestData.getFirstName());

        newClientLastName.sendKeys(newClientTestData.getLastName());

    }

    public void createClient (Map<String, String> mapClientTestData) throws InterruptedException {

        createNewClientButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(newClientFirstName));

        newClientFirstName.sendKeys(mapClientTestData.get("FirstName"));

        newClientLastName.sendKeys(mapClientTestData.get("LastName"));

    }

    public void fillClientDetailsForm (Map<String, String> mapClientTestData) throws InterruptedException {

        inputEmail(mapClientTestData.get("Email"));
        inputCountry(mapClientTestData.get("Country"));
        inputCity(mapClientTestData.get("City"));
        inputPhone(mapClientTestData.get("Phone"));
        inputSkype(mapClientTestData.get("Skype"));

    }

    public List<WebElement> getColumnLinks(String columnName) throws Exception {

        List<WebElement> links = super.getColumnLinks(columnName, tableClientsRows, tableClientsHeaders);

        return links;
    }

    public Map<String, String> getClientDetails() {

    Map<String, String> map = new HashMap<String, String>();

    map.put("FirstName", newClientFirstName.getAttribute("value"));
    map.put("LastName", newClientLastName.getAttribute("value"));
    map.put("Email", emailInput.getAttribute("value"));
    map.put("Country", countryInput.getAttribute("value"));
    map.put("City", cityInput.getAttribute("value"));
    map.put("Phone", phoneInput.getAttribute("value"));
    map.put("Skype", skypeInput.getAttribute("value"));

    return map;

    }

    public List<String> getColumnValues(String columnName) throws Exception {

        List<String> vals = super.getColumnValues(columnName, tableClientsRows, tableClientsHeaders);

        return vals;

    }

    public void filterByName(String name) throws InterruptedException {

        String oldTotalNumber = recordsTotalNumber.getText();

        searchInput.sendKeys(name);

        WaitTextChanged(recordsTotalNumber, oldTotalNumber);

    }

    public void deleteClient() throws InterruptedException {

        buttonDelete.click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationButtonPopUp));

        deleteConfirmationButtonPopUp.click();
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

        phoneInput.sendKeys(phone);
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

}


