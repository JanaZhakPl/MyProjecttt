package loginForm;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    }

    @Test
    public void isInvalidValidEmail() throws InterruptedException {
        registrationPage.email.sendKeys("useruser.com");
        registrationPage.password.sendKeys("");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(registrationPage.requiredField));
        System.out.println(registrationPage.requiredField.getText());

    }

    @Test
    @Description("Checking login form with all needed parameters")
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.submitBtn));
        registrationPage.submitBtn.click();
    }
}

