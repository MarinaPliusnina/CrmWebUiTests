import DataBase.DataBase;
import org.junit.Test;
import pageObjects.Deals;

public class DealsTests extends BaseTest {

    private Deals deals;

    public DealsTests() throws Exception {

        super();

        deals = new Deals(driver);
    }

    @Test
    public void activeDealsClientsTest() throws Exception {

        //Act

        String sQ =
        "select client.id as id, client.first_name, client.last_name, deal.id as deal_id, deal.status\n" +
                "from client \n" +
                "Left join deal on deal.client_id=client.id\n" +
                "Where deal.status='ACTIVE'\n" +
                "Order by Random()\n" +
                "Limit 1";

        super.runAndPrint(sQ);

    }
}
