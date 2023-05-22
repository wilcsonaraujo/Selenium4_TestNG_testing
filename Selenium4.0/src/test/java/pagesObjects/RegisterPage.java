package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    String emailFilder = "//input[@id='Input_Email']";
    String passwordFilder = "//input[@id='Input_Password']";
    String confirmPasswordFilder = "//input[@id='Input_ConfirmPassword']";
    String registerbutton = "//button[normalize-space()='Register']";
}
