package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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

   @FindAll(@FindBy(xpath = "//*[@class='table table-hover']//tr"))
    private List<WebElement> tableEmployeesRows;

    @FindBy(xpath = "//span[@class='pagination-info']")
    private WebElement spanPaginationInfo;

    @FindAll(@FindBy(xpath = "//*[@class='table table-hover']//th"))
    private List<WebElement> tableEmployeesHeaders;

    public Mentors(WebDriver driver)  {

        this.driver = driver;
        PageFactory.initElements(driver, this);
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
}