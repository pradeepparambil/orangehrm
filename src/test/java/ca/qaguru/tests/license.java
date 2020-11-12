package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.LoginPage;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class license extends TestBase {

    @Test
    public void addCourse(){
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Qualifications");
         driver.findElement(By.id("menu_admin_viewLicenses")).click();
         driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
         driver.findElement(By.xpath("//input[@id='license_name']")).sendKeys("TESTING AUTOMATION");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    }


}
