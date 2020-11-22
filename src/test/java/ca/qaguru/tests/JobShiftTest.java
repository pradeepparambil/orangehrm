package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.models.jobshifts.JSModel;
import ca.qaguru.pages.JobShiftPage;
import ca.qaguru.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class JobShiftTest extends TestBase {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test(dataProvider = "addDataFiles",dataProviderClass = JobShiftTestData.class)
    public void addJobShift(String fileResource) throws IOException {    // Adding job shift
        JSModel jsModel = readFunctionality(fileResource);
    }

//    @Test
//    public void cancelAddShifts() throws IOException {    // Cancelling job shift Add
//        URL url = getClass().getClassLoader().getResource("testdata/jobshifts/jshiftsaddcancel1.json");
//        JSModel jsmodel = objectMapper.readValue(url,JSModel.class);
//        new LoginPage(driver).login(jsmodel.getUser().getUsername(),jsmodel.getUser().getPassword()).selectMenu("Admin|Job|Work Shifts");
//        JobShiftPage JSPage = new JobShiftPage(driver);
//        JSPage.commonAdd(jsmodel.getShiftname(),
//                jsmodel.getAction(),
//                jsmodel.getFromtime(),
//                jsmodel.getTotime(),
//                jsmodel.getEmployee());
        //JSPage.commonAdd("ShiftA","addCancel","09:15", "16:00", "Charlie Carter");
//    }

//    @Test(dataProvider = "delDataFiles",dataProviderClass = JobShiftTestData.class)
//    public void cancelDeleteShifts() {    // Cancel Delete job shift
//        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
//        JobShiftPage JSPage = new JobShiftPage(driver);
//        JSPage.commonAdd("ShiftA","add","08:15", "16:00", "Dominic Chase");
//        JSPage.commonDelete("cancelDel", "ShiftA");
//    }

    @Test(dataProvider = "delDataFiles",dataProviderClass = JobShiftTestData.class)
    public void deleteShifts(String fileResource) throws IOException {    // Delete job shift
        JSModel jsModel = readFunctionality(fileResource);
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonDelete("delete",jsModel.getShiftname());
    }

  //  @Test(dataProvider = "modDataFiles",dataProviderClass =JobShiftTestData.class )
   @Test
    public void modifyJobShift() throws IOException {    // Modifying job shift
        JSModel jsModel = readFunctionality("testdata/jobshifts/modify/jsmodify1.json");
        JobShiftPage JSPage = new JobShiftPage(driver);
        jsModel.setModshiftname(jsModel.getModshiftname()+new Random().nextInt(10));
      //  System.out.println(jsModel.getShiftname() + " " + jsModel.getModshiftname());
     //   System.out.println();
        JSPage.modifyJobShift(jsModel.getShiftname(),
                              jsModel.getModshiftname(),
                              jsModel.getModfromtime(),
                              jsModel.getModtotime(),
                              jsModel.getModemployee());
    }

    public JSModel readFunctionality(String fileResource) throws IOException {
        URL url = getClass().getClassLoader().getResource(fileResource);
        JSModel jsModel = objectMapper.readValue(url,JSModel.class);
        jsModel.setShiftname(jsModel.getShiftname()+ new Random().nextInt(99999));
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
