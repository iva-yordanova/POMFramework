package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The landing page is opened after the URL is hit
 * example for path: Landing page --> HomePage --> NewPostPage
 */
public class LandingPage extends BasePage{

    //constructor
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    //By loginButton= By.id("nav-link-login");

    @FindBy(id="nav-link-login")
    WebElement loginButton;

    //Methods
    public void clickLoginButton(){
        loginButton.click();
    }



}
