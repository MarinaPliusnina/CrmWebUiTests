package pageObjects;

import java.util.List;

import testdata.NewMentorTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Mentors extends PageObjects{

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

    @FindBy(xpath = "//span[@class='pagination-info']")
    private WebElement recordsTotalNumber;

    public Mentors(WebDriver driver)  {

        super(driver);

        PageFactory.initElements(driver, this);
    }

     public void createEmployee(NewMentorTestData newMentorTestData) throws InterruptedException {

        createNewEmployeeButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(inputFirstNamePopUp));

        inputFirstNamePopUp.sendKeys(newMentorTestData.getFirstName());

        inputLastNamePopUp.sendKeys(newMentorTestData.getLastName());

        inputMaxClientsPopUp.sendKeys(newMentorTestData.getMaxClients());
    }

    public  int getDescribedRowCount(WebDriver driver) {

        List<WebElement> trWebElements = tableEmployeesRows;

        int describedRowCount =  trWebElements.size();

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

        String oldTotalNumber = recordsTotalNumber.getText();

        searchButton.sendKeys(firstName);

        WaitTextChanged(recordsTotalNumber, oldTotalNumber);
    }

    public void deleteService(WebElement record) throws InterruptedException {

        record.click();

        deleteMentorsButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationButtonPopUp));

        deleteConfirmationButtonPopUp.click();
    }
}
