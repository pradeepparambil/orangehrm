package ca.qaguru.tests;

import org.testng.annotations.DataProvider;

public class NationalityTestData {

    @DataProvider(name = "getNationalities")
    public Object[][] getNationalities(){
        return new Object[][]{
                {"testdata/nationality/nationality.json"},
                {"testdata/nationality/nationality2.json"},
                {"testdata/nationality/nationality3.json"}
        };
    }
}
