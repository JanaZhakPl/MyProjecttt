package ikea;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateNewProfileTest extends BaseTest {
    By myAccountMenu = By.xpath("//*[@id=\"loyalty-modal-button\"]/span");
    By newAccBtn = By.xpath("//div[@class='header__link-content-text']//h3[contains(text(), 'Utwórz konto IKEA Family')]");
    By firstName = By.id("family-signup-form-firstName");
    By lastName = By.id("family-signup-form-lastName");
    By birthDate = By.id("family-signup-form-birthDate");
    By gender = By.id("family-signup-form-genderCode");
    //By country = By.id("family-signup-form-addressCountryCode");
    By address = By.id("family-signup-form-address1");
    By zipCode = By.id("family-signup-form-zipCode");
    By cityName = By.id("family-signup-form-cityName");
    By preferredStore = By.id("family-signup-form-preferredStore");
    By email = By.id("family-signup-form-email");
    By password = By.id("family-signup-form-password");
    By consent = By.xpath("//*[@id=\"family-signup-form-double-consent\"]");
    By confirmation = By.xpath("//*[@id=\"singup-form-submit-button\"]/span/span");
    public By confirmationEmailMessage = By.className("jumbo-btn__label");
    public By errorMessage = By.className("form-field__message");

    @Test
    public void CreateNewProfile() throws InterruptedException {
        click(myAccountMenu);
        click(newAccBtn);
        type(firstName, "User1");
        type(lastName, "UserSurname1");
        type(birthDate, "01012000");
        type(gender, "k");
        type(address, "someAdress 11");
        type(zipCode, "12345");
        type(cityName, "SomeCity");
        type(preferredStore, "g");
        type(email, generateRandomEmail());
        type(password, "qQ123456");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"family-signup-form-double-consent\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        click(consent);
        click(confirmation);
        Thread.sleep(1000);
        ExpectedConditions.presenceOfElementLocated(confirmationEmailMessage);
    }

    @Test
    public void missedFieldOrEmptyForm() throws InterruptedException {
        click(myAccountMenu);
        click(newAccBtn);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"singup-form-submit-button\"]/span/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        click(confirmation);
        ExpectedConditions.presenceOfElementLocated(errorMessage);
    }

    private String generateRandomEmail() {
        return RandomStringUtils.random(4, true, true) + "@gmail.com";
    }
}

