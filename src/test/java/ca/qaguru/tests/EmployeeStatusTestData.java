package ca.qaguru.tests;


import org.testng.annotations.DataProvider;

public class EmployeeStatusTestData {
    @DataProvider(name="getEmployeeStatus")
    public Object[][] getEmployeeStatus(){
        return new Object[][]{
               {"testdata.empStatus/empstatus.json"},
                {"testdata.empStatus/empstatus1.json"},
                {"testdata.empStatus/empstatus2.json"}
        };
    }
}
