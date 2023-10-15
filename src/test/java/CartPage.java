import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    private static CartPage instance;

    private CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public static synchronized CartPage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new CartPage(driver);
        }
        return instance;
    }

    public boolean isProductInCart(String productName) {
        WebElement product = driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]/ancestor::div[@class='cart-list-item']"));
        return product.isDisplayed();
    }

    public int getProductsCount() {
        WebElement productsCountElement = driver.findElement(By.xpath("//span[@class='cart-detailed__count']"));
        return Integer.parseInt(productsCountElement.getText());
    }

    public String getProductPrice(String productName) {
        WebElement product = driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]/ancestor::div[@class='cart-list-item']"));
        WebElement priceElement = product.findElement(By.xpath(".//span[@class='price']"));
        return priceElement.getText();
    }

    public String getTotalPrice() {
        WebElement totalPriceElement = driver.findElement(By.xpath("//div[@class='cart-summary__sum-price']/span[@class='price']"));
        return totalPriceElement.getText();
    }
}