package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;

    @BeforeClass
    protected void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://eshop-onweb-webinar-demo2.azurewebsites.net/?pageid=-1");
    }

    @AfterClass
    public void close(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }
}
