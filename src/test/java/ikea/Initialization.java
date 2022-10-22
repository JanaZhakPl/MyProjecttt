package ikea;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static ikea.IkeaPageTest.driver;

public class Initialization {
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.ikea.com/pl/pl/?ref=gwp-start");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
}
