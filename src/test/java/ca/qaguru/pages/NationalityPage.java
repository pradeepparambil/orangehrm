package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class NationalityPage extends PageBase {

    public NationalityPage(WebDriver driver) {

        super(driver);
    }
    private String btnAdd ="//input[@id='btnAdd']";
    private String txtName ="//input[@id='nationality_name']";
    private String btnSave="//input[@id='btnSave']";
    private String lblNationality = "//*[text()='XXX']";
    private String Nationality;
    private String chkbox="//*[text()='YYY']//preceding::input[@type='checkbox'][1]";
    private String btnDelete="//input[@id='btnDelete']";
    private String confirmDelete="//input[@id='dialogDeleteBtn']";



    public NationalityPage addNationality(String nationality){
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName),nationality);
        click(By.xpath(btnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lblNationality.replace("XXX",nationality)))
                ,"Nationality not added");
        return this;
    }
    public void deleteNationality(String nationality){
        click(By.xpath(chkbox.replace("YYY",nationality)));
        click(By.xpath(btnDelete));
        click(By.xpath(confirmDelete));
       Assert.assertFalse( isElementVisible(By.xpath(lblNationality.replace("XXX",nationality)))
                ,"Nationality not deleted");
    }


}
