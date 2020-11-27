package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.models.jobcategory.JCModel;
import ca.qaguru.pages.JobCategoriesPage;
import ca.qaguru.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class JobCategoriesTest extends TestBase {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test(dataProvider = "getJobCategory", dataProviderClass = JobCategoriesTestData.class)
    public void addJobCategory(String resource) throws IOException {

        JCModel jcData = getJCData(resource);

        new LoginPage(driver)
                .login(jcData.getUser().getUsername()
                        , jcData.getUser().getPassword())
                .selectMenu("Admin|Job|Job Categories");

        JobCategoriesPage JCPage = new JobCategoriesPage(driver);
        JCPage.addJobCategory(jcData.getJobCategory());

    }

    @Test
    public void delJobCategory() throws IOException {

        JCModel jcData = getJCData("testdata/jobcategory/jobcategory.json");

        new LoginPage(driver)
                .login(jcData.getUser().getUsername()
                ,jcData.getUser().getPassword())
                .selectMenu("Admin|Job|Job Categories");
        new JobCategoriesPage(driver)
        .addJobCategory(jcData.getJobCategory())
        .delJobCategory(jcData.getJobCategory());
    }

    private JCModel getJCData(String resource) throws IOException {
        URL url = getClass()
                .getClassLoader()
                .getResource(resource);
        JCModel jcData = objectMapper.readValue(url,JCModel.class);
        jcData.setJobCategory(jcData.getJobCategory()+ UUID.randomUUID());
        return jcData;
    }


    @Test
    public void editJobCategory() {
        String jobCategory = "JC" + UUID.randomUUID();
        String newJobCategory = "nJC" +UUID.randomUUID();
        new LoginPage(driver)
                .login("Admin", "admin123")
                .selectMenu("Admin|Job|Job Categories");
        new JobCategoriesPage(driver)
                .addJobCategory(jobCategory)
                .editJobCategory(jobCategory,newJobCategory);
    }

}
