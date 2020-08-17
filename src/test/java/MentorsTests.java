import java.sql.SQLException;
import java.util.List;

import DataBase.DataBase;
import testdata.NewMentorTestData;
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

        NewMentorTestData mentorTestData = NewMentorTestData.createNewMentorTestData();

        mentors.createEmployee(mentorTestData);

        mentors.saveButtonPopUp();

        mentors.toMentorsPageButton();

        mentors.filterByName(mentorTestData.getFirstName());

        List<String> vals = mentors.getColumnValues("name");

       Assert.assertTrue(vals.contains(mentorTestData.getFullName()));

        List<WebElement> record = mentors.getColumnLinks("name");

        mentors.deleteService(record.get(0));
    }

    @Test
    public void clientsContractsTest() throws Exception {

        //Act

        String sQ =
                "select employee.first_name,employee.last_name\n" +
                        "from employee\n" +
                        "Where employee.max_clients>10\n" +
                        "Order by Random()\n" +
                        "Limit 1";

        super.runAndPrint(sQ);

    }



}
