package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.NationalityPage;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class NationalityTests extends TestBase {
    @Test
    public void addNationality(){
        new LoginPage(driver)
                .login("admin", "admin123")
                .selectMenu("Admin|Nationalities");
        NationalityPage nationalityPage =new NationalityPage(driver);
                nationalityPage.addNationality();

    }
    @Test
    public void deleteNationality(){
        new LoginPage(driver)
                .login("admin", "admin123")
                .selectMenu("Admin|Nationalities");
        NationalityPage nationalityPage =new NationalityPage(driver);
        nationalityPage.deleteNationality();
    }

}
