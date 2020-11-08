package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddEmployeeStatus extends PageBase {
    public AddEmployeeStatus(WebDriver driver) {
        super(driver);
    }
    private String btnAdd="//*[@name='btnAdd']";
    private String txtName="//*[@id='empStatus_name']";
    private String btnSave="//*[@id='btnSave']";
    public void addStatus(String name){
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName),name);
        click(By.xpath(btnSave));
    }
}
