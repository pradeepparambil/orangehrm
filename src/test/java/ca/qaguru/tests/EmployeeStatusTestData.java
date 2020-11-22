package ca.qaguru.tests;

import org.testng.annotations.DataProvider;

public class EmployeeStatusTestData {
    @DataProvider(name="getEmployeeStatus")
        public Object[][] getEmployeeStatus(){
            return new Object[][]{
                    {"testdata/employeestatus/empstatus.json"},
                    {"testdata/employeestatus/empstatus1.json"},
                    {"testdata/employeestatus/empstatus2.json"}
            };
        }
    }


