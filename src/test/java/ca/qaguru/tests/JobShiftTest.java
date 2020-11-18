package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.models.jobshifts.JSModel;
import ca.qaguru.pages.JobShiftPage;
import ca.qaguru.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class JobShiftTest extends TestBase {

    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void addJobShift() throws IOException {    // Adding job shift
        URL url = getClass().getClassLoader().getResource("testdata/jobshifts/jobshifts1.json");
        JSModel jsModel = objectMapper.readValue(url,JSModel.class);
        new LoginPage(driver).login(jsModel.getUser().getUsername(),jsModel.getUser().getPassword()).selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add","09:15", "16:00", "Linda Jane Anderson");
    }

    @Test
    public void cancelAddShifts() {    // Cancelling job shift Add
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("addCancel","09:15", "16:00", "Charlie Carter");
    }

    @Test
    public void cancelDeleteShifts() {    // Cancel Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add","08:15", "16:00", "Dominic Chase");
        JSPage.commonDelete("cancelDel");
    }

    @Test
    public void deleteShifts() {    // Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add","08:15", "16:00", "Alice Duval");
        JSPage.commonDelete("delete");
    }

    @Test
    public void modifyJobShift() {    // Modifying job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add", "09:15", "16:00", "Russel Hamilton");
        JSPage.modifyJobShift("ShiftAWM2","08:30","16:30","Odis Adalwin");
    }
}
