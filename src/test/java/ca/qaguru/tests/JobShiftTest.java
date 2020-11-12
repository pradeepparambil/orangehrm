package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.JobShiftPage;
import ca.qaguru.pages.LoginPage;
import org.testng.annotations.Test;

public class JobShiftTest extends TestBase {
    @Test
    public void addJobShift() {    // Adding job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.addJobShift("ShiftAW8", "09:15", "16:00", "Nathan Elliot", "Successfully Saved");
    }

    @Test
    public void addJobShiftCancel() {    // Cancelling job shift Add
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.addJobShiftCancel("ShiftAW3", "09:15", "16:00", "Charlie Carter");
    }

    @Test
    public void cancelDeleteShifts() {    // Cancel Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.cancelDeleteShifts("4");
    }

    @Test
    public void deleteShifts() {    // Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.addJobShift("ShiftAW4", "08:15", "16:00", "Cecil Bonaparte", "Successfully Saved");
        JSPage.deleteShifts("3","successfully Deleted");
    }

    @Test
    public void modifyJobShift() {    // Modifying job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.addJobShift("ShiftAWM1", "09:15", "16:00", "Linda Jane Anderson", "Successfully Saved");
        JSPage.modifyJobShift("ShiftAWM1","ShiftAWM2","08:30","16:30","Odis Adalwin");
    }
}
