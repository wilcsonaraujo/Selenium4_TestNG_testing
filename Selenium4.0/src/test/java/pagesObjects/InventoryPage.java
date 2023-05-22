package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class InventoryPage {

    public static WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    String loginButton = "//a[normalize-space()='Login']";
    String basketButton = "//a[@class='esh-basketstatus']";
    String brandFilter = "//select[@id='CatalogModel_BrandFilterApplied']";
    String typeFilter = "//select[@id='CatalogModel_TypesFilterApplied']";
    String filterButton = "//input[@type='image']";
    String previousButton = "(//a[@id='Previous'])[1]";
    String nextButton = "(//a[@id='Next'])[1]";
    String basketButtonList = "(//input[@value='[ ADD TO BASKET ]'])";

    public void clickToLogin(){
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void clickToAddToBasket (){
        driver.findElement(By.xpath(basketButton)).click();
    }


}
