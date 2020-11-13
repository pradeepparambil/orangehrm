package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.AddEmployeeStatus;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class EmploymentStatusTest extends TestBase {
    @Test(priority = 1)
    public void addEmploymentStatus(){
        new LoginPage(driver)
                .login("Admin","admin123")
                .selectMenu("Admin|Job|Employment Status");
        new AddEmployeeStatus(driver)
                .addStatus("Full-Time Internship");

    }
    @Test(priority = 2)
    public void deleteEmploymentStatus(){
        new LoginPage(driver)
                .login("Admin","admin123")
                .selectMenu("Admin|Job|Employment Status");
        new AddEmployeeStatus(driver)
                .deleteStatus();

    }
}
