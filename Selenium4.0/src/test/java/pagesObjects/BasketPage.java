package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasketPage {
    public WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    String costLabel = "";
    String totalLabel = "//section[@class='esh-basket-item esh-basket-item--mark col-xs-2']";
    String quantityLabel = "(//input[@name='Items[%s].Value'])[1]";
    String continueButton = "(//a[normalize-space()='[ Continue Shopping..]'])";
    String updateButton = "(//button[normalize-space()='[ Update ]'])";
    String checkoutButton = "(//input[@name='action'])";

}
