package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitlePage extends PageBase {

    public JobTitlePage (WebDriver driver) {

        super (driver);
    }


        private String clickJobTitles = "//a[@id='menu_admin_viewJobTitleList']";
        private String clickAdd = "//input[@id='btnAdd']";
        private String clickDelete = "//input[@id='btnDelete']";
        private String addJobTitle = "//input[@id='jobTitle_jobTitle']";
        private String jobDescription = "//textarea[@id='jobTitle_jobDescription']";
        //private String clickJobSpecification = "//input[@id='jobTitle_jobSpec']";
        private String note = "//textarea[@id='jobTitle_note']";
        private String clickSave = "//input[@id='btnSave']";
        private String clickCancel = "//input[@id='btnCancel']";


        private String checkBoxSel = "//input[@id='ohrmList_chkSelectRecord_2']";
        private String delJobTitle= "//input[@id='btnDelete'] ";
//        private String buttonAlertOk ="//input[@id='btnDelete']";





        public void addJobTitle() {
            click(By.xpath(clickJobTitles));
            click(By.xpath(clickAdd));
            setText(By.xpath(addJobTitle), "Marketing Manager");
            setText(By.xpath(jobDescription), "2-3 years experience");
            //click(By.xpath(clickJobSpecification));
            setText(By.xpath(note), "Applications to be sent by Dec 1, 2020");
            click(By.xpath(clickSave));

}

        public void delJobTitle(){
            click(By.xpath(clickJobTitles));
            click(By.xpath(checkBoxSel));
            click(By.xpath(delJobTitle));
//            click(By.xpath(buttonAlertOk));

                    }


      }