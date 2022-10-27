package loginForm;


import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("console.log('Submit empty form')");
//        js.executeScript("window.scroll(0,600)");
    }

    @Test
    public void isValidEmail() throws InterruptedException {
        registrationPage.email.sendKeys("useruser.com");
        registrationPage.password.sendKeys("");
        sleep(1000);
        Assert.assertTrue(registrationPage.requiredField.isDisplayed());
        if(true) {
            System.out.println("inValidEmail");
        }
    }

    @Test
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

    @Test
    public void wrongPasswordConfirmation() {
        registrationPage.password.sendKeys("1111");
        registrationPage.confirmPassword.sendKeys("222");
        String getConfirmationError = registrationPage.confirmationError.getText();
        Assert.assertEquals("Invalid password confirmation", getConfirmationError);
    }
}

