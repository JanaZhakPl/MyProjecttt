package loginForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//https://www.way2automation.com/way2auto_jquery/registration.php#load_box

public class RegistrationPage {
    @FindBy(css = "fieldset[class='fieldset'] input[name='name']")
    public WebElement firstName;

    @FindBy(xpath = "//form[@id='register_form']/fieldset/p[2]/input")
    public WebElement lastName;

    @FindBy(xpath = "//form[@id='register_form']/fieldset[7]/input")
    public WebElement country;

    @FindBy(xpath = "//fieldset[3]/div/label/input")
    public WebElement hobby;

    @FindBy(css = "fieldset[class='fieldset'] input[name='phone']")
    public WebElement phone;

    @FindBy(css = "fieldset[class='fieldset'] input[name='username']")
    public WebElement userName;

    @FindBy(css = "fieldset[class='fieldset'] input[name='email']")
    public WebElement email;

    @FindBy(xpath = "//form[@id='register_form']/fieldset[11]/input")
    public WebElement password;

    @FindBy(xpath = "//form[@id='register_form']/fieldset[12]/input")
    public WebElement confirmPassword;

    @FindBy(css = "input[value='submit']")
    public WebElement submitBtn;

    @FindBy(className = "error_p")
    public WebElement requiredField;

    @FindBy(xpath = "//*[@id=\"register_form\"]/fieldset[12]/label[2]")
    public WebElement confirmationError;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

