package loginForm;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class RegistrationFormTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ifEmptyForm() throws InterruptedException {
        registrationPage.submitBtn.click();
        Assert.assertTrue(registrationPage.requiredField.isDisplayed());
        sleep(1000);
    }

    @Test
    public void isInvalidValidEmail() throws InterruptedException {
        registrationPage.email.sendKeys("useruser.com");
        registrationPage.password.sendKeys("");
        sleep(1000);
        List<WebElement> allMessages = driver.findElements(By.xpath("//*[contains(text(), 'Please enter a valid email address.')]"));
        if (allMessages.isEmpty()) {
            System.out.println("Test not passed");
        } else {
            System.out.println("Test passed");
            System.out.println(registrationPage.requiredField.getText());
        }
    }

    @Test
    @Description ("Checking login form with all needed parameters")
    @Step("Fill the login form")
    public void isSuccessfullyLogin() throws InterruptedException {
        registrationPage.firstName.sendKeys("UserName");
        registrationPage.lastName.sendKeys("UserLastName");
        registrationPage.hobby.click();
        registrationPage.phone.sendKeys("12345678");
        registrationPage.userName.sendKeys("user");
        registrationPage.email.sendKeys("user@user.com");
        registrationPage.password.sendKeys("1111");
        registrationPage.confirmPassword.sendKeys("1111");
        sleep(1000);
        registrationPage.submitBtn.click();
    }

}

