package pagesObjects;

import runner.RunBase;

public class BasketPage extends RunBase {

    String costLabel = "";
    String totalLabel = "//section[@class='esh-basket-item esh-basket-item--mark col-xs-2']";
    String quantityLabel = "(//input[@name='Items[%s].Value'])[1]";
    String continueButton = "(//a[normalize-space()='[ Continue Shopping..]'])";
    String updateButton = "(//button[normalize-space()='[ Update ]'])";
    String checkoutButton = "(//input[@name='action'])";

}
