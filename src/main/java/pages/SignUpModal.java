package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUpModal extends BasePage {


    public SignUpModal(WebDriver driver) {
        super(driver);
    }

    //Locators using PageFactory
    @FindBy(xpath = "//input[@formcontrolname='username']")
    static
    WebElement usernameField;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(id = "sign-in-button")
    WebElement signUpButton;



    //Interaction Methods

    public void inputUserName() {
        usernameField.sendKeys("test" + milliseconds);
    }

    public void inputEmail() {
        emailField.sendKeys("test" + milliseconds + "@gmail.com");
    }

    public void inputPassword() {
        passwordField.sendKeys("test" + milliseconds);
    }

    public void inputConfirmPassword() {
        confirmPasswordField.sendKeys("test" + milliseconds);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void registerUser() {
        inputUserName();
        inputEmail();
        inputPassword();
        inputConfirmPassword();
        clickSignUpButton();
    }


}
