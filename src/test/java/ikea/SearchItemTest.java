package ikea;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchItemTest extends BaseTest {
    By searchBox = By.xpath("//input[@placeholder='Czego szukasz?']");
    By searchBtn = By.id("search-box__searchbutton");

    @Test
    @Description("Searching box test")
    @Severity(SeverityLevel.NORMAL)
    void searchingTest() {
        searchBox();
    }

    @Attachment
    public String searchBox() {
        type(searchBox, "regal");
        click(searchBtn);
        WebElement summaryMessage = driver.findElement(By.className("search-summary__message"));
        Assert.assertTrue(summaryMessage.isDisplayed());
        return summaryMessage.getText();
    }

    @Test
    @Attachment
    public String unrealItemSearch() {
        type(searchBox, "someItem");
        click(searchBtn);
        WebElement zeroResultMessage = driver.findElement(By.className("zero-results-heading"));
        Assert.assertTrue(zeroResultMessage.isDisplayed());
        return zeroResultMessage.getText();
    }
}
