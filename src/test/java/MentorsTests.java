import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebElement;
import pageObjects.Mentors;

public class MentorsTests extends BaseTest{

    private Mentors mentors;

    public MentorsTests() throws Exception {
        super();

        mentors = new Mentors(driver);
    }

    @Before
    public void before() {

        mainNavigation.navigateMentorsPage(driver);
    }

    @Test
    public void testNameColumnValues() throws Exception {

        // Act
        List<String> nameColumnValues = mentors.getColumnValues("name");

        // Assert
        List<String> nameColumnValuesExpected =  Arrays.asList("Charles Xavier", "James Howlett", "Scott Summers","Ororo Munroe","Test Test");
        Assert.assertEquals(nameColumnValuesExpected, nameColumnValues);
    }

    @Test
    public void testWorkloadColumnValues() throws Exception {

        // Act
        List<String> workloadColumnValues = mentors.getColumnValues("workload");

        // Assert
        List<String> workloadColumnValuesExpected =  Arrays.asList("2/20", "0/1", "1/3","1/10","0/2");
        Assert.assertEquals(workloadColumnValuesExpected, workloadColumnValues);
    }

    @Test
    public void testRowTotalNumber() throws Exception {

        // Act
        int factRowCount = mentors.getRowCount(driver);
        int describedRowCount = mentors.getDescribedRowCount(driver);

        // Assert
        Assert.assertEquals(describedRowCount, factRowCount);
    }

    @Test
    public void newMentorsCreation() throws Exception {

        mainNavigation.navigateMentorsPage(driver);

        //declare constants values (test data)
        String timestamp = Long.toString((new Date().getTime())/1000);

        String firstName = "Kira" +timestamp;

        String lastName = "Knightley" + timestamp;

        String maxClients = "5";

        //put first name,last name, max workload to text field
        mentors.createEmployee(firstName, lastName, maxClients);

        mentors.saveButtonPopUp();

        //"Go back" button click
        mentors.toMentorsPageButton();

        //filter by name
        mentors.filterByName(firstName);

        //navigate to the table
        List<String> vals = mentors.getColumnValues("name");

        //check if they are equal
       Assert.assertTrue(vals.contains(firstName + " " + lastName));

        //navigate to record
        List<WebElement> record = mentors.getColumnLinks("name");

        //delete record
        mentors.deleteService(record.get(0));

    }

}
