package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagesObjects.InventoryPage;
import runner.TestBase;

public class InventoryTest extends TestBase {

    @Test
   public static void test(){
        InventoryPage inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
        inventoryPage.clickToLogin();
    }
}
