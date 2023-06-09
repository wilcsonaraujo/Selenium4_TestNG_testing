package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class RunBase {
    protected static WebDriver driver;

    @BeforeClass
    protected void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://eshop-onweb-webinar-demo2.azurewebsites.net/?pageid=-1");
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
