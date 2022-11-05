package ikea.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By chosenItem = By.partialLinkText("NEIDEN");
    public By addToCartBtn = By.xpath("(//div[@class='pip-buy-module__buttons--left']//span[text()='Dodaj do koszyka'])");
    public By checkOutBtn = By.partialLinkText("Przejdź do koszyka");
    public By shoppingCartBtn = By.className("js-shopping-cart-icon");
    public By clearCartBtn = By.xpath("//*[@id=\"cart-ingka-context-menu-actions-2\"]/button/span/span");
    public By navigateCartBtn = By.className("cart-ingka-btn__icon");
   }