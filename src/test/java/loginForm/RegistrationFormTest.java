package loginForm;


import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegistrationFormTest extends Base {
    WebElement firstName = driver.findElement(By.cssSelector("fieldset[class='fieldset'] input[name='name']"));
    WebElement lastName = driver.findElement(By.xpath("//form[@id='register_form']/fieldset/p[2]/input"));
    WebElement country = driver.findElement(By.xpath("//form[@id='register_form']/fieldset[7]/input"));
    WebElement hobby = driver.findElement(By.xpath("//fieldset[3]/div/label/input"));
    WebElement phone = driver.findElement(By.cssSelector("fieldset[class='fieldset'] input[name='phone']"));
    WebElement username = driver.findElement(By.cssSelector("fieldset[class='fieldset'] input[name='username']"));
    WebElement email = driver.findElement(By.cssSelector("fieldset[class='fieldset'] input[name='email']"));
    WebElement password = driver.findElement(By.xpath("//form[@id='register_form']/fieldset[11]/input"));
    WebElement confirmPassword = driver.findElement(By.xpath("//form[@id='register_form']/fieldset[12]/input"));
    WebElement submitBtn = driver.findElement(By.cssSelector("input[value='submit']"));
    WebElement heading = driver.findElement(By.cssSelector(".heading"));
    WebElement invalidInput = driver.findElement(By.cssSelector("input:invalid"));
    //WebElement requiredField = driver.findElement(By.className("error_p"));


    @Test
    public void ifEmptyForm() throws InterruptedException {
        submitBtn.click();
        WebElement requiredField = driver.findElement(By.className("error_p"));
        Assert.assertTrue(requiredField.isDisplayed());
        Thread.sleep(3000);
    }

//    @Test
//    public void chekEmailForm() {
//
//    }

    @Test
    public void isSuccessfullyLogin() {
        firstName.sendKeys("UserName");
        lastName.sendKeys("UserLastName");
        hobby.click();
        phone.sendKeys("12345678");
        username.sendKeys("user");
        email.sendKeys("user@user.com");
        password.sendKeys("1111");
        confirmPassword.sendKeys("1111");
        submitBtn.click();
    }

//    @Test
//    public void wrongPasswordConfirmation() {
//        password.sendKeys("1111");
//        passwordConfirmation.sendKeys("1111");
//        Assert.assertEquals(password, passwordConfirmation);
//    }

}


