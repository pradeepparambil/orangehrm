package ca.qaguru.tests;

import org.testng.annotations.DataProvider;

public class  JobCategoriesTestData {

    @DataProvider(name = "getJobCategory")
    public Object[][] getJobCategory(){
        return new Object[][]{
                {"testdata/jobcategory/jobcategory.json"},
                {"testdata/jobcategory/jobcategory2.json"},
                {"testdata/jobcategory/jobcategory3.json"}
        };
    }
}
