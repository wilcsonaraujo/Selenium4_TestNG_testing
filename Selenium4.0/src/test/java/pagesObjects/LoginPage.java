package pagesObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import runner.RunBase;

public class LoginPage extends RunBase {

    String emailField = "//input[@id='Input_Email']";
    String passwordField = "//input[@id='Input_Password']";
    String loginButton = "//button[normalize-space()='Log in']";
    String forgotPasswordButton = "//a[normalize-space()='Forgot your password?']";
    String registerButton = "//a[normalize-space()='Register as a new user']";
    String userEmailLogged = "//div[@class='esh-identity-name']";
    String resetPasswordMessage = "//p";
    String submitButton = "//button[normalize-space()='Submit']";

    public void inputEmail(String email) {
        driver.findElement(By.xpath(emailField)).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
    }

    public void clickToLogin() {
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void clickToForgotPassword() {
        driver.findElement(By.xpath(forgotPasswordButton)).click();
    }

    public void clickToRegister() {
        driver.findElement(By.xpath(registerButton)).click();
    }

    public void verifyUserLogged(String user) {
        String actual = driver.findElement(By.xpath(userEmailLogged)).getText();
        Assert.assertEquals(actual, user);
    }

    public void clickToSubmit() {
        driver.findElement(By.xpath(submitButton)).click();
    }

    public void verifyForgotPassword() {
        String actual = driver.findElement(By.xpath(resetPasswordMessage)).getText();
        Assert.assertEquals(actual, "Please check your email to reset your password.");
    }
}
