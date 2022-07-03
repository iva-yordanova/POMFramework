package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators using PageFactory
    @FindBy(id="nav-link-new-post")
    WebElement newPostButton;

    @FindBy(xpath="//*[contains(@class,'sign-out')]")
    WebElement logOutButton;

    @FindBy(id="nav-link-profile")
    WebElement profileButton;

    //Interaction Methods

    //Assertion Methods - boolean, string
    public boolean isNewPostButtonDisplayed(){
        return newPostButton.isDisplayed();
    }

    public void clickNewPostButton(){
        newPostButton.click();
    }

    public void clickLogOut(){
        logOutButton.click();
    }

    public void clickProfileButton(){
        profileButton.click();
    }


}
