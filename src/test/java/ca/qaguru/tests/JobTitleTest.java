package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.JobTitlePage;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class JobTitleTest extends TestBase {


        @Test
        public void addJobTitle(){
            new LoginPage(driver)
                    .login("admin", "admin123")
                    .selectMenu("Admin|Job");
            JobTitlePage jobTitlePage = new JobTitlePage(driver);
            jobTitlePage.addJobTitle();
        }

        @Test
        public void delete(){
            new LoginPage(driver)
                    .login("admin", "admin123")
                    .selectMenu("Admin|Job");
            JobTitlePage jobTitlePage = new JobTitlePage(driver);
            jobTitlePage.delJobTitle();

        }


   }

