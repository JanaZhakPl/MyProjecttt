package ikea.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;


    private WebElement clickLink(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }


}