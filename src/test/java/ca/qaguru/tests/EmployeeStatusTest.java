package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.EmployeeStatus;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class EmployeeStatusTest extends TestBase {
    @Test
    public void addEmployeeStatus(){
            new LoginPage(driver)
                    .login("Admin","admin123")
                    .selectMenu("Admin|Job|Employment Status");
            new EmployeeStatus(driver)
                    .addStatus("adsds");

        }
        @Test
        public void deleteEmploymentStatus(){
            new LoginPage(driver)
                    .login("Admin","admin123")
                    .selectMenu("Admin|Job|Employment Status");
            new EmployeeStatus(driver).addStatus("dsddf");
            new EmployeeStatus(driver)
                    .deleteStatus();


        }

    }

