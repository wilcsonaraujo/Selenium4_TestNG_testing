package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    String emailFilder = "//input[@id='Input_Email']";
    String passwordFilder = "//input[@id='Input_Password']";
    String rememberMeButton = "//label[normalize-space()='Remember me?']";
    String LoginButton = "//button[normalize-space()='Log in']";
    String forgotPasswordButton = "//a[normalize-space()='Forgot your password?']";
    String registerButton = "//a[normalize-space()='Register as a new user']";
}
