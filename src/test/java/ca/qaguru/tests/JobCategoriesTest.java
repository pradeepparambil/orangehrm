package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.JobCategoriesPage;
import ca.qaguru.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.UUID;

public class JobCategoriesTest extends TestBase {

    @Test
    public void addJobCategory(){
        new LoginPage(driver)
                .login("Admin", "admin123")
                .selectMenu("Admin|Job|Job Categories");
        JobCategoriesPage JCPage = new JobCategoriesPage(driver);
        JCPage.addJobCategory("JC"+ UUID.randomUUID());

    }

    @Test
    public void delJobCategory(){
        new LoginPage(driver)
                .login("Admin", "admin123")
                .selectMenu("Admin|Job|Job Categories");
        JobCategoriesPage JCPage = new JobCategoriesPage(driver);
        JCPage.delJobCategory("JC");

    }

}
