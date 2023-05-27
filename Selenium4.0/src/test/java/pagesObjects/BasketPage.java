package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import runner.RunBase;
import support.Utils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends RunBase {

    String costLabel = "//section//descendant::input[2]//ancestor::article/descendant::section[5]";
    String priceLabel = "//section/descendant::input[2]/ancestor::article//descendant::section[3]";
    String totalLabel = "//section[text()='Total']//parent::article/following-sibling::article/section[2]";
    String quantityLabel = "//article[@class='esh-basket-items row']//section[4]/descendant::input[2]";
    String continueButton = "//div[@class='row']//a[@href='/']";
    String updateButton = "//button[@name='updatebutton']";
    String checkoutButton = "//input[@value='[ Checkout ]']";
    String basketQuantityIcon = "//section//a[@class='esh-basketstatus']//descendant::div[2]";
    List<Integer> quantityList;
    List<Double> costList;
    List<Double> priceList;

    public void clickOnContinueShopping(){
        driver.findElement(By.xpath(continueButton)).sendKeys(Keys.ENTER);
    }

    public void clickOnUpdate(){
        driver.findElement(By.xpath(updateButton)).click();
    }

    public void clickOnCheckout(){
        driver.findElement(By.xpath(checkoutButton)).click();
    }

    public List<Double> getCost(){
        return Utils.getListText(costLabel);
    }

    public List<Double> getPrice(){
        return Utils.getListText(priceLabel);
    }

    public List<String> getQuantity(){
        return Utils.getListAttribute(quantityLabel);
    }

    public String getTotal(){
        return driver.findElement(By.xpath(totalLabel)).getText();
    }

    public String getQuantityBasketIcon(){
        return driver.findElement(By.xpath(basketQuantityIcon)).getText();
    }

    public void verifyQuantityInBasket() {
        int expected = Integer.parseInt(getQuantityBasketIcon());
        quantityList = getQuantity().stream().map(Integer::parseInt).collect(Collectors.toList());
        int actual = quantityList.stream().mapToInt(Integer::valueOf).sum();
        Assert.assertEquals(actual, expected);
    }

    public void verifyCostValue(){
        priceList = getPrice();
        quantityList = getQuantity().stream().map(Integer::parseInt).collect(Collectors.toList());
        costList = getCost();
        Double value;
        for(int i = 0; i < priceList.size(); i++){
            value = quantityList.get(i).intValue() * priceList.get(i).doubleValue();
            if(quantityList.get(i).intValue() >= 3){
                value = value - priceList.get(i).doubleValue();
            }
            Assert.assertEquals(value, costList.get(i).doubleValue());
        }
    }

    public void verifyTotalValue(){
        Double expected = Double.valueOf(getTotal().replace("$ ", ""));
        costList = getCost();
        Double actual = costList.stream().mapToDouble(Double::valueOf).sum();
        Assert.assertEquals(actual, expected);
    }

    public void updateQuantity(int newQuantity){
        quantityList = getQuantity().stream().map(Integer::parseInt).collect(Collectors.toList());
        int a = Utils.getRandomNumber(getQuantity().size());
        driver.findElement(By.xpath("("+quantityLabel+")["+a+"]")).clear();
        driver.findElement(By.xpath("("+quantityLabel+")["+a+"]")).sendKeys(String.valueOf(newQuantity));
    }

}
