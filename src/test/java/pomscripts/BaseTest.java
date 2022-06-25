package pomscripts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginModal;
import pages.SignUpModal;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LandingPage landingPage;
    LoginModal loginModal;
    HomePage homePage;
    SignUpModal signUpModal;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage = new LandingPage(driver);
        loginModal = new LoginModal(driver);
        homePage = new HomePage(driver);
        signUpModal = new SignUpModal(driver);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
