package ikea.Pages;

import ikea.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BaseTest {
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public By myAccountMenu = By.xpath("//*[@id=\"loyalty-modal-button\"]/span");
    public By newAccBtn = By.xpath("//div[@class='header__link-content-text']//h3[contains(text(), 'Utwórz konto IKEA Family')]");
    By firstName = By.id("family-signup-form-firstName");
    By lastName = By.id("family-signup-form-lastName");
    By birthDate = By.id("family-signup-form-birthDate");
    By gender = By.id("family-signup-form-genderCode");
    //By country = By.id("family-signup-form-addressCountryCode");
    public By address = By.id("family-signup-form-address1");
    public By zipCode = By.id("family-signup-form-zipCode");
    public By cityName = By.id("family-signup-form-cityName");
    public By preferredStore = By.id("family-signup-form-preferredStore");
    public By email = By.id("family-signup-form-email");
    public By password = By.id("family-signup-form-password");
    public By consent = By.xpath("//*[@id=\"family-signup-form-double-consent\"]");
    public By confirmation = By.xpath("//*[@id=\"singup-form-submit-button\"]/span/span");
    public By confirmationEmailMessage = By.className("jumbo-btn__label");
    public By errorMessage = By.className("form-field__message");

    @Step("Type {user.name}")
    public RegistrationPage fillName(String someName) {
        type(firstName, someName);
        return this;
    }

    @Step("Type {user.lastName}")
    public RegistrationPage fillLastName(String someSurname) {
        type(lastName, someSurname);
        return this;
    }

    @Step("Type {user.birthday}")
    public RegistrationPage fillBirthday(String birthdayDate) {
        type(birthDate, birthdayDate);
        return this;
    }

    @Step("Choose {user.gender}")
    public RegistrationPage chooseGender(String gender) {
        type(lastName, gender);
        return this;
    }

    @Step("Type {user.address}")
    public RegistrationPage fillAddress(String someAddress) {
        type(address, someAddress);
        return this;
    }

    @Step("Type {user.zipCode")
    public RegistrationPage fillZipCode(String someZipCode) {
        type(zipCode, someZipCode);
        return this;
    }

    @Step("Type {user.city}")
    public RegistrationPage fillCityName(String city) {
        type(cityName, city);
        return this;
    }

    @Step("Choose {user.store}")
    public RegistrationPage choosePreferedStore(String store) {
        type(preferredStore, store);
        return this;
    }

    @Step("Type {user.email}")
    public RegistrationPage fillEmail(String someEmail) {
        type(email, someEmail);
        return this;
    }

    @Step("Type {user.password}")
    public RegistrationPage fillPassword(String somePassword) {
        type(password, somePassword);
        return this;
    }

    @Step("Click Login Bottom")
    public RegistrationPage clickLogInBtn() {
        click(myAccountMenu);
        return this;
    }

    @Step("Click Registration Bottom")
    public RegistrationPage clickRegBtn() {
        click(newAccBtn);
        return this;
    }


}
