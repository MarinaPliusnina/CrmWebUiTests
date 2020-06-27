import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import pageObjects.Mentors;

public class MentorsTests extends BaseTest{

    private static Mentors mentors;

    @BeforeClass
    public static void beforeClass() {

        mentors = new Mentors();
        mainNavigation.navigateMentorsPage(driver);
    }

    @Test
    public void testNameColumnValues() throws Exception {

        // Act
        List<String> nameColumnValues = mentors.getColumnValues(driver,"name");

        // Assert
        List<String> nameColumnValuesExpected =  Arrays.asList("Charles Xavier", "James Howlett", "Scott Summers","Ororo Munroe","Test Test");
        Assert.assertEquals(nameColumnValuesExpected, nameColumnValues);
    }

    @Test
    public void testWorkloadColumnValues() throws Exception {

        // Act
        List<String> workloadColumnValues = mentors.getColumnValues(driver,"workload");

        // Assert
        List<String> workloadColumnValuesExpected =  Arrays.asList("2/20", "0/1", "1/3","1/10","0/2");
        Assert.assertEquals(workloadColumnValuesExpected, workloadColumnValues);
    }

    @Test
    public void testRowTotalNumber() {

        // Act
        int factRowCount = mentors.getRowCount(driver);
        int describedRowCount = mentors.getDescribedRowCount(driver);

        // Assert
        Assert.assertEquals(describedRowCount, factRowCount);
    }
}
