package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mentors extends PageObjects{

    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createNewEmployeeButton;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

   @FindAll(@FindBy(xpath = "//*[@class='table table-hover']/tbody/tr"))
    private List<WebElement> tableEmployeesRows;

    @FindBy(xpath = "//span[@class='pagination-info']")
    private WebElement spanPaginationInfo;

    @FindAll(@FindBy(xpath = "//*[@class='table table-hover']//th"))
    private List<WebElement> tableEmployeesHeaders;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement inputFirstNamePopUp;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastNamePopUp;

    @FindBy(xpath = "//input[@id='maxClients']")
    private WebElement inputMaxClientsPopUp;

    @FindBy(xpath = "//button[contains(text(),'save')]")
    private WebElement saveButtonPopUp;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement goToMentorsPageButton;

    @FindBy(xpath = "//button[@class='btn btn-danger btn']")
    private WebElement deleteMentorsButton;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    private WebElement deleteConfirmationButtonPopUp;

    public Mentors(WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     public void createEmployee(String firstName, String lastName, String workload) throws InterruptedException {

        createNewEmployeeButton.click();

         Thread.sleep(2000);

        inputFirstNamePopUp.sendKeys(firstName);

        inputLastNamePopUp.sendKeys(lastName);

        inputMaxClientsPopUp.sendKeys(workload);

    }

    public  int getDescribedRowCount(WebDriver driver) {

        List<WebElement> trWebElements = tableEmployeesRows;

        int describedRowCount =  trWebElements.size() - 1;

        return describedRowCount;
    }

    public int getRowCount(WebDriver driver) {

        WebElement recordsTotalNumber = spanPaginationInfo;

        String recordsTotalNumberText = recordsTotalNumber.getText();

        String[] wordCollection = recordsTotalNumberText.split(" ");

        int rowCountsExpected = Integer.parseInt(wordCollection[6]);

        return rowCountsExpected;
    }

    public List<String> getColumnValues(String columnName) throws Exception {

        List<String> vals = super.getColumnValues(columnName, tableEmployeesRows, tableEmployeesHeaders);

        return vals;

    }
    public List<WebElement> getColumnLinks(String columnName) throws Exception {

        List<WebElement> links = super.getColumnLinks(columnName, tableEmployeesRows, tableEmployeesHeaders);

        return links;
    }

    public void saveButtonPopUp() {

        saveButtonPopUp.click();
    }

    public void toMentorsPageButton() {

        goToMentorsPageButton.click();
    }

    public void filterByName(String firstName) throws InterruptedException{

        searchButton.sendKeys(firstName);

        Thread.sleep(2000);
    }

    public void deleteService(WebElement record) throws InterruptedException {
        record.click();
        deleteMentorsButton.click();
        Thread.sleep(2000);
        deleteConfirmationButtonPopUp.click();

    }
}