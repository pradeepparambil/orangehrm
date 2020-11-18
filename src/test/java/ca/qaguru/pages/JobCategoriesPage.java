package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class JobCategoriesPage extends PageBase {

    private String btnAdd ="//*[@id=\"btnAdd\"]";
    private String txtName ="//*[@id=\"jobCategory_name\"]";
    private String btnSave = "//*[@id=\"btnSave\"]";
    private String btnCancel ="//*[@id=\"btnCancel\"]";
    private String lblJobCategory = "//*[text()='XXX']";

    private String chkBox ="//*[text()='XXX']//preceding::input[@type='checkbox'][1]";
    private String chkBoxSel = "//*[@id=\"ohrmList_chkSelectRecord_10\"]";
    private String btnDelete = "//*[@id=\"btnDelete\"]";
    private String btnAlertOk ="//*[@id=\"dialogDeleteBtn\"]";

    public JobCategoriesPage(WebDriver driver){
        super(driver);
    }

    public void addJobCategory(String jobCategory) {
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName), jobCategory);
        click(By.xpath(btnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lblJobCategory.replace("XXX", jobCategory)))
                , "Job Category Not Added");
    }

    public void delJobCategory(String jobCategory){

        click(By.xpath(chkBox.replace("YYY", jobCategory)));
        click(By.xpath(btnDelete));
        click(By.xpath(btnAlertOk));
        Assert.assertFalse( isElementVisible(By.xpath(lblJobCategory.replace("XXX",jobCategory)))
                ,"Job Category not deleted");

    }


}
