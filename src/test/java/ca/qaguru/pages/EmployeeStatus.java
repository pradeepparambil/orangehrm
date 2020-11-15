package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class EmployeeStatus extends PageBase {
    public EmployeeStatus(WebDriver driver) {
        super(driver);
    }
        private String btnAdd="//*[@name='btnAdd']";
        private String txtName="//*[@id='empStatus_name']";
        private String btnSave="//*[@id='btnSave']";
        private String fadingMsg = "//*[@class='message success fadable']";
        private String chkStatus="//*[@id='ohrmList_chkSelectRecord_3']";
        private String chkbox="//*[text()='YYY']//preceding::input[@type='checkbox'][1]";
        private String lblEmployeeStatus = "//*[text()='Employment Status']']";

    // private String chkStatus="//*[text()='Full-Time Contract']//parent::td[@class='left']//preceding-sibling::td//input[@id='ohrmList_chkSelectRecord_2']";
        private String btnDelete="//input[@id='btnDelete']";
        private String btnConfirmOk="//*[@id='dialogDeleteBtn']";
        String emp_Status = "Employee Status"+UUID.randomUUID();

    public void addStatus(String emp_Status){
            click(By.xpath(btnAdd));
            setText(By.xpath(txtName),emp_Status);
            click(By.xpath(btnSave));
            //String message = driver.findElement(By.tagName("script")).getText();

            //Assert.assertTrue(message.contains("Successfully saved"));
           Assert.assertTrue(isElementVisible(By.xpath(lblEmployeeStatus.replace("XXX",emp_Status)))
              ,"Nationality not added");
        }
        public void deleteStatus(){
                click(By.xpath(chkStatus));
                click(By.xpath(btnDelete));
                click(By.xpath(btnConfirmOk));
                Assert.assertTrue(isElementPresent(By.xpath(fadingMsg)),"Fading message not displayed");
            }
            }







