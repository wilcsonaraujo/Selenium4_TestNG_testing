package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import runner.RunBase;
import support.Utils;

import java.util.List;

public class InventoryPage extends RunBase {

    String loginButton = "//a[normalize-space()='Login']";
    String basketButton = "//a[@class='esh-basketstatus']";
    String brandFilter = "//select[@id='CatalogModel_BrandFilterApplied']";
    String typeFilter = "//select[@id='CatalogModel_TypesFilterApplied']";
    String filterButton = "//input[@type='image']";
    String previousButton = "(//a[@id='Previous'])[1]";
    String nextButton = "(//a[@id='Next'])[1]";
    String basketButtonList = "(//input[@value='[ ADD TO BASKET ]'])";
    String productsfilteredList = "//div[@class='esh-catalog-name']";
    String pageNumberLabel = "//article//span";
    String emptyFilteredLabel = "//div[@class='esh-catalog-items row']";

    public void clickLoginButton() {
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void clickToAddToBasket() {
        driver.findElement(By.xpath(basketButton)).click();
    }

    public void selectBrandFilter() {
        Select selectBrand = new Select(driver.findElement(By.xpath(brandFilter)));
        List<WebElement> optionList = selectBrand.getOptions();
        int random = Utils.getRandomNumber(optionList.size());
        selectBrand.selectByIndex(random);
    }

    public void selectTypeFilter() {
        Select selectBrand = new Select(driver.findElement(By.xpath(typeFilter)));
        List<WebElement> optionList = selectBrand.getOptions();
        int random = Utils.getRandomNumber(optionList.size());
        selectBrand.selectByIndex(random);
    }

    public void clickToFilter() {
        driver.findElement(By.xpath(filterButton)).click();
    }

    public void clickToNextPage() {
        driver.findElement(By.xpath(nextButton)).click();
    }

    public void clickToPreviousPage() {
        driver.findElement(By.xpath(previousButton)).click();
    }

    public void verifyFilterResult(String compare) {
        List<String> titleList = Utils.getList(productsfilteredList);
        Boolean actual = false;
        if (titleList.size() == 0) {
            String textEmpty = driver.findElement(By.xpath(emptyFilteredLabel)).getText();
            actual = textEmpty.contains(compare);
        } else {
            int quaintProducts = Utils.getList(productsfilteredList).size();
            String num = driver.findElement(By.xpath(pageNumberLabel)).getText().replaceAll("[\\D]", "");
            int showProduct = Integer.parseInt(String.valueOf(num.charAt(1)));
            if (quaintProducts == showProduct) {
                actual = true;
            }
        }
        Assert.assertEquals(actual, true);
    }

    public String checkProductsBrandFilters() {
        return checkProductsFilter(brandFilter);
    }

    public String checkProductsTypeFilters() {
        return checkProductsFilter(typeFilter);
    }

    public String checkProductsFilter(String locator) {
        int quantProductDisplayed = Utils.getList(productsfilteredList).size();
        if (quantProductDisplayed == 0) {
            return driver.findElement(By.xpath(emptyFilteredLabel)).getText();
        } else {
            return Utils.getSelectedOption(locator);
        }
    }

}
