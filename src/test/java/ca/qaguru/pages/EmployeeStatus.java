package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.sql.SQLOutput;
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
        private String lblStatus = "//*[text()='XXX']";
        private String chkStatus="//*[@id='ohrmList_chkSelectRecord_3']";
        //private String chkbox="//*[text()='YYY']//preceding::input[@type='checkbox'][1]";

       // private String chkStatus="//*[text()='Full-Time Contract']//parent::td[@class='left']//preceding-sibling::td//input[@id='ohrmList_chkSelectRecord_2']";
        private String btnDelete="//input[@id='btnDelete']";
        private String btnConfirmOk="//*[@id='dialogDeleteBtn']";
        protected  String emp_Status;
        public void addStatus(String name){
            click(By.xpath(btnAdd));
            emp_Status = "Employee Status"+ UUID.randomUUID();
            setText(By.xpath(txtName),name);
            click(By.xpath(btnSave));
            Assert.assertTrue(isElementPresent(By.xpath(fadingMsg)),"Fading message not displayed");
        }
        public void deleteStatus(){
                click(By.xpath(chkStatus));
                click(By.xpath(btnDelete));
                click(By.xpath(btnConfirmOk));
                Assert.assertTrue(isElementPresent(By.xpath(fadingMsg)),"Fading message not displayed");
            }
            }







