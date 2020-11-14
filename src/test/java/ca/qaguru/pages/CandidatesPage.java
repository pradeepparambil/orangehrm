package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.UUID;

public class CandidatesPage<name> extends PageBase {

    private String txtCandidateName ="//*[@id='candidateSearch_candidateName']";//New candidate page open
    private String searchBtn = "//*[@id='btnSrch']";
    private String addBtn = "//*[@id='btnAdd']";
    private String addCandidatePage ="//*[@id='addCandidateHeading']";
    private String addFirstName ="//*[@id='addCandidate_firstName']";
    private String addMiddleName ="//*[@id='addCandidate_middleName']";
    private String addLastName ="//*[@id='addCandidate_lastName']";
    private String addEmail ="//*[@id='addCandidate_email']";
    private String addContactNo ="//*[@id='addCandidate_contactNo']";
    private String selectJobVacancy ="//*[@id='addCandidate_vacancy']";
    private String uploadResume ="//*[@id='addCandidate_resume']";
    private String enterKeywords ="//*[@id='addCandidate_keyWords']";
    private String addComment ="//*[@id='addCandidate_comment']";
    private String addDOA ="//*[@id='addCandidate_appliedDate']"; //Date of application
    private String checkCTKD ="//*[@id='addCandidate_consentToKeepData']"; //Consent to keep data
    private String newCandidate ="//*[text()='Jo  Denton']"; // new candidate add confirmed
    private String successPage ="//*[@class='message success fadable']";
    private String checkbox="//*[@id='ohrmList_chkSelectRecord_26_3']";
    private String deleteBtn ="//*[@id='btnDelete']";
    private String confirmDelete ="//*[@id='dialogDeleteBtn']"; // Delete confirmation
    private String deleteSuccess ="//*[@class='message success fadable']";

    private String editBtn ="//*[@id='btnSave' and @value='Edit']";
    private String resetBtn ="//*[@id='btnRst']";
    private String backBtn ="//*[@id='btnBack' and @value='Back']";
    private String saveBtn ="//*[@id='btnSave' and @value ='Save']";
    private String cancelBtn ="//*[@id='btnBack' and @value ='Cancel']";





    public CandidatesPage(WebDriver driver) {
        super(driver);
    }
    public void candidateSearch (String candidateName){
        setText(By.xpath(txtCandidateName),candidateName);
        click(By.xpath(searchBtn));
        Assert.assertTrue(isElementVisible(By.xpath(newCandidate)),"Candidate search failed");

        }


    public void addCandidate(String firstname,String middlename,String lastname,String email,String contactno,String JV,String keywords,String comment){
        click(By.xpath(addBtn));
        Assert.assertTrue(isElementVisible(By.xpath(addCandidatePage)),"New candidate page not open");
        setText(By.xpath(addFirstName),firstname);
        setText(By.xpath(addMiddleName),middlename);
        setText(By.xpath(addLastName),lastname);
        setText(By.xpath(addEmail),email);
        setText(By.xpath(addContactNo),contactno);
        select(By.xpath(selectJobVacancy),JV);
//      fileUpload(By.xpath(uploadResume),fileName);
        setText(By.xpath(enterKeywords),keywords);
        setText(By.xpath(addComment),comment);
//      setText(By.xpath(addDOA),DoA);
        click(By.xpath(checkCTKD));
        click(By.xpath(saveBtn));
        Assert.assertTrue(isElementPresent(By.xpath(successPage)),"New candidate not added");

    }

    public void deleteCandidate(){
        click(By.xpath(checkbox));
        click(By.xpath(deleteBtn));
        click(By.xpath(confirmDelete));
        Assert.assertTrue(isElementVisible(By.xpath(deleteSuccess)),"Selected candidate not deleted");
    }





}
