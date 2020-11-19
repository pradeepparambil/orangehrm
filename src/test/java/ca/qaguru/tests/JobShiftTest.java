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

    @Test(dataProvider = "addDataFiles",dataProviderClass = JobShiftTestData.class)
    public void addJobShift(String fileResource) throws IOException {    // Adding job shift
        JSModel jsModel = commonFunctionality(fileResource);
    }

    @Test
    public void cancelAddShifts() throws IOException {    // Cancelling job shift Add
        URL url = getClass().getClassLoader().getResource("testdata/jobshifts/jshiftsaddcancel1.json");
        JSModel jsmodel = objectMapper.readValue(url,JSModel.class);
        new LoginPage(driver).login(jsmodel.getUser().getUsername(),jsmodel.getUser().getPassword()).selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsmodel.getShiftname(),
                jsmodel.getAction(),
                jsmodel.getFromtime(),
                jsmodel.getTotime(),
                jsmodel.getEmployee());
        //JSPage.commonAdd("ShiftA","addCancel","09:15", "16:00", "Charlie Carter");
    }

    @Test
    public void cancelDeleteShifts() {    // Cancel Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("ShiftA","add","08:15", "16:00", "Dominic Chase");
        JSPage.commonDelete("cancelDel");
    }

    @Test
    public void deleteShifts() throws IOException {    // Delete job shift
        URL url = getClass().getClassLoader().getResource("testdata/jobshifts/delete/jsdelete1.json");
        JSModel jsModel = objectMapper.readValue(url,JSModel.class);
        new LoginPage(driver).login(jsModel.getUser().getUsername(),
                                    jsModel.getUser().getPassword()).selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),jsModel.getAction(),jsModel.getFromtime(),jsModel.getTotime(),jsModel.getEmployee());
        JSPage.commonDelete("delete");
    }

    @Test
    public void modifyJobShift() {    // Modifying job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("ShiftA","add", "09:15", "16:00", "Russel Hamilton");
        JSPage.modifyJobShift("ShiftAWM2","08:30","16:30","Odis Adalwin");
    }

    public JSModel commonFunctionality(String fileResource) throws IOException {
        URL url = getClass().getClassLoader().getResource(fileResource);
        JSModel jsModel = objectMapper.readValue(url,JSModel.class);
        new LoginPage(driver).login(jsModel.getUser().getUsername(),jsModel.getUser().getPassword()).selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),
                jsModel.getAction(),
                jsModel.getFromtime(),
                jsModel.getTotime(),
                jsModel.getEmployee());
        return jsModel;
    }
}
