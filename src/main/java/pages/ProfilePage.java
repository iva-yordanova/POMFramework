package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;


public class ProfilePage extends BasePage {
    public String info;

    public ProfilePage(WebDriver driver) {

        super(driver);
    }

    public List<WebElement> userPosts = driver.findElements(By.xpath("//div[@class='row no-gutters']//div[@class='gallery-item']"));

    /*@FindBy(xpath = "//app-post-list//div/app-post[1]")
    WebElement firstPost;
*/
    @FindBy(xpath = "//label[@class='btn-private btn btn-primary']")
    WebElement privateButton;

    @FindBy(xpath = "//i[@class='fas fa-user-edit ng-star-inserted']")
    WebElement editProfileButton;

    @FindBy(xpath = "//textarea[@formcontrolname='publicInfo']")
    WebElement publicInfoField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveButton;

    @FindBy(xpath = "//p[text()]")
    WebElement savedProfileInfo;

    public void openFirstPost() {
        userPosts = driver.findElements(By.xpath("//div[@class='row no-gutters']//div[@class='gallery-item']"));
        userPosts.get(0).click();
    }

    public void filterPrivatePosts() {
        privateButton.click();
    }

    public void openLastPost() {
        userPosts = driver.findElements(By.xpath("//div[@class='row no-gutters']//div[@class='gallery-item']"));
        Collections.reverse(userPosts);
        userPosts.get(0).click();
    }

    public void editProfileInfo() {
        info = "This is my profile info" + milliseconds;
        editProfileButton.click();
        publicInfoField.clear();
        publicInfoField.sendKeys(info);
        saveButton.click();
    }

    public String getProfileInfo() {
        return savedProfileInfo.getText().substring(9, 36);
    }

}
