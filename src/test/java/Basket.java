import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Basket {

    private WebDriver driver;
    private List<String> itemNamesList;
    private List<WebElement> itemNames;
    private List<WebElement> itemPrices;
    private List<WebElement> itemQuantity;

    Basket(WebDriver driver) {
        this.driver = driver;
    }

    List<WebElement> getItemNames() {
        itemNames = driver.findElements(By.cssSelector(".good-info__good-name"));
        return itemNames;
    }

    List<WebElement> getItemPrices() {
        itemPrices = driver.findElements(By.xpath("//*[@class='list-item__price-new']"));
        return itemPrices;
    }

    WebElement getTotalQuantity() {
        return driver.findElement(By.xpath("//*[@class='b-top__count line']/span[1]"));
    }

    WebElement getTotalPrice() {
        return driver.findElement(By.xpath("//*[@class='b-top__total line']/span/span"));
    }
}