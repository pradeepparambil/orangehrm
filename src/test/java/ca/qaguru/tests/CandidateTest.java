package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.models.candidate.CandidateAddModel;
import ca.qaguru.models.candidate.CandidateEditModel;
import ca.qaguru.models.candidate.CandidateResetModel;
import ca.qaguru.models.candidate.CandidateSearchModel;
import ca.qaguru.pages.CandidatesPage;
import ca.qaguru.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class CandidateTest extends TestBase {

    @Test
    public void searchCandidate() throws IOException {


        CandidateSearchModel candidateData = getCandidateData("testdata/candidate/candidatesearch.json");
        new LoginPage(driver)
                .login(candidateData.getUser().getUsername(),
                        candidateData.getUser().getPassword())
                        .selectMenu("Recruitment|Candidates");

        CandidatesPage candidatesPage =new CandidatesPage(driver);


        candidatesPage.candidateSearch(candidateData.getCandidateNameXpath(),candidateData.getCandidateNameSearch());

    }
    @Test
    public void addNewCandidate() throws IOException {

        CandidateAddModel candidateAdd = getCandidateDataAdd("testdata/candidate/candidateadd.json");
        new LoginPage(driver)
                .login(candidateAdd.getUser().getUsername(),
                        candidateAdd.getUser().getPassword())
                .selectMenu("Recruitment|Candidates");

        CandidatesPage candidatesPage =new CandidatesPage(driver);

        candidatesPage.addCandidate(candidateAdd.getFirstname(),candidateAdd.getMiddlename(),candidateAdd.getLastname(),
                candidateAdd.getEmail(), candidateAdd.getContactno());

    }
    @Test
    public void deleteCandidate() throws IOException {

        CandidateAddModel candidateAdd = getCandidateDataAdd("testdata/candidate/candidateadd.json");
        new LoginPage(driver)
                .login(candidateAdd.getUser().getUsername(),
                        candidateAdd.getUser().getPassword())
                .selectMenu("Recruitment|Candidates");

        CandidatesPage candidatesPage =new CandidatesPage(driver);

        candidatesPage.addCandidate(candidateAdd.getFirstname(),candidateAdd.getMiddlename(),candidateAdd.getLastname(),
                candidateAdd.getEmail(), candidateAdd.getContactno());
        candidatesPage = new CandidatesPage(driver);

        candidatesPage.deleteCandidate(candidateAdd.getCandidatename());


    }
    @Test
    public void resetButton() throws IOException {

        CandidateResetModel candidateReset = getCandidateResetData("testdata/candidate/candidatereset.json");
        new LoginPage(driver)
                .login(candidateReset.getUser().getUsername(),
                        candidateReset.getUser().getPassword())
                .selectMenu("Recruitment|Candidates");

        CandidatesPage candidatesPage =new CandidatesPage(driver);
        candidatesPage.resetBtn(candidateReset.getCandidateName());


    }
    @Test
    public void editButton() throws IOException {

        CandidateEditModel candidateEdit = getCandidateEditData("testdata/candidate/candidateedit.json");
        new LoginPage(driver)
                .login(candidateEdit.getUser().getUsername(),
                        candidateEdit.getUser().getPassword())
                .selectMenu("Recruitment|Candidates");

        CandidatesPage candidatesPage =new CandidatesPage(driver);
        candidatesPage.editCandidate(candidateEdit.getCandidate(),candidateEdit.getCorrectmailid()+ UUID.randomUUID());

    }




    private CandidateSearchModel getCandidateData(String resource) throws IOException {

            ObjectMapper objectMapper =new ObjectMapper();

            URL url = getClass()
                    .getClassLoader()
                    .getResource(resource);
            CandidateSearchModel candidateData = objectMapper.readValue(url, CandidateSearchModel.class);

              return candidateData;

    }

    private CandidateAddModel getCandidateDataAdd(String resource) throws IOException {

        ObjectMapper objectMapper =new ObjectMapper();

        URL url = getClass()
                .getClassLoader()
                .getResource(resource);
        CandidateAddModel candidateData = objectMapper.readValue(url, CandidateAddModel.class);
  //      candidateData.setFirstname(candidateData.getFirstname()+ UUID.randomUUID());

        return candidateData;

    }

    private CandidateResetModel getCandidateResetData(String resource) throws IOException {

        ObjectMapper objectMapper =new ObjectMapper();
        URL url =getClass().getClassLoader().getResource(resource);
        CandidateResetModel candidateData = objectMapper.readValue(url,CandidateResetModel.class);
        return candidateData;
    }
    private CandidateEditModel getCandidateEditData(String resource) throws IOException {
        ObjectMapper objectMapper =new ObjectMapper();
        URL url = getClass()
                .getClassLoader()
                .getResource(resource);
        CandidateEditModel candidateData = objectMapper.readValue(url,CandidateEditModel.class);
        return candidateData;
    }

}














