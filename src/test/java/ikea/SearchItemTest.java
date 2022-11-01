package ikea;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchItemTest extends BaseTest {
    By searchBox = By.xpath("//input[@placeholder='Czego szukasz?']");
    By searchBtn = By.id("search-box__searchbutton");
    // By  summaryMessage = By.className("search-summary__message");

    @Test
    public void searchBoxTest() {
        type(searchBox, "regal");
        click(searchBtn);
        WebElement summaryMessage = driver.findElement(By.className("search-summary__message"));
        Assert.assertTrue(summaryMessage.isDisplayed());
        String result = summaryMessage.getText();
        System.out.println(result);
    }

    @Test
    public void unrealItemSearchBoxTest() {
        type(searchBox, "someItem");
        click(searchBtn);
        WebElement zeroResultMessage = driver.findElement(By.className("zero-results-heading"));
        Assert.assertTrue(zeroResultMessage.isDisplayed());
        String result = zeroResultMessage.getText();
        System.out.println(result);
    }
}
