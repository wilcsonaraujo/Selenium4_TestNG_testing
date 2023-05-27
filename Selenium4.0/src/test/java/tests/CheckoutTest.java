package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.BasketPage;
import pagesObjects.CheckoutPage;
import pagesObjects.InventoryPage;
import pagesObjects.LoginPage;
import runner.RunBase;

public class CheckoutTest extends RunBase {

    CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    BasketPage basketPage = new BasketPage();
    String email = "wilcsonaraujmg@hotmail.com";
    String password = "Aa*123123";

    @Test
    public void checkoutPayment(){
        inventoryPage.clickLoginButton();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickToLogin();
        inventoryPage.addProductsToBasket();
        inventoryPage.clickOnBasket();
        basketPage.clickOnCheckout();
        checkoutPage.inputStreet("2536, W Jackson BLVD.");
        checkoutPage.inputCity("Chicago");
        checkoutPage.inputState("Illinois");
        checkoutPage.inputCountry("USA");
        checkoutPage.inputZipCode("60604");
        checkoutPage.inputBrand();
        checkoutPage.inputCardNumber("5544086331423054");
        checkoutPage.inputCardHolderName("Jane Doe");
        checkoutPage.inputExperationMonth(04);
        checkoutPage.inputExperationYear(2031);
        checkoutPage.inputCVC(452);
        checkoutPage.clickCompleteCheckout();
    }
}
