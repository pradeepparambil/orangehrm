package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class Education extends PageBase {
        public Education(WebDriver driver) {
            super(driver);

        }
        private String btnAdd ="//*[@id='btnAdd";
        private String txtName ="//*[@id='education_name'";
        private String btnSave="//*[@id='btnSave']";
        private String lblEducation= "//*[text()='XXX']";
        private String Education = "BBA"+ UUID.randomUUID();
        private String chkbox="//*[text()='YYY']//preceding::input[@type='checkbox'][1]";
        private String btnDelete="//*[@id='btnDel']";

        public void addEducation() {
            click(By.xpath(btnAdd));
            setText(By.xpath(txtName),Education);
            click(By.xpath(btnSave));
            Assert.assertTrue(isElementVisible(By.xpath(lblEducation.replace("XXX",Education)))
                    ,"Education is not added");
        }
        public void deleteEducation(){
            addEducation();
            click(By.xpath(chkbox.replace("YYY",Education)));
            click(By.xpath(btnDelete));
            Assert.assertFalse( isElementVisible(By.xpath(lblEducation.replace("XXX",Education)))
                    ,"Education not deleted");
        }
    }


