package pageObjects;

import testdata.NewServiceTestData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Services extends PageObjects{

    @FindBy(xpath = "//a[contains(text(),'New consultancy')]")
    private WebElement newConsultancyButton;

    @FindBy(xpath = "//div[@class='pull-right search']/input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@name='refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = " //input[@id='name']")
    private WebElement inputTitle;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement inputDescription;

    @FindBy(xpath = "//input[@id='prices[0].amount']")
    private WebElement inputPriceUAH;

    @FindBy(xpath = "//input[@id='employeeRate.amount']")
    private WebElement inputEmployeeRateUAH;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement savePrices;

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover']/tbody/tr"))
    private List<WebElement> tableServicesRows;

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover']//th"))
    private List<WebElement> tableServicesHeaders;

    @FindBy(xpath="//button[@class='btn btn-danger btn']")
    private WebElement deleteServiceButton;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    private WebElement deleteConfirmationButtonPopUp;

    @FindBy(xpath = "//span[@class='pagination-info']")
    private WebElement recordsTotalNumber;

    public Services (WebDriver driver)  {

        super(driver);

        PageFactory.initElements(driver, this);

    }

    public void createService(NewServiceTestData newServiceTestData) {

        newConsultancyButton.click();

        inputTitle.sendKeys(newServiceTestData.getTitle());

        inputDescription.sendKeys(newServiceTestData.getDescription());

        inputPriceUAH.sendKeys(newServiceTestData.getPrice());

        inputEmployeeRateUAH.sendKeys(newServiceTestData.getEmployeeRate());
    }

    public void saveService() {

        savePrices.click();
    }

    public void filterByTitle(String name) throws InterruptedException {

        String oldTotalNumber = recordsTotalNumber.getText();

        searchInput.sendKeys(name);

        WaitTextChanged(recordsTotalNumber, oldTotalNumber);

    }

    public List<String> getColumnValues(String columnName) throws Exception {

        List<String> vals = super.getColumnValues(columnName, tableServicesRows, tableServicesHeaders);

        return vals;
    }

    public List<WebElement> getColumnLinks(String columnName) throws Exception {

        List<WebElement> links = super.getColumnLinks(columnName, tableServicesRows, tableServicesHeaders);

        return links;
    }

    public void deleteService(WebElement record) throws InterruptedException {

        record.click();

        deleteServiceButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationButtonPopUp));

        deleteConfirmationButtonPopUp.click();
    }
}
