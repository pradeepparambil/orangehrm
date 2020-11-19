package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobCategoriesPage extends PageBase {

    private String btnAdd ="//*[@id=\"btnAdd\"]";
    private String txtName ="//*[@id=\"jobCategory_name\"]";
    private String btnSave = "//*[@id=\"btnSave\"]";
    private String btnCancel ="//*[@id=\"btnCancel\"]";
    private String lblJobCategory = "//*[text()='XXX']";

    private String chkJobCategory ="//*[text()='XXX']//preceding::input[@type='checkbox'][1]";
    private String btnDelete = "//*[@id=\"btnDelete\"]";
    private String btnAlertOk ="//*[@id=\"dialogDeleteBtn\"]";

    public JobCategoriesPage(WebDriver driver){
        super(driver);
    }

    public JobCategoriesPage addJobCategory(String jobCategory) {
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName), jobCategory);
        click(By.xpath(btnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lblJobCategory.replace("XXX", jobCategory)))
                , "Job Category Not Added");
        return this;
    }

    public JobCategoriesPage delJobCategory(String jobCategory){

        click(By.xpath(chkJobCategory.replace("XXX", jobCategory)));
        click(By.xpath(btnDelete));
        click(By.xpath(btnAlertOk));
        Assert.assertFalse( isElementVisible(By.xpath(lblJobCategory.replace("XXX",jobCategory)))
                ,"Job Category not deleted");
        return this;
    }

    public JobCategoriesPage editJobCategory(String jobCategory, String newJobCategory){

    //    click(By.xpath(lblJobCategory.replace("XXX",jobCategory)));
    //    setText(By.xpath(txtName), jobCategory);
    //    click(By.xpath(btnSave));
    //    Assert.assertTrue(isElementVisible(By.xpath(lblJobCategory.replace("XXX",
    //            jobCategory)))
    //            ,"Job Category not added ");
        click(By.xpath(lblJobCategory.replace("XXX",jobCategory)));
        setText(By.xpath(txtName), newJobCategory);
        click(By.xpath(btnSave));
        Assert.assertFalse(isElementVisible(By.xpath(lblJobCategory.replace(jobCategory,
                newJobCategory))),"Job Category Not Edited");
        return this;

    }


}
