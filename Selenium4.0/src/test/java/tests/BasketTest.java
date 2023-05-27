package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.BasketPage;
import pagesObjects.InventoryPage;
import pagesObjects.LoginPage;
import runner.RunBase;

public class BasketTest extends RunBase {

    BasketPage basketPage = PageFactory.initElements(driver, BasketPage.class);
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    String email = "wilcsonaraujmg@hotmail.com";
    String password = "Aa*123123";

    @Test
    public void quantityOfProducts() {
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.clickOnBasket();
        basketPage.verifyQuantityInBasket();
        basketPage.verifyCostValue();
        basketPage.verifyTotalValue();
    }

    @Test
    public void valueCorrectCost(){
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.clickOnBasket();
        basketPage.verifyCostValue();
    }

    @Test
    public void valueCorrectTotal(){
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.clickOnBasket();
        basketPage.verifyTotalValue();
    }

    @Test
    public void goBackToContinueShopping(){
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.clickOnBasket();
        basketPage.clickOnContinueShopping();
        loginPage.verifyUserLogged(email);
    }

    @Test
    public void uploadNewQuantity(){
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.clickOnBasket();
        basketPage.updateQuantity(2);
        basketPage.clickOnUpdate();
        basketPage.verifyQuantityInBasket();
    }

    @Test
    public void removeProduct(){
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.clickOnBasket();
        basketPage.updateQuantity(0);
        basketPage.clickOnUpdate();
        basketPage.verifyQuantityInBasket();
    }

}
