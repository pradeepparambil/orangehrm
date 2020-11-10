package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NationalityPage extends PageBase {

    public NationalityPage(WebDriver driver) {

        super(driver);
    }
    private String btnAdd ="//input[@id='btnAdd']";
    private String txtName ="//input[@id='nationality_name']";
    private String Nationality;


    public void addNationality(){
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName),"Country1");


    }


}
