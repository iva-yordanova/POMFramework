package oldway;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OldScript {
    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Thread.sleep(5000);//bad practice for wait
        driver.manage().window().maximize();//manage the window - maximize it
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
    }

    @Test
    public void loginTest() {

        driver.get("http://training.skillo-bg.com/"); //getting the url

        //WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        WebElement loginButton = driver.findElement(By.xpath("//a[@id='nav-link-login']")); //better approach to find an element
        loginButton.click();

        WebElement usernameOrEmailField = driver.findElement(By.xpath("//input[@id='defaultLoginFormUsername']"));
        usernameOrEmailField.sendKeys("test567");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='defaultLoginFormPassword']"));
        passwordField.sendKeys("test567");

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='sign-in-button']"));
        signInButton.click();
    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
