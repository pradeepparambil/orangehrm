package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddEmployeeStatus extends PageBase {
    public AddEmployeeStatus(WebDriver driver) {
        super(driver);
    }
    private String btnAdd="//*[@name='btnAdd']";
    private String txtName="//*[@id='empStatus_name']";
    private String btnSave="//*[@id='btnSave']";
    private String chkStatus="//*[text()='Full-Time Contract']//parent::td[@class='left']//preceding-sibling::td//input[@id='ohrmList_chkSelectRecord_3']";
    private String btnDelete="//input[@id='btnDelete']";
    private String btnOk="//*[@id='dialogDeleteBtn']";
    public void addStatus(String name){
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName),name);
        click(By.xpath(btnSave));
    }
    public void deleteStatus(){
        click(By.xpath(chkStatus));
        //if(chkStatus.equals(true)){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath(btnDelete));
        click(By.xpath(btnOk));
        //}
    }
}
