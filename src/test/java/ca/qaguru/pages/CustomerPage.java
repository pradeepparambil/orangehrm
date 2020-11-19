package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage extends PageBase {
    private String btnadd = "//input[@id='btnAdd']";
    private String addcustomername = "//input[@id='addCustomer_customerName']";
    private String addcustomerdescription = "//textarea[@id='addCustomer_description']";
    private String btnsave = "//*[@id=\"btnSave\"]";
    private String successpage = "//*[@class='message success fadable']";
    private String checkbox = "//*[@id='ohrmList_chkSelectRecord_7']";
    private String btndelete = "//*[@id='btnDelete']";
    private String confirmDelete = "//*[@id='dialogDeleteBtn']";
    private String deleteSuccess ="//*[@class='message success fadable']";
    private String chkCustomer ="//*[text()='abc']//preceding::input[@type='checkbox'][1]";
    private String lblcustomer = "//*[text()='abc']";

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void CustomerAdd(String customername, String customerdescription) {
        click(By.xpath(btnadd));
        setText(By.xpath(addcustomername), customername);
        setText(By.xpath(addcustomerdescription), customerdescription);
        click(By.xpath(btnsave));
        Assert.assertTrue(isElementPresent(By.xpath(successpage)), "new customer not added");
    }

    public void DeleteCustomer(String customername) {
        click(By.xpath(chkCustomer.replace("abc", customername)));
        click(By.xpath(btndelete));
        click(By.xpath(confirmDelete));
        Assert.assertFalse( isElementVisible(By.xpath(lblcustomer.replace("abc",customername)))
                ,"Job Category not deleted");
    }
}
