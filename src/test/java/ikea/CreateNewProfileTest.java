package ikea;

import ikea.Pages.RegistrationPage;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateNewProfileTest extends BaseTest {
    @Test
    @Description("Create a new user account")
    public void CreateNewProfile() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver)
                .clickLogInBtn()
                .clickRegBtn()
                .fillName("User")
                .fillLastName("Surname")
                .fillBirthday("01012001")
                .chooseGender("k")
                .fillAddress("SomeStreet 11")
                .fillZipCode("12345")
                .fillCityName("SomeCity")
                .choosePreferedStore("g")
                .fillEmail(generateRandomEmail())
                .fillPassword("qQ123456");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"family-signup-form-double-consent\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        click(registrationPage.consent);
        click(registrationPage.confirmation);
        ExpectedConditions.presenceOfElementLocated(registrationPage.confirmationEmailMessage);
    }

    @Test
    public void missedFieldOrEmptyForm() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver)
                .clickLogInBtn()
                .clickRegBtn();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"singup-form-submit-button\"]/span/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        click(registrationPage.confirmation);
        ExpectedConditions.presenceOfElementLocated(registrationPage.errorMessage);
    }

    public String generateRandomEmail() {
        return RandomStringUtils.random(4, true, true) + "@gmail.com";
    }
}

