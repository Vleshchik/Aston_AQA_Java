import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;

public class HomePage {
    public static int totalPrice;
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private static HomePage instance;
    private String priceText;
    static String[] prices;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
        this.actions = new Actions(driver);
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
        WebElement product = driver.findElement(By.xpath("//body[@class='ru']/div[@class='wrapper']/main[@id='body-layout']/div[@id='mainContainer']/div[@id='app']/div/div[@class='main-page']/div[@class='main-page__blocks-wrap']/div[@id='ZjZmMDU3ZjItNzVmOC00MGNjLTNlMzQtYTA4YjkxODAzZThj']/div[@class='goods__list']/article["+article+"]/div[1]/a[1]"));
        scrollToCenter(driver, product, actions);
        WebElement productPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/article[1]/div[1]/div[2]/p[1]/span[1]/ins[1]"));
        prices[article-1] = productPrice.getText();
        priceText = productPrice.getText().replaceAll("[^0-9.]", "");
        totalPrice += parseInt(priceText);
        WebElement addToCartButton = product.findElement(By.xpath("//div[@id='ZjZmMDU3ZjItNzVmOC00MGNjLTNlMzQtYTA4YjkxODAzZThj']//article["+article+"]//div[1]//div[3]//p[3]//a[1]"));
        addToCartButton.click();
    }

    public void goToCart() {
        WebElement cartButton = driver.findElement(By.xpath("//header/div[1]/div[2]/div[2]/div[3]/a[1]"));
        cartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/img[1]")));
    }
    public static void scrollToCenter(WebDriver driver, WebElement element, Actions actions) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
}