package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Collections;
import java.util.List;


public class PostModal extends BasePage {
    public String text;

    public PostModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[@class='like far fa-heart fa-2x']")
    WebElement heartIconDefault;

    @FindBy(xpath = "//i[@class='like far fa-heart fa-2x liked']")
    WebElement heartIconFilled;

    @FindBy(xpath = "//input[@placeholder='Comment here']")
    WebElement commentInput;

    @FindBy(xpath = "//a[text()='Delete post']")
    WebElement deletePostButton;

    @FindBy(xpath = "//button[text()='Yes']")
    WebElement confirmPostDeletionButton;

    @FindBy(xpath = "//button[text()='No']")
    WebElement declinePostDeletionButton;

    @FindBy(xpath="//div[@aria-label='Post Deleted']")
    WebElement alertDeletePostSuccess;


    List<WebElement> commentsList = driver.findElements(By.xpath("//div[@class='comment-list-container']//div[@class='col-12 comment-content']"));


    public void clickHeartIcon() {
        heartIconDefault.click();
    }

    public boolean isPostLiked() {
        return heartIconFilled.isDisplayed();

    }

    public void undoLikedPost() {
        heartIconFilled.click();
    }

    public void enterNewComment() {
        text = "Done" + milliseconds;
        commentInput.clear();
        commentInput.sendKeys(text);
        commentInput.sendKeys(Keys.ENTER);
    }

    public String getTheLastComment(){
        commentsList = driver.findElements(By.xpath("//div[@class='comment-list-container']//div[@class='col-12 comment-content']"));
        Collections.reverse(commentsList);
        return commentsList.get(0).getText();
    }

    public void deletePost() {
        deletePostButton.click();
        confirmPostDeletionButton.click();
    }

    public void discardDeletePost(){
        deletePostButton.click();
        declinePostDeletionButton.click();
    }

    public boolean isAlertDisplayed(){
        return alertDeletePostSuccess.isDisplayed();
    }

}
