package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.Education;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class EducationTest extends TestBase {
    @Test
    public void addEducation(){
        new LoginPage(driver)
                .login("admin","admin123")
                .selectMenu("Admin||Qualifications|Education");
        new Education(driver).addEducation();
    }
    @Test
    public void deleteEducation(){
        new LoginPage(driver)
                .login("admin","admin123")
                .selectMenu("Admin||Qualifications|Education");
        new Education(driver).deleteEducation();}

}
