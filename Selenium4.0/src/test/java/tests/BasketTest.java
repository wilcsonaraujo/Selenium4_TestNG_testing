package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.BasketPage;
import pagesObjects.LoginPage;
import runner.RunBase;

public class BasketTest extends RunBase {

    BasketPage basketPage = PageFactory.initElements(driver, BasketPage.class);


    @Test
    public void quantityOfProducts() {

    }

    @Test
    public void valueCorrectCost(){

    }

    @Test
    public void valueCorrectTotal(){

    }

    @Test
    public void goBackToContinueShopping(){

    }

    @Test
    public void uploadNewQuantity(){

    }

    @Test
    public void removeProduct(){

    }

}
