package pomscripts;
import org.testng.Assert;
import org.testng.annotations.*;
public class SmokeTests extends BaseTest {

    @Test(retryAnalyzer = utils.Retry.class)
    public void loginTest() {
        driver.get("http://training.skillo-bg.com/");
        landingPage.clickLoginButton();
        loginModal.enterUsername("test567");
        loginModal.enterPassword("test567");
        loginModal.clickSignInButton();
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());
    }

    @Test
    public void createAccount(){
        driver.get("http://training.skillo-bg.com/");
        landingPage.clickLoginButton();
        loginModal.clickRegisterButton();
        signUpModal.registerUser();
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());
    }

    @Test
    public void likePost(){
        loginTest();
        //TODO Like post test logic after login
        logoutTest();
    }

    @Test
    public void logoutTest(){
        driver.navigate().refresh();
        //TODO implement logout from all places
        //TODO click the home button
        //TODO click the logout button



    }
}
