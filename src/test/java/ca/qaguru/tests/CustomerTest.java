package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.CandidatesPage;
import ca.qaguru.pages.CustomerPage;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class CustomerTest extends TestBase {

    @Test
    public void CustomerAdd()
{ new LoginPage(driver).login("Admin","admin123").selectMenu("Time|Project Info|Customers");
    CustomerPage customerpage = new CustomerPage(driver);
    customerpage.CustomerAdd("Vijay" + UUID.randomUUID(), "Electrical Engineer" + UUID.randomUUID());

}
    @Test
    public void CustomerDelete(){
        String customername= "Vijay" + UUID.randomUUID();
        String customerdescription= "Electrical Engineer" + UUID.randomUUID();
        new LoginPage(driver).login("Admin","admin123").selectMenu("Time|Project Info|Customers");
        CustomerPage customerpage =new CustomerPage(driver);
        customerpage.CustomerAdd (customername, customerdescription );
        customerpage.DeleteCustomer(customername);

    }

}
