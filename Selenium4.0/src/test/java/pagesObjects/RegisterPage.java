package pagesObjects;

import org.openqa.selenium.By;
import runner.RunBase;

public class RegisterPage extends RunBase {

    String confirmPasswordFilder = "//input[@id='Input_ConfirmPassword']";
    String registerbutton = "//button[normalize-space()='Register']";

    public void inputConfirmPassword(String password) {
        driver.findElement(By.xpath(confirmPasswordFilder)).sendKeys(password);
    }

    public void clickToRegister() {
        driver.findElement(By.xpath(registerbutton)).click();
    }

}
