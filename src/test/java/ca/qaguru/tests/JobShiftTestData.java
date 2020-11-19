package ca.qaguru.tests;

import org.testng.annotations.DataProvider;

public class JobShiftTestData {

    @DataProvider(name = "addDataFiles")
    public Object[][] jsaddfiles() {
        return new Object[][] {
                {"testdata/jobshifts/add/jsadd1.json"},
                {"testdata/jobshifts/add/jsadd2.json"},
                {"testdata/jobshifts/add/jsadd3.json"}
        };
    }

    @DataProvider(name = "delDataFiles")
    public Object[][] jsdeletefiles() {
        return new Object[][] {
                {"testdata/jobshifts/delete/jsdelete1.json"},
                {"testdata/jobshifts/delete/jsdelete1.json"},
                {"testdata/jobshifts/delete/jsdelete1.json"}
        };
    }
}
