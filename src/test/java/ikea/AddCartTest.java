package ikea;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCartTest<productName> extends BaseTest {
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

    public void addProduct(String productName){

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



