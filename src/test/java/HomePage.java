import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;


public class HomePage {
    private WebDriver driver;
    private Wait<WebDriver> wait;
    private JavascriptExecutor js;
    private Actions actions;
    private List<WebElement> itemNames;
    private List<WebElement> itemPrices;
    private List<WebElement> itemWrappers;
    private WebElement basketLink;
    private WebElement items;
    private WebElement itemWrapper;
    private WebElement addToBasketBtn;


    HomePage(WebDriver driver) {
        this.driver = driver;
    }

    void open() {
        driver.get("https://www.wildberries.ru/");
        wait = new WebDriverWait(driver, 5);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    void initElements() {
        //ждем отображения продуктов и записываем в items
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'main-page__items')]")));
        items = driver.findElement(By.xpath("//div[contains(@class,'main-page__items')]"));

        //скроллим до items
        js.executeScript("arguments[0].scrollIntoView();",items);

        //ждем отображения названия, стоимости
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='product-card__name']")));
    }

    List<WebElement> getItemNames() {
        itemNames = driver.findElements(By.xpath("//*[@class='product-card__name']"));
        Collections.reverse(itemNames.subList(0,3));
        return itemNames.subList(0,3);
    }

    List<WebElement> getItemPrices() {
        itemPrices = driver.findElements(By.xpath("//*[contains(@class,'price__lower-price')]"));
        Collections.reverse(itemPrices.subList(0,3));
        return itemPrices.subList(0,3);
    }

    WebElement getItemsWrapper(int i) {
        itemWrappers = driver.findElements(By.xpath("//*[@class='product-card__wrapper']"));
        return itemWrappers.get(i);
    }

    WebElement getAddButtons(int i) {
        List<WebElement> addButtons = driver.findElements(By.xpath("//*[contains(@class,'product-card__add-basket')]"));
        return addButtons.get(i);
    }



    void addItem(int number) {
        itemWrapper = getItemsWrapper(number);
        actions.moveToElement(itemWrapper).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'btn-main-sm')]")));
        addToBasketBtn = getAddButtons(number);
        addToBasketBtn.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'popup-list-of-sizes')]//ul/li[1]")));
            driver.findElement(By.xpath("//*[contains(@class, 'popup-list-of-sizes')]//ul/li[1]")).click();
        }
        catch (TimeoutException timeoutException){
            timeoutException.getStackTrace();
        }
    }

    void openBasket() {
        basketLink = driver.findElement(By.xpath("//*[@id='basketContent']//*[@href='/lk/basket']"));
        basketLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-info__item-name")));
    }

}