package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageObjects {

    protected List<String> getColumnValues(String columnName, List<WebElement> tableRows, List<WebElement> headerCells) throws Exception {

        int wantedColumnNumber = getColumnNumber(columnName, headerCells);

        List<WebElement> tableRowsClients = getEmployeeTableRows(tableRows);

        List<String> resultArray = getColumnValues(wantedColumnNumber, tableRowsClients);

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

    private List<WebElement> getEmployeeTableRows(List<WebElement> tableRows) {

        tableRows = tableRows.subList(1,tableRows.size());

        return tableRows;
    }

    private int getColumnNumber(String columnName, List<WebElement> headerCells) throws Exception {

        for (int i=0; i < headerCells.size(); i++) {

            WebElement currentWebElement = headerCells.get(i);

            String currentWebElementName = currentWebElement.getText();

            if (currentWebElementName.equals(columnName)) {

                return i;

            }
        }

        throw new Exception("Column name not found");
    }
}
