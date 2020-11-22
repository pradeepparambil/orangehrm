package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class KPIpage extends PageBase {

    private String performancebutton = "//ul/li[7]/a[@id='menu__Performance']";
    private String configuredropbox = "//a[@id='menu_performance_Configure']";
    private String clickkpis = "//a[@id='menu_performance_searchKpi']";
    private String selectjobtitle = "//select[@id='kpi360SearchForm_jobTitleCode']";
    private String searchbutton = "//input[@id='searchBtn']";
    private String newjobtitle = "//option[@value='Head of Support']";
    private String buttonadd = "//input[@id='btnAdd']";
    private String txtKeyPerformanceIndicator = "//input[@id='defineKpi360_keyPerformanceIndicators']";
    private String txtMinRating = "//input[@id='defineKpi360_minRating']";
    private String txtMaxRating = "//input[@id='defineKpi360_maxRating']";
    private String clickdefaultscale = "//input[@id='defineKpi360_makeDefault']";
    private String clicksavebutton = "//input[@id='saveBtn']";
    private String checkbox = "//*[@id='ohrmList_chkSelectRecord_51']";
    private String deleteBtn = "//*[@id='btnDelete']";
    private String confirmDelete = "//*[@id='dialogDeleteBtn']";
    private String deleteSuccess = "//*[@class='message success fadable']";

    public KPIpage(WebDriver driver) {
        super(driver);
    }


    public void SearchJobTitles(String jobTitle) {
        select(By.xpath(selectjobtitle), jobTitle);
        click(By.xpath(searchbutton));
         //Assert.assertTrue("job title search failed", isElementVisible (By.xpath(newjobtitle)));
    }

    public void KpiAdd(String jobtitle, String keyperformanceindicator, String minimumrating, String maximumrating) {

        click(By.xpath(buttonadd));
        select(By.xpath(newjobtitle), jobtitle);
        setText(By.xpath(txtKeyPerformanceIndicator), keyperformanceindicator);
        setText(By.xpath(txtMaxRating), minimumrating);
        setText(By.xpath(txtMinRating), maximumrating);
        click(By.xpath(clickdefaultscale));
        click(By.xpath(clicksavebutton));

    }

    public void deleteKPI() {
        click(By.xpath(checkbox));
        click(By.xpath(deleteBtn));
        click(By.xpath(confirmDelete));
    }
}

