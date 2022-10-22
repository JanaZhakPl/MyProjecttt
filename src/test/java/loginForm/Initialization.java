package loginForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialization {
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        setUp();
    }
}
