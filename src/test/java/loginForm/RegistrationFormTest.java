package loginForm;

import ikea.Initialization;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationFormTest {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        Initialization.setUp();
    }

//    @AfterClass
//    static public void tearDown() {
//        driver.close();
//    }

    @Test
    public void ifEmptyForm() {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");


    }

//    @Test
//    public void chekEmailForm() {
//
//    }
//
//    @Test
//    public void isSuccessfullyLogin() {
//
//    }
//
//    @Test
//    public void wrongPasswordConfirmation() {
//
//    }

}
