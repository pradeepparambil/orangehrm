package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.KPIpage;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class KPItest extends TestBase {

@Test
public void SearchJobTitles()
{

    new LoginPage(driver).login("Admin","admin123");
    KPIpage kpiPage = new KPIpage(driver);
    kpiPage.SearchJobTitles("Head of Support");
}

@Test
    public void KpiAdd()
{
    new LoginPage(driver).login("Admin","admin123")
            .selectMenu("Performance|Configure|KPIs");
    KPIpage kpiPage = new KPIpage(driver);
    kpiPage.KpiAdd("Head of Support","kpitest", "0","100");

}
@Test
    public void KpiDelete()
{
    new LoginPage(driver).login("Admin","admin123");

    KPIpage kpidelete = new KPIpage(driver);
    kpidelete.deleteKPI();
}
}
