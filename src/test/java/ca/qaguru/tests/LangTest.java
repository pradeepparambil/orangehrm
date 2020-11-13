package ca.qaguru.tests;

import ca.qaguru.lib.PageBase;
import ca.qaguru.lib.TestBase;
import ca.qaguru.pages.LangPage;
import ca.qaguru.pages.LoginPage;
import ca.qaguru.pages.NationalityPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LangTest extends TestBase {
    @Test
    public void addLanguage(){
        new LoginPage(driver)
                .login("admin", "admin123")
                .selectMenu("Admin|Qualifications");
        LangPage langPage =new LangPage(driver);
        langPage.addLang();
    }
    @Test
    public void deleteLang(){
        new LoginPage(driver)
                .login("admin", "admin123")
                .selectMenu("Admin|Qualifications");
        LangPage langPage =new LangPage(driver);
        langPage.deleteLang();

    }







    }

