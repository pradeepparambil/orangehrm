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
        JSPage.addJobShift("ShiftAW3", "09:15", "16:00", "Lisa Andrews", "Successfully Saved");
    }
//

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
}
