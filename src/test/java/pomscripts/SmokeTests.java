package pomscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class SmokeTests extends BaseTest {


    @Test
    public void createAccount() {
        driver.get("http://training.skillo-bg.com/");
        landingPage.clickLoginButton();
        loginModal.clickRegisterButton();
        signUpModal.registerUser();
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());
    }

    @Test
    public void logoutTest() {
        loginTest();
        //driver.navigate().refresh();
        homePage.clickLogOut();
        Assert.assertEquals(driver.getCurrentUrl(), "http://training.skillo-bg.com/users/login");
    }

    @Test(retryAnalyzer = utils.Retry.class)
    public void loginTest() {
        driver.get("http://training.skillo-bg.com/");
        landingPage.clickLoginButton();
        loginModal.enterUsername("test567");
        loginModal.enterPassword("test567");
        loginModal.clickSignInButton();
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());
    }

    //it doesn't work. Can't interact with the input. The other way is with Browse and AutoIt/Sikuli
   /* @Test
    public void addPublicPost() throws FindFailed {
        loginTest();
        homePage.clickNewPostButton();
        Assert.assertEquals(driver.getCurrentUrl(),"http://training.skillo-bg.com/posts/create");
        createPostModal.uploadFile();
        createPostModal.clickCreatePostButton();
    }*/


    @Test (groups="LikePost")
    public void likePrivatePost() {
        loginTest();
        homePage.clickProfileButton();
        profilePage.filterPrivatePosts();
        profilePage.openFirstPost();
        postModal.clickHeartIcon();
        Assert.assertTrue(postModal.isPostLiked());
    }

    @Test (dependsOnGroups ="LikePost" )
    public void undoLikedPost() {
        loginTest();
        homePage.clickProfileButton();
        profilePage.filterPrivatePosts();
        profilePage.openFirstPost();
        postModal.undoLikedPost();
        Assert.assertTrue(postModal.isPostLiked());
    }

    @Test
    public void addNewComment() {
        loginTest();
        homePage.clickProfileButton();
        profilePage.filterPrivatePosts();
        profilePage.openFirstPost();
        postModal.enterNewComment();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='comment-list-container']//div[@class='col-12 comment-content']")));
        Assert.assertEquals(postModal.getTheLastComment(), postModal.text);
    }


    //The assert for the alert fails everytime
    @Test
    public void deletePost() {
        loginTest();
        homePage.clickProfileButton();
        profilePage.filterPrivatePosts();
        profilePage.openLastPost();

        if (profilePage.userPosts.size() > 1) {
            postModal.deletePost();
            Assert.assertTrue(postModal.isAlertDisplayed());

        } else {
            //profilePage.openLastPost();
            postModal.discardDeletePost();
            Assert.assertEquals(profilePage.userPosts.size(), 1);
        }
    }

    @Test
    public void editProfileInfo() {
        loginTest();
        homePage.clickProfileButton();
        profilePage.editProfileInfo();
        driver.navigate().refresh();
        Assert.assertEquals(profilePage.getProfileInfo(), profilePage.info);
    }


}
