package ikea;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class IkeaPageTest extends Base {

    @Test
    public void search() throws InterruptedException {

        driver.findElement(By.name("q")).sendKeys("regał");
        driver.findElement(By.id("search-box__searchbutton")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.className("search-summary__message")).isDisplayed());
    }

    @Test
    public void choose() {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        driver.findElement(By.partialLinkText("NEIDEN")).click();
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


