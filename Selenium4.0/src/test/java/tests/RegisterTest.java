package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.InventoryPage;
import pagesObjects.LoginPage;
import pagesObjects.RegisterPage;
import runner.RunBase;

public class RegisterTest extends RunBase {

    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();

    String email = "wilcsonaraujmg@hotmail.com";
    String password = "Aa*123123";

    @Test
    public void inputUserInfo() {
        inventoryPage.clickLoginButton();
        loginPage.clickToRegister();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);
        registerPage.clickToRegister();
        loginPage.verifyUserLogged(email);
    }
}
