import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,5);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/img[1]")));
    }

    public void addToCart(int article) {
        WebElement product = driver.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/article["+article+"]/div[1]/a[1]"));
        WebElement addToCartButton = product.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/article["+article+"]/div[1]/div[3]/p[3]/a[1]"));
        addToCartButton.click();
    }

    public void goToCart() {
        WebElement cartButton = driver.findElement(By.xpath("//header/div[1]/div[2]/div[2]/div[3]/a[1]"));
        cartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/img[1]")));
    }
}