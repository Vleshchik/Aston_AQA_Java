import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private static HomePage instance;

    private HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static synchronized HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    public void open() {
        driver.get("https://www.wildberries.ru/");
    }

    public void addToCart(String productName) {
        WebElement product = driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]/ancestor::div[@class='j-card-item']"));
        WebElement addToCartButton = product.findElement(By.xpath(".//button[contains(text(),'В корзину')]"));
        addToCartButton.click();
    }

    public void goToCart() {
        WebElement cartButton = driver.findElement(By.xpath("//a[contains(@class,'header-actions__button_type_cart')]"));
        cartButton.click();
    }
}