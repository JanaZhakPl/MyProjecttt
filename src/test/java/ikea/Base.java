package ikea;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        String site = "https://www.ikea.com/pl/pl/?ref=gwp-start";
        driver.get(site);
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    @AfterClass
    public static void setDown() {
        if (driver != null)
        driver.close();
    }
}
