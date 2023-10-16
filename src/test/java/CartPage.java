import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public boolean isProductInCart(int productName) {
        WebElement product = driver.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div["+productName+"]/div[1]"));
        return product.isDisplayed();
    }

    public int getProductsCount() {
        WebElement productsCountElement = driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[2]/div[1]/div[4]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]"));
        return Integer.parseInt(productsCountElement.getText());
    }

    public String getProductPrice(int productName) {
        WebElement product = driver.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div["+productName+"]/div[1]"));
        WebElement priceElement = product.findElement(By.xpath(".//div[@class='list-item__price-new']"));
        return priceElement.getText();
    }

    public String getTotalPrice() {
        WebElement totalPriceElement = driver.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[4]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[1]/span[2]/span[1]"));
        return totalPriceElement.getText();
    }
}