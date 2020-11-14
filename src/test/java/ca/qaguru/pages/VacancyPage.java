package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VacancyPage extends PageBase {

    private String vacancyName = "//*[@id=\"resultTable\"]//descendant::*[contains(text(),'Vacancy')]";
    private String addBtn = "//*[@id='btnAdd']";
    private String selectJobTitle ="//*[@id='addJobVacancy_jobTitle']";
    private String addName = "//*[@id='addJobVacancy_name']";
    private String hiringMngr = "//*[@id='addJobVacancy_hiringManager']";
    private String descriptionBox = "//*[@id='addJobVacancy_description']";
    private String statusBtn = "//*[@id='addJobVacancy_status']";
    private String publishBtn = "//*[@id='addJobVacancy_publishedInFeed']";
    private String saveBtn = "//*[@id='btnSave']";
    private String fadingMsg = "//*[@class='message success fadable']";
    private String nameExistsErrMsg = "//span[@class='validation-error']";
    private String backBtn = "//*[@id='btnBack']";

    public VacancyPage(WebDriver driver) {
        super(driver);
    }

    public void reachVacancyPage(){
        new LoginPage(driver).login("admin", "admin123")
                .selectMenu("Recruitment|Vacancies");
    }

    public WebElement searchAllVacancies() {
        reachVacancyPage();
        return driver.findElement(By.xpath(vacancyName));
    }

    public void addNewVacancy(String jobTitle, String vacancyName, String hiringManager ){
        reachVacancyPage();
        driver.findElement(By.xpath(addBtn)).click();
        select(By.xpath(selectJobTitle),jobTitle);
        driver.findElement(By.xpath(addName)).sendKeys(vacancyName);
        driver.findElement(By.xpath(hiringMngr)).sendKeys(hiringManager);
        driver.findElement(By.xpath(descriptionBox)).sendKeys("Testing the description Box");
        driver.findElement(By.xpath(statusBtn)).isSelected();
        driver.findElement(By.xpath(publishBtn)).isSelected();
        driver.findElement(By.xpath(saveBtn)).click();
        Assert.assertTrue(isElementPresent(By.xpath(fadingMsg)),"Fading message not displayed");
    }

    public void addDuplicateVacancy(String jobTitle, String vacancyName, String hiringManager){

        addNewVacancy(jobTitle, vacancyName, hiringManager);
        driver.findElement(By.xpath(backBtn)).click();

        driver.findElement(By.xpath(addBtn)).click();
        select(By.xpath(selectJobTitle),jobTitle);
        driver.findElement(By.xpath(addName)).sendKeys(vacancyName);
        driver.findElement(By.xpath(hiringMngr)).sendKeys(hiringManager);
        driver.findElement(By.xpath(descriptionBox)).sendKeys("Testing the description Box");
        driver.findElement(By.xpath(statusBtn)).isSelected();
        driver.findElement(By.xpath(publishBtn)).isSelected();
        driver.findElement(By.xpath(saveBtn)).click();
        Assert.assertTrue(isElementPresent(By.xpath(nameExistsErrMsg)),"Error message was not displayed");
        String actual = driver.findElement(By.xpath(nameExistsErrMsg)).getText();
        String expected = "Already exists";
        Assert.assertEquals(actual, expected, "The Error message is different");

    }

}
