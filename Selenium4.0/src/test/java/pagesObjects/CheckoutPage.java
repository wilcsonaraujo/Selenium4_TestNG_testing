package pagesObjects;

import org.openqa.selenium.By;
import runner.RunBase;

public class CheckoutPage extends RunBase {
    By streetField = By.id("ShippingAddress_Street");
    By cityField = By.id("ShippingAddress_City");
    By stateField = By.id("ShippingAddress_State");
    By countryField = By.id("ShippingAddress_Country");
    By zipCodeField = By.id("ShippingAddress_ZipCode");
    By brandField = By.id("PaymentDetails_Brand");
    By cardNumberField = By.id("PaymentDetails_CardNumber");
    By cardHolderNameField = By.id("PaymentDetails_CardHolderName");
    By experationMonthField = By.id("PaymentDetails_ExperationMonth");
    By experationYearField = By.id("PaymentDetails_ExperationYear");
    By cvcField = By.id("PaymentDetails_CVC");
    String completePurchaseButton = "//button[normalize-space()='[ Complete Purchase ]']";
    String checkoutDetailsTitle = "//h1[normalize-space()='Checkout Details']";
    String backToShoppingButton = "//form[@novalidate='novalidate']//following::a[@href='/']";


    public void inputStreet(String street){
        driver.findElement(streetField).sendKeys(street);
    }
    public void inputCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void inputState(String state){
        driver.findElement(stateField).sendKeys(state);
    }
    public void inputCountry(String country){
        driver.findElement(countryField).sendKeys(country);
    }
    public void inputZipCode(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }
    public void inputBrand(){

    }
    public void inputCardNumber(String cardNumber){
        driver.findElement(cardNumberField).sendKeys(cardNumber);
    }
    public void inputCardHolderName(String cardHolderName){
        driver.findElement(cardHolderNameField).sendKeys(cardHolderName);
    }
    public void inputExperationMonth(int month){
        driver.findElement(experationMonthField).sendKeys(String.valueOf(month));
    }
    public void inputExperationYear(int year){
        driver.findElement(experationYearField).sendKeys(String.valueOf(year));
    }
    public void inputCVC(int cvc){
        driver.findElement(cvcField).sendKeys(String.valueOf(cvc));
    }

    public void clickCompleteCheckout(){
        driver.findElement(By.xpath(completePurchaseButton)).click();
    }

    public void clickBackToShopping(){
        driver.findElement(By.xpath(backToShoppingButton)).click();
    }
}
