package pagesObjects;

import org.openqa.selenium.By;
import runner.RunBase;

public class InventoryLoggedPage extends RunBase {

    String myOrdersButton = "//div[normalize-space()='My orders']";
    String myAccountButton = "//div[normalize-space()='My account']";
    String logoutButton = "//div[normalize-space()='Log Out']";

    public void clickToLogout() {
        driver.findElement(By.xpath(logoutButton)).click();
    }

    public void clickToMyAccount() {
        driver.findElement(By.xpath(myAccountButton)).click();
    }

    public void clickToMyOrders() {
        driver.findElement(By.xpath(myOrdersButton)).click();
    }
}
