package pomscripts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utils.Screenshot;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LandingPage landingPage;
    LoginModal loginModal;
    HomePage homePage;
    SignUpModal signUpModal;
    //CreatePostModal createPostModal;
    ProfilePage profilePage;
    PostModal postModal;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        landingPage = new LandingPage(driver);
        loginModal = new LoginModal(driver);
        homePage = new HomePage(driver);
        signUpModal = new SignUpModal(driver);
        //createPostModal = new CreatePostModal(driver);
        profilePage = new ProfilePage(driver);
        postModal = new PostModal(driver);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "screenshots", result.getName());
        }
        driver.quit();
    }
}
