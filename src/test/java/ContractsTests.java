import DataBase.DataBase;
import com.sun.tools.javac.util.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pageObjects.Contracts;
import testdata.NewClientTestData;

import java.util.List;
import java.util.Map;

public class ContractsTests extends BaseTest {

    private Contracts contracts;

    public ContractsTests() throws Exception {

        super();

        contracts = new Contracts(driver);
    }

    @Test
    public void clientsContractsTest() throws Exception {

        //Act

        String sQ =
                "select client.first_name,client.last_name, contract.contract_date\n" +
                        "from client\n" +
                        "inner join deal on client.id=deal.client_id\n" +
                        "inner join contract on deal.id=contract.deal_id\n" +
                        "Where contract.contract_date between '2020-05-31' and '2020-11-01'\n" +
                        "order by random()\n" +
                        "limit 1\n";

        super.runAndPrint(sQ);

    }
}