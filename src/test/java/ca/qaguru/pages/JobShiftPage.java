package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

public class JobShiftPage extends PageBase {
    private String btnAdd = "//*[@id='btnAdd']";
    private String btnDelete = "//*[@id='btnDelete']";
    private String chkCommon = "//*[@id='ohrmList_chkSelectAll']";
    private String txtShift = "//*[@id='workShift_name']";    // Job_Shift_Name TextBox
    private String selWSFrom = "//*[@id='workShift_workHours_from']"; // WrokShift From
    private String selWSTo = "//*[@id='workShift_workHours_to']"; // WorkShift To
    private String selAvlEmp = "//*[@id='workShift_availableEmp']"; // Available employee
    private String selAssignEmp = "//*[@id='workShift_assignedEmp'] "; // Assigned employee
    private String clkAdd = "//*[@id='btnAssignEmployee']";  // Add employee
    private String clkRemove = "//*[@id='btnRemoveEmployee']"; // Remove employee
    private String btnSave = "//*[@id='btnSave']";       // SAVE button
    private String btnCancel = "//*[@id='btnCancel']";    // Cancel button
    private String workShift = "//*[@id='search-results']//following::*[text()='Work Shifts']";
    private String recTable = "//*[@id='resultTable']//following::*[text()='XXX']";  // records in table
    private String selRecord = "//*[@checkbox']//following::*[@value='X']";
    private String actualAlertMsg = "//*[@id='customerList']//following::*[text()='Delete records?']";
    private String btnAlertOK = "//*[@id='customerList']//following::*[@value='Ok']";
    private String btnAlertCancel = "//*[@id='customerList']//following::*[@value='Cancel']";
    private String msgSuccess = "//*[@id='successBodyEdit']";
    private String msgDelete = "//*[@id='successBodyDelete']";
    private String editShift = "//*[@id='resultTable']//following::*[text()='XXX']";
    private String ShiftName1;

    public JobShiftPage(WebDriver driver) {
        super(driver);
    }

    Random rand = new Random();
    int upperbound = 5;

    public void commonAdd(String action,String FromTime, String ToTime,String EmpName){
        click(By.xpath(btnAdd));
        this.ShiftName1 = "SHA"+ rand.nextInt(upperbound);
        setText(By.xpath(txtShift), ShiftName1);
        //   selectDropdown(FromTime,ToTime);
        select(By.xpath(selWSFrom), FromTime);
        select(By.xpath(selWSTo), ToTime);
        select(By.xpath(selAvlEmp), EmpName);  //  SelectEmployee(EmpName);
        click(By.xpath(clkAdd));           // clickAddEmp();

        switch (action){
            case "add":
            {
                click(By.xpath(btnSave));  // clickSave(msgExp);
                Assert.assertTrue(isElementVisible(By.xpath(recTable.replace("XXX",ShiftName1)))
                        ,"Record not added");
                break;
            }
            case "addCancel":{
                click(By.xpath(btnCancel));                    //clickCancel;
                //Check is "work Shifts" is visible
                Assert.assertFalse(isElementVisible(By.xpath(recTable.replace("XXX",ShiftName1)))
                        ,"Record added");
                break;
            }
        }
    }

    public void deleteShifts(String Record, String msg){
        // selCheckBox;
        click(By.xpath(selRecord.replace("X", Record)));
        // clickDeleteBtn;
        click(By.xpath(btnDelete));
        click(By.xpath(btnAlertOK));
        // check message successfully deleted
        //  Assert.assertEquals(By.xpath(msgDelete),expDeleteMsg,"Record not Deleted");

    }

    public void cancelDeleteShifts(String Record){
        click(By.xpath(selRecord.replace("X", Record)));  //  selCheckBox;
        click(By.xpath(btnDelete));          // clickCancelDeleteBtn;
        click(By.xpath(btnAlertCancel));
    }

    public void modifyJobShift(String newShift,String FromTime, String ToTime,String EmpName){
        click(By.xpath(editShift.replace("XXX",ShiftName1)));   // click the selected shift
        setText(By.xpath(txtShift), newShift);
        select(By.xpath(selWSFrom), FromTime);          //   selectDropdown(FromTime,ToTime);
        select(By.xpath(selWSTo), ToTime);
        select(By.xpath(selAvlEmp), EmpName);
        click(By.xpath(clkAdd));
        click(By.xpath(btnSave));

    }

}
