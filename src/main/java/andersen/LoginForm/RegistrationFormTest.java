package andersen.LoginForm;

import andersen.ikea.Initialization;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationFormTest {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        Initialization.setUp();
    }

    @AfterClass
    static public void tearDown() {
        driver.close();
    }

    @Test
    public void ifEmptyForm() {

    }

    @Test
    public void chekEmailForm() {

    }

    @Test
    public void isSuccessfullyLogin() {

    }

    @Test
    public void wrongPasswordConfirmation() {

    }

}
