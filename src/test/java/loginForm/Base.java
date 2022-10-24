package loginForm;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static loginForm.RegistrationFormTest.driver;

public class Base {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();
    }

    @AfterClass
    static public void tearDown() {
        driver.close();
    }
}
