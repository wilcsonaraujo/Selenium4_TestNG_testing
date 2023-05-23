package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.InventoryPage;
import pagesObjects.LoginPage;
import runner.RunBase;

public class LoginTest extends RunBase {

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    InventoryPage inventoryPage = new InventoryPage();

    String email = "wilcsonaraujmg@hotmail.com";
    String password = "Aa*123123";

    @Test
    public void Login() {
        inventoryPage.clickLoginButton();
        loginPage.clickToLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        loginPage.verifyUserLogged(email);
    }

    @Test
    public void forgotPassword() {
        inventoryPage.clickLoginButton();
        loginPage.clickToLogin();
        loginPage.clickToForgotPassword();
        loginPage.inputEmail(email);
        loginPage.clickToSubmit();
        loginPage.verifyForgotPassword();
    }

}
