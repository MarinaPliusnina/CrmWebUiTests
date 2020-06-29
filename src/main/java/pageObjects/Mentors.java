package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mentors {

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

    public List<String>  getColumnValues(WebDriver driver, String columnName) throws Exception {

        int wantedColumnNumber = getColumnNumber(driver, columnName);

        List<WebElement> tableRows = getEmployeeTableRows(driver);

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

    private List<WebElement> getEmployeeTableRows(WebDriver driver) {

        List<WebElement> tableRows = tableEmployeesRows;

        tableRows = tableRows.subList(1,tableRows.size());

        return tableRows;
    }

    private int getColumnNumber(WebDriver driver, String columnName) throws Exception {

        List<WebElement> headerRow = tableEmployeesHeaders;

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