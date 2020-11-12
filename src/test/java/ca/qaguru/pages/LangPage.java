package ca.qaguru.pages;

import ca.qaguru.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LangPage extends PageBase {

    private String clickLang="a#menu_admin_viewLanguages";
    private String clickAdd ="input#btnAdd";
    private String addLang ="input#language_name";
    private String clickSave="input#btnSave";
    private String clickDelete ="[value='7' ] ";

    public void addLang(){
        click(By.cssSelector(clickLang));
        click(By.cssSelector(clickAdd));
        setText(By.cssSelector(addLang),"Polish");
        click(By.cssSelector(clickSave));
    }
    public void deleteLang(){
        click(By.cssSelector(clickLang));
        click(By.cssSelector(clickDelete));
    }
    public LangPage(WebDriver driver) {super(driver);

    }
}
