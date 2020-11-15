package ca.qaguru.tests;

import ca.qaguru.lib.TestBase;
import ca.qaguru.models.nationality.NationalityModel;
import ca.qaguru.pages.NationalityPage;
import ca.qaguru.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class NationalityTests extends TestBase {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test(dataProvider = "getNationalities", dataProviderClass = NationalityTestData.class)
    public void addNationality(String resource) throws IOException {
        NationalityModel natData = getNationalityData(resource);
        new LoginPage(driver)
                .login(natData.getUser().getUsername(),
                        natData.getUser().getPassword())
                .selectMenu("Admin|Nationalities");

        NationalityPage nationalityPage =new NationalityPage(driver);
                nationalityPage.addNationality(natData.getNationality());
    }
    @Test
    public void deleteNationality() throws IOException {
        NationalityModel natData = getNationalityData("testdata/nationality/nationality.json");

        new LoginPage(driver)
                .login(natData.getUser().getUsername(),
                        natData.getUser().getPassword())
                .selectMenu("Admin|Nationalities");
        new NationalityPage(driver)
                .addNationality(natData.getNationality())
                .deleteNationality(natData.getNationality());
    }

    private NationalityModel getNationalityData(String resource) throws IOException {
        URL url = getClass()
                .getClassLoader()
                .getResource(resource);
        NationalityModel natData = objectMapper
                .readValue(url,NationalityModel.class);
        natData.setNationality(natData.getNationality()+ UUID.randomUUID());
        return natData;
    }

}
