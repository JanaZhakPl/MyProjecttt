import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    private WebDriver webDriver;

    @Before
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://google.com/");
    }

    @After
    public void cleanUp() {
        if (webDriver != null)
            webDriver.quit();
    }

    @Test
    public void someTest() {
        Assert.assertEquals("https://www.google.com/", webDriver.getCurrentUrl());
        Assert.assertEquals("Комп'ютерна школа Hillel у Києві: Курси IT-технологій", webDriver.getTitle());
    }

    @Test
    public void register() {

    }
}
