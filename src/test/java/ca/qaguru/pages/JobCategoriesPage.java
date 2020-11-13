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
    private String btnDelete = "//*[@id=\"btnDelete\"]";
    private String chkBoxSel ="//*[@id=\"ohrmList_chkSelectRecord_10\"]";
    private String chkBoxSelAll ="//*[@id=\"ohrmList_chkSelectAll\"]";
    private String btnAlertOk ="//*[@id=\"dialogDeleteBtn\"]";
    private String btnAlertCancel ="//*[@id=\"deleteConfModal\"]/div[3]/input[2]";

    public JobCategoriesPage(WebDriver driver){
        super(driver);
    }

    public void addJobCategory(String JobCategory){
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName),JobCategory);
        click(By.xpath(btnSave));
    }

    public void clickSave(){
        click(By.xpath(btnSave));
    }


    public void deleteJobCategory(String JobCategory){
        click(By.xpath(chkBoxSel));
        click(By.xpath(btnDelete));
        click(By.xpath(btnAlertOk));
    }

}
