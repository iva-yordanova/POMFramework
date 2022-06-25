package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModal extends BasePage{

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    By usernameOrEmailField = By.id("defaultLoginFormUsername");
    By passwordField = By.id("defaultLoginFormPassword");
    By signInButton= By.id("sign-in-button");
    By registerButton= By.linkText("Register");

    public void enterUsername(String username) {
        driver.findElement(usernameOrEmailField).clear();
        driver.findElement(usernameOrEmailField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {

        driver.findElement(signInButton).click();
    }

    public void commonLoginMethod(){
        enterUsername("test567");
        enterPassword("test567");
        clickSignInButton();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
