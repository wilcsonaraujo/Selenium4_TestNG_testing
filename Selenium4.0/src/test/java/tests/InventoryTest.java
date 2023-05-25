package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.BasketPage;
import pagesObjects.InventoryPage;
import runner.RunBase;

public class InventoryTest extends RunBase {
    static InventoryPage inventoryPage = PageFactory.initElements(driver, InventoryPage.class);

    BasketPage basketPage = new BasketPage();

    @Test
    public void filterByBrand() {
        inventoryPage.selectBrandFilter();
        inventoryPage.clickToFilter();
        inventoryPage.verifyFilterResult(inventoryPage.checkProductsBrandFilters());
    }

    @Test
    public void filterByType() {
        inventoryPage.selectTypeFilter();
        inventoryPage.clickToFilter();
        inventoryPage.verifyFilterResult(inventoryPage.checkProductsTypeFilters());
    }

    @Test
    public void addToBasket() {
        inventoryPage.addProductsToBasket();
        inventoryPage.clickOnBasket();
        basketPage.verifyQuantityInBasket();
    }
}
