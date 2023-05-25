package pagesObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import runner.RunBase;
import support.Utils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends RunBase {

    String costLabel = "//article[@class='esh-basket-items row']//section[5]";
    String totalLabel = "//section[@class='esh-basket-item esh-basket-item--mark col-xs-2']";
    String priceLabel = "//article[@class='esh-basket-items row']//section[3]";
    String quantityLabel = "//div//article[@class='esh-basket-items row']//section[4]/descendant::input[2]";
    String continueButton = "//a[@class='btn esh-basket-checkout text-white']";
    String updateButton = "//button[@name='updatebutton']";
    String checkoutButton = "//input[@value='[ Checkout ]']";
    String basketQuantityIcon = "//div[@class='esh-basketstatus-badge']";
    List<Integer> quantityList;
    List<Integer> costList;
    List<Integer> priceList;

    public void clickOnContinueshopping(){
        driver.findElement(By.xpath(continueButton)).click();
    }

    public void clickOnUpdate(){
        driver.findElement(By.xpath(updateButton)).click();
    }

    public void clickOnCheckout(){
        driver.findElement(By.xpath(checkoutButton)).click();
    }

    public List<String> getCost(){
        return Utils.getList(String.valueOf(By.xpath(costLabel)).replaceAll("$", ""));
    }

    public List<String> getPrice(){
        return Utils.getList(String.valueOf(By.xpath(priceLabel)).replaceAll("$", ""));
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

    public void verifyTotalValue(){
        int expected = Integer.parseInt(getTotal().replaceAll("$", ""));
        costList = getCost().stream().map(Integer::parseInt).collect(Collectors.toList());
        int actual = costList.stream().mapToInt(Integer::valueOf).sum();
        Assert.assertEquals(actual, expected);
    }

    public void verifyCostValue(){
        priceList = getPrice().stream().map(Integer::parseInt).collect(Collectors.toList());
        quantityList = getQuantity().stream().map(Integer::parseInt).collect(Collectors.toList());
        costList = getCost().stream().map(Integer::parseInt).collect(Collectors.toList());
        int value = 0;
        for(int i = 0; i <= priceList.size(); i++){
            value = quantityList.get(i).intValue() * priceList.get(i).intValue();
            Assert.assertEquals(value, costList.get(i).intValue());
        }
    }

    public void updateQuantity(int newQuantity){
        quantityList = getQuantity().stream().map(Integer::parseInt).collect(Collectors.toList());
        int a = Utils.getRandomNumber(getQuantity().size());
        driver.findElement(By.xpath(("("+quantityLabel+")["+a+"]"))).sendKeys(String.valueOf(newQuantity));
    }

}
