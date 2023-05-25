package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils extends RunBase {
    public static Integer getRandomNumber(int size) {
        Random random = new Random();
        int num = random.nextInt(size);
        if (num == 0) {
            return 1;
        } else {
            return num;
        }
    }

    public static List<String> getList(String location) {
        List<String> elements = new ArrayList<>();
        List<WebElement> data = driver.findElements(By.xpath(location));
        for (WebElement e : data) {
            elements.add(e.getText());
        }
        return elements;
    }

    public static String getSelectedOption(String location) {
        WebElement selectOpt = driver.findElement(By.xpath(location));
        Select select = new Select(selectOpt);
        WebElement visibleOption = select.getFirstSelectedOption();
        return visibleOption.getText();
    }

    public static void waitFindElement(By element, Duration tempo) {
        WebDriverWait wait = new WebDriverWait(driver, tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
