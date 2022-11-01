package ikea;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddCartTest extends BaseTest {
    By chosenItem = By.partialLinkText("NEIDEN");
    By addToCartBtn = By.xpath("(//div[@class='pip-buy-module__buttons--left']//span[text()='Dodaj do koszyka'])");
    By checkOutBtn = By.partialLinkText("Przejdź do koszyka");
    By shoppingCartBtn = By.className("js-shopping-cart-icon");
    By clearCartBtn = By.className("product-controls__remove");
    By navigateCartBtn = By.className("cart-ingka-btn__icon");

    @Test
    public void chooseAndAdd() {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        click(chosenItem);
       // Assert.assertEquals(driver.getTitle(), "NEIDEN Rama łóżka, sosna, 90x200 cm - IKEA");
        click(addToCartBtn);
        click(checkOutBtn);
        Assert.assertEquals("https://www.ikea.com/pl/pl/shoppingcart/", driver.getCurrentUrl());
    }
        @Test
        public void clearShoppingCart () {
            click(shoppingCartBtn);
            click(navigateCartBtn);
            WebElement deleteItemsInCart = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(clearCartBtn));
            click(clearCartBtn);
        }
    }


//    @Test
//    public void add() throws InterruptedException {
//        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
//        driver.findElement(By.partialLinkText("NEIDEN")).click();
//        driver.findElement(By.xpath("//div[@class='pip-buy-module__buttons--left']//span[text()='Dodaj do koszyka']")).click();
//        sleep(2000);
//        WebElement cartButton = driver.findElement(By.partialLinkText("Przejdź do koszyka"));
//        cartButton.click();
//        //sleep(2000);
//        Assert.assertEquals("https://www.ikea.com/pl/pl/shoppingcart/", driver.getCurrentUrl());
//    }



