package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.models.employeestatus.EmpStatusModel;
import ca.qaguru.models.nationality.NationalityModel;
import ca.qaguru.pages.EmployeeStatus;
import ca.qaguru.pages.LoginPage;
import ca.qaguru.pages.NationalityPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class EmployeeStatusTest extends TestBase {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test(dataProvider = "getEmployeeStatus", dataProviderClass = EmployeeStatusTestData.class)
    public void addEmployeeStatus(String resource) throws IOException {
        EmpStatusModel data = getEmployeeStatusData(resource);
        new LoginPage(driver)
                .login(data.getUser().getUsername(),
                        data.getUser().getPassword())
                .selectMenu("Admin|Job|Employment Status");

        new EmployeeStatus(driver).addStatus(data.getEmpStatus());

    }
    @Test(dataProvider = "getEmployeeStatus", dataProviderClass = EmployeeStatusTestData.class)
    public void deleteNationality(String resource) throws IOException {
        EmpStatusModel data = getEmployeeStatusData(resource);
        new LoginPage(driver)
                .login(data.getUser().getUsername(),
                        data.getUser().getPassword())
                .selectMenu("Admin|Job|Employment Status");

        new EmployeeStatus(driver)
                .addStatus(data.getEmpStatus())
                .deleteEmpStatus(data.getEmpStatus());
    }

    private EmpStatusModel getEmployeeStatusData(String resource) throws IOException {
        URL url = getClass()
                .getClassLoader()
                .getResource(resource);
        EmpStatusModel data = objectMapper
                .readValue(url,EmpStatusModel.class);
        data.setEmpStatus(data.getEmpStatus()+ UUID.randomUUID());
        return data;
    }

}