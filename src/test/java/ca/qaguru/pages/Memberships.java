package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class Memberships extends PageBase {
    public Memberships(WebDriver driver){
        super(driver);

    }
    private String btnAdd ="//input[@id='btnAdd']";
    private String txtName ="//input[@id='membership_name']";
    private String btnSave="//input[@id='btnSave']";
    private String lblMemberships= "//*[text()='XXX']";
    private String Membership = "B.com"+ UUID.randomUUID();
    private String chkbox="//*[text()='YYY']//preceding::input[@type='checkbox'][1]";
    private String btnDelete="//input[@id='btnDelete']";
    private String confirmDelete="//input[@id='dialogDeleteBtn']";
    //private String chkbox="//*[text()='YYY']//preceding::input[@type='checkbox'][1]";
    public void addMembership(){
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName),Membership);
        click(By.xpath(btnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lblMemberships.replace("XXX",Membership)))
                ,"Membership not Added");
    }
    public void deleteMembership(){
        addMembership();
        click(By.xpath(chkbox.replace("YYY",Membership)));
        click(By.xpath(btnDelete));
        click(By.xpath(confirmDelete));
        Assert.assertFalse( isElementVisible(By.xpath(lblMemberships.replace("XXX",Membership)))
                ,"Nationality not deleted");
    }
}
