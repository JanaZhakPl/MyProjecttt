package loginForm;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFormTest extends Base {
//    private final By firstNameFld = By.cssSelector("fieldset[class='fieldset'] input[name='name']");
//    private final By lastNameFld = By.cssSelector("body > section:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > fieldset:nth-child(1) > p:nth-child(2) > input:nth-child(2)");
//    private final By countryDropdown = By.cssSelector("body > section:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > fieldset:nth-child(4) > select:nth-child(2)");
//    private final By phone = By.cssSelector("fieldset[class='fieldset'] input[name='phone']");
//    private final By usernameFld = By.cssSelector("fieldset[class='fieldset'] input[name='username']");
//    private final By email = By.cssSelector("fieldset[class='fieldset'] input[name='email']");
//    private final By password = By.cssSelector("fieldset[class='fieldset'] input[name='password']");
//    private final By confirmPassword = By.cssSelector("input[name='c_password']");
//    private final By confirmPasswordLabel = By.cssSelector("label[for='c_password']");
   private final By submitBtn = By.cssSelector("input[value='submit']");
//    private final By heading = By.cssSelector(".heading");


    //WebElement submitBtn = driver.findElement(By.cssSelector("input[value='submit']"));
   // List<WebElement> inputs = new ArrayList<>();

    @Test
    public void ifEmptyForm() {
        driver.findElement(submitBtn).click();
        //ExpectedConditions.visibilityOfElementLocated();
        // Assert.assertEquals(driver., "This field is required.");
          Assert.assertTrue(driver.findElement(By.xpath("//filedset[@class='fieldset error_p']")).isDisplayed());
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


