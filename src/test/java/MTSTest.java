import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class MTSTest {
    private static WebDriver driver;
    private static Actions actions;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 5);
        driver.get("https://www.mts.by/");
        wait.until(ExpectedConditions.titleContains("МТС – мобильный оператор в Беларуси"));
        WebElement cookieButton = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        scrollToCenter(cookieButton);
        cookieButton.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']//h2")));
        assertEquals("Онлайн пополнение\n" + "без комиссии", blockTitle.getText(), "Заголовок блока несоответствует");
    }

    @Test
    public void testPaymentLogosDisplayed() {
        WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay__partners")));
        scrollToCenter(paymentLogos);
        assertTrue(paymentLogos.isDisplayed(), "Логотипы платежных систем не отображены");
    }

    @Test
    public void testLearnMoreLink() {
        WebElement learnMoreLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Подробнее о сервисе")));
        scrollToCenter(learnMoreLink);
        learnMoreLink.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Текущая страница неверная");
        driver.navigate().back();
    }

    @Test
    public void testFormSubmission() {
        WebElement serviceRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__form']")));
        scrollToCenter(serviceRadio);
        serviceRadio.click();
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection button.button__default"));
        scrollToCenter(continueButton);
        continueButton.click();
        System.out.println("Click!");
    }

    public static void scrollToCenter(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
}