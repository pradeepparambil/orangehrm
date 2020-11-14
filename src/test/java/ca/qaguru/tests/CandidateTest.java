package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.CandidatesPage;
import ca.qaguru.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CandidateTest extends TestBase {
    @Test
    public void searchCandidate(){
        new LoginPage(driver).login("Admin","admin123").selectMenu("Recruitment|Candidates");
        CandidatesPage candidatesPage =new CandidatesPage(driver);
        candidatesPage.candidateSearch("Jo Denton");

    }
    @Test
    public void addNewCandidate() {
        new LoginPage(driver).login("Admin","admin123").selectMenu("Recruitment|Candidates");
        CandidatesPage candidatesPage =new CandidatesPage(driver);
        candidatesPage.addCandidate("Joe", "Mathew","George", "geroge@gmail.com","87663245699", "Payroll Administrator","abc","def");


    }
    @Test
    public void deleteCandidate(){
        new LoginPage(driver).login("Admin","admin123").selectMenu("Recruitment|Candidates");
        CandidatesPage candidatesPage =new CandidatesPage(driver);
        candidatesPage.deleteCandidate();

    }




}














//@Test
//    public void addJobShift() {    // Adding job shift
//        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
//        JobShiftPage JSPage = new JobShiftPage(driver);
//        JSPage.addBtnClick("ShiftAW3");
//        JSPage.selectDropdown("09:15", "16:00");
//        JSPage.SelectEmployee("Lisa Andrews");
//        JSPage.clickAddEmp();
//        JSPage.clickSave("Successfully Saved");
//    }