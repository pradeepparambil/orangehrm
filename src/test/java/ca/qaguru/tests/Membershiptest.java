package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.Memberships;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class Membershiptest extends TestBase {
    @Test
    public void addMembership(){
        new LoginPage(driver)
                .login("admin","admin123")
                .selectMenu("Admin|Qualifications|Memberships");
        new Memberships(driver)
                .addMembership();
    }
    @Test
    public void deleteMembership(){
        new LoginPage(driver)
                .login("admin","admin123")
                .selectMenu("Admin|Qualifications|Memberships");
        new Memberships(driver)
                .deleteMembership();

    }

}
