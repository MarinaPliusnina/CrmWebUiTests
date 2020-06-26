package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mentors {

    public String createNewEmployeeButton = "//button[contains(text(),'Create')]";

    public String searchButton = "//div[@class='pull-right search']/input";

    public String refreshButton = "//button[@name='refresh']";

    public String tableEmployeesRows = "//*[@class='table table-hover']//tr";

    public String spanPaginationInfo = "//span[@class='pagination-info']";

    public String tableEmployeesHeaders = "//*[@class='table table-hover']//th";

    public  int getDescribedRowCount(WebDriver driver) {

        By byTableEmployees = new By.ByXPath(tableEmployeesRows);

        List<WebElement> trWebElements = driver.findElements(byTableEmployees);

        int describedRowCount =  trWebElements.size() - 1;

        return describedRowCount;
    }

    public int getRowCount(WebDriver driver) {

        By bySpanPaginationInfo = new By.ByXPath(spanPaginationInfo);

        WebElement recordsTotalNumber = driver.findElement(bySpanPaginationInfo);

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

        By byTableEmployeesRows = new By.ByXPath(tableEmployeesRows);

        List<WebElement> tableRows = driver.findElements(byTableEmployeesRows);

        tableRows = tableRows.subList(1,tableRows.size());

        return tableRows;
    }

    private int getColumnNumber(WebDriver driver, String columnName) throws Exception {

        By byTableEmployeesHeaders = new By.ByXPath(tableEmployeesHeaders);

        List<WebElement> headerRow = driver.findElements(byTableEmployeesHeaders);

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