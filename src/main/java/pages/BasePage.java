package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;

/**
 * Parent page for common logic of all pages.
 * */
public class BasePage {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor executor;
    static public Date date = new Date();
    static public String currentDate = String.valueOf(date.getTime());
    static public String milliseconds = currentDate.substring(9, 13);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.executor = (JavascriptExecutor) driver ;
        PageFactory.initElements(driver, this);
    }
}
