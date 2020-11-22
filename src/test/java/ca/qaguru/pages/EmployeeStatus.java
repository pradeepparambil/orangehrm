package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class EmployeeStatus extends PageBase {
    public EmployeeStatus(WebDriver driver) {
        super(driver);
    }

    private String btnAdd = "//*[@name='btnAdd']";
    private String txtName = "//*[@id='empStatus_name']";
    private String btnSave = "//*[@id='btnSave']";
    private String fadingMsg = "//*[@class='message success fadable']";
    private String lblStatus = "//*[text()='XXX']";
    private String chkStatus = "//*[text()='YYY']//parent::td[@class='left']//preceding-sibling::td//input[@type='checkbox']";
    private String btnDelete = "//input[@id='btnDelete']";
    private String btnConfirmOk = "//*[@id='dialogDeleteBtn']";
    protected String emp_Status;

    public EmployeeStatus addStatus(String empStatus) {
        click(By.xpath(btnAdd));
        setText(By.xpath(txtName), empStatus);
        click(By.xpath(btnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lblStatus.replace("XXX", empStatus)))
                , "Employee Status not added");
        return this;
    }

    public EmployeeStatus deleteEmpStatus(String empStatus) {
        click(By.xpath(chkStatus.replace("YYY", empStatus)));
        click(By.xpath(btnDelete));
        click(By.xpath(btnConfirmOk));

        Assert.assertFalse(isElementVisible(By.xpath(lblStatus.replace("XXX", empStatus)))
                , "Employee Status not deleted");
        return this;
    }
}






