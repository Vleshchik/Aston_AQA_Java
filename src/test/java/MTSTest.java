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
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MTSTest {
    private static WebDriver driver;
    private static Actions actions;
    private static WebDriverWait wait;
    private static String sumOfPayment;
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
    public void testBlockTitlePhone() {
        WebElement blockTitlePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Номер телефона']")));
        assertEquals("Номер телефона", blockTitlePhone.getAttribute("placeholder"), "Надпись в незаполненном поле Услуги связи неверная");
        WebElement blockTitlePhone2 = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        assertEquals("Сумма", blockTitlePhone2.getAttribute("placeholder"), "Надпись в незаполненном поле Услуги связи неверная");
        WebElement blockTitlePhone3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        assertEquals("E-mail для отправки чека", blockTitlePhone3.getAttribute("placeholder"), "Надпись в незаполненном поле Услуги связи неверная");
    }
    @Test
    public void testBlockTitleHomeInternet() {
        WebElement blockTitleHomeInternet1 = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        assertEquals("Номер абонента", blockTitleHomeInternet1.getAttribute("placeholder"), "Надпись в незаполненном поле Домашний интернет неверная");
        WebElement blockTitleHomeInternet2 = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        assertEquals("Сумма", blockTitleHomeInternet2.getAttribute("placeholder"), "Надпись в незаполненном поле Домашний интернет неверная");
        WebElement blockTitleHomeInternet3 = driver.findElement(By.xpath("//input[@id='internet-email']"));
        assertEquals("E-mail для отправки чека", blockTitleHomeInternet3.getAttribute("placeholder"), "Надпись в незаполненном поле Домашний интернет неверная");
    }
    @Test
    public void testBlockTitleInstalment() {
        WebElement blockTitleInstalment1 = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        assertEquals("Номер счета на 44", blockTitleInstalment1.getAttribute("placeholder"), "Надпись в незаполненном поле Рассрочка неверная");
        WebElement blockTitleInstalment2 = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        assertEquals("Сумма", blockTitleInstalment2.getAttribute("placeholder"), "Надпись в незаполненном поле Рассрочка неверная");
        WebElement blockTitleInstalment3 = driver.findElement(By.xpath("//input[@id='instalment-email']"));
        assertEquals("E-mail для отправки чека", blockTitleInstalment3.getAttribute("placeholder"), "Надпись в незаполненном поле Рассрочка неверная");
    }
    @Test
    public void testBlockTitleArrears() {
        WebElement blockTitleArrears1 = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        assertEquals("Номер счета на 2073", blockTitleArrears1.getAttribute("placeholder"), "Надпись в незаполненном поле Задолженность неверная");
        WebElement blockTitleArrears2 = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        assertEquals("Сумма", blockTitleArrears2.getAttribute("placeholder"), "Надпись в незаполненном поле Задолженность неверная");
        WebElement blockTitleArrears3 = driver.findElement(By.xpath("//input[@id='arrears-email']"));
        assertEquals("E-mail для отправки чека", blockTitleArrears3.getAttribute("placeholder"), "Надпись в незаполненном поле Задолженность неверная");
    }
    @Test
    public void testPaymentForm() {
        fillPaymentForm();
        try {
            WebElement checkSumOfPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='header__payment-amount']")));
            checkSumOfPayment.getAttribute("innerHTML").contains(sumOfPayment);
            WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='colored disabled ng-star-inserted']")));
            payButton.getAttribute("innerHTML").contains(sumOfPayment);
        }
        finally {
            driver.switchTo().defaultContent();
            driver.navigate().refresh();
        }
    }
    @Test
    public void testPaymentLogos() {
        fillPaymentForm();
        try {
            WebElement logos = driver.findElement(By.cssSelector("div.cards-brands.cards-brands__container"));
            List<WebElement> paymentLogos = logos.findElements(By.tagName("img"));
            for (WebElement paymentLogo : paymentLogos) {
                System.out.println(paymentLogo.getAttribute("src"));
            }
        }

        finally {
            driver.switchTo().defaultContent();
            driver.navigate().refresh();
        }
    }
    public static void scrollToCenter(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
    public static void fillPaymentForm(){
        WebElement serviceRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__form']")));
        scrollToCenter(serviceRadio);
        serviceRadio.click();
        sumOfPayment = "10.00";
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");
        WebElement sumOfPaymentInput = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumOfPaymentInput.sendKeys(sumOfPayment);
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(@class,'button button__default')]"));
        scrollToCenter(continueButton);
        continueButton.click();
        WebElement paymentFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));
        driver.switchTo().frame(paymentFrame);
    }
}
