package ikea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String startPage = "https://www.ikea.com/pl/pl/?ref=gwp-start";
        driver.get(startPage);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    private WebElement find(By locator) {
        return driver.findElement(locator);
    }
    protected void click(By locator) {
        find(locator).click();
    }
    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }
}
