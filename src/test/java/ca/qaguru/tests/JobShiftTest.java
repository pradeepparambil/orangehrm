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
    public void addJobShift(String fileResource) throws IOException {
        JSModel jsModel = readFunctionality(fileResource);
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),
                jsModel.getFromtime(),
                jsModel.getTotime(),
                jsModel.getEmployee(),
                jsModel.getAction());// Adding job shift
    }

    @Test(dataProvider = "addDataFiles",dataProviderClass = JobShiftTestData.class)
    public void cancelAddShifts(String fileResource) throws IOException {    // Cancelling job shift Add
        JSModel jsModel = readFunctionality(fileResource);
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),
                         jsModel.getFromtime(),
                         jsModel.getTotime(),
                         jsModel.getCanceladdemployee(),
                         jsModel.getCanceladdaction());
    }



    @Test(dataProvider = "delDataFiles",dataProviderClass = JobShiftTestData.class)
    public void deleteShifts(String fileResource) throws IOException {    // Delete job shift
        JSModel jsModel = readFunctionality(fileResource);      // Adding job shift
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),
                jsModel.getFromtime(),
                jsModel.getTotime(),
                jsModel.getEmployee(),
                jsModel.getAction());
        JSPage.commonDelete(jsModel.getShiftname(),"delete");
    }

    @Test(dataProvider = "delDataFiles",dataProviderClass = JobShiftTestData.class)
    public void cancelDeleteShifts(String fileResource) throws IOException {    // Cancel Delete job shift
        JSModel jsModel = readFunctionality(fileResource);      // Adding job shift
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),
                jsModel.getFromtime(),
                jsModel.getTotime(),
                jsModel.getDelcancelemployee(),
                jsModel.getAction());
        JSPage.commonDelete(jsModel.getShiftname(),"cancelDel");
    }

    @Test(dataProvider = "addDataFiles",dataProviderClass = JobShiftTestData.class)
    public void modifyJobShift(String fileResource) throws IOException {    // Modifying job shift
       JSModel jsModel = readFunctionality(fileResource);
       JobShiftPage JSPage = new JobShiftPage(driver);
       JSPage.commonAdd(jsModel.getShiftname(),       // Adding job shift
                       jsModel.getFromtime(),
                       jsModel.getTotime(),
                       jsModel.getModaddemployee(),
                       jsModel.getAction());
        jsModel.setModshiftname(jsModel.getModshiftname()+new Random().nextInt(10));
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
        return jsModel;
    }
}
