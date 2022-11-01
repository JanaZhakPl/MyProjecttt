package ikea;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class AddCartTest extends BaseTest {
    By chosenItem = By.partialLinkText("NEIDEN");

    @Test
    public void choose() {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        click(chosenItem);
        Assert.assertEquals(driver.getTitle(), "NEIDEN Rama łóżka, sosna, 90x200 cm - IKEA");
    }

    @Test
    public void add() throws InterruptedException {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        driver.findElement(By.partialLinkText("NEIDEN")).click();
        driver.findElement(By.xpath("//div[@class='pip-buy-module__buttons--left']//span[text()='Dodaj do koszyka']")).click();
        sleep(2000);
        WebElement cartButton = driver.findElement(By.partialLinkText("Przejdź do koszyka"));
        cartButton.click();
        //sleep(2000);
        Assert.assertEquals("https://www.ikea.com/pl/pl/shoppingcart/", driver.getCurrentUrl());
    }
}


