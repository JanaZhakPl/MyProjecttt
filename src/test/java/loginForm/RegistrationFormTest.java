package loginForm;


import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationFormTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();
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
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("console.log('Submit empty form')");
        js.executeScript("window.scroll(0,600)");
    }

    @Test
    public void isValidEmail() throws InterruptedException {
        String emailPattern = "^(.+)@(\\\\S+)$";
        Pattern p = Pattern.compile(emailPattern);
        registrationPage.email.sendKeys("user@user.com");
        Thread.sleep(1000);
        String par = registrationPage.email.getText();
        Matcher m = p.matcher(par);
        Assert.assertTrue(m.matches());

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
        Thread.sleep(1000);
        registrationPage.submitBtn.click();
    }

    @Test
    public void wrongPasswordConfirmation() {
        registrationPage.password.sendKeys("1111");
        registrationPage.confirmPassword.sendKeys("1111");
        String getConfirmationError = registrationPage.confirmationError.getText();
        Assert.assertEquals("Invalid password confirmation", getConfirmationError);
    }

}

