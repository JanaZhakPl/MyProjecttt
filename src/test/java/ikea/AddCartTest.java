package ikea;

import ikea.Pages.CartPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddCartTest extends BaseTest {
   CartPage cartPage = new CartPage(driver);

    @Test
    @Description("Search product by name and add to cart")
    public void chooseAndAdd() {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        click(cartPage.chosenItem);
        // Assert.assertEquals(driver.getTitle(), "NEIDEN Rama łóżka, sosna, 90x200 cm - IKEA");
        click(cartPage.addToCartBtn);
        click(cartPage.checkOutBtn);
    }
   @Test
   @Attachment
    public void emptyShoppingCart() {
        //cartPage.addProduct();
        click(cartPage.shoppingCartBtn);
        click(cartPage.navigateCartBtn);
       WebElement emptyCartMessage = driver.findElement(By.className("noProducts_header__9wz2x"));
       Assert.assertTrue(emptyCartMessage.isDisplayed());
       String result = emptyCartMessage.getText();
       System.out.println(result);
    }
}



