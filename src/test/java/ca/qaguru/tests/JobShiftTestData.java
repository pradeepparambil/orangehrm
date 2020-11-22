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

    @DataProvider(name = "modDataFiles")
    public Object[][] jsmodifyfiles() {
        return new Object[][] {
                {"testdata/jobshifts/modify/jsmodify1.json"},
                {"testdata/jobshifts/modify/jsmodify2.json"},
                {"testdata/jobshifts/modify/jsmodify3.json"}
        };
    }
}
