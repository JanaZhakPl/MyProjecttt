package ikea.Pages;

import ikea.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BaseTest {
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By chosenItem = By.partialLinkText("NEIDEN");
    public By addToCartBtn = By.xpath("(//div[@class='pip-buy-module__buttons--left']//span[text()='Dodaj do koszyka'])");
    public By checkOutBtn = By.partialLinkText("Przejdź do koszyka");
    public By shoppingCartBtn = By.className("js-shopping-cart-icon");
    public By clearCartBtn = By.className("product-controls__remove");
    public By navigateCartBtn = By.className("cart-ingka-btn__icon");
    //   public By emptyCartMessage = By.className("noProducts_header__9wz2x");

}
