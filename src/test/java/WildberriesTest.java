import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildberriesTest
{
    static WebDriver driver;
    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void selectProductsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.initElements();
        homePage.addItem(0);
        homePage.addItem(1);
        homePage.addItem(2);
        List<String> itemNamesExpected = homePage.getItemNames().stream().map(WebElement -> WebElement.getText().substring(2)).collect(Collectors.toList());
        List<String> itemPricesExpected = homePage.getItemPrices().stream().map(WebElement::getText).collect(Collectors.toList());
        homePage.openBasket();

        Basket basket = new Basket(driver);
        List<String> itemNamesActual = basket.getItemNames().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> itemPricesActual = basket.getItemPrices().stream().map(WebElement::getText).collect(Collectors.toList());

        //сравнение наименований и цен, полученных на главной странице и в корзине
        assertEquals(itemNamesExpected, itemNamesActual);
        assertEquals(itemPricesExpected, itemPricesActual);

        //сравнение количества товаров
        assertEquals("Товары, 3 шт.", basket.getTotalQuantity().getText());

        //сравнение суммы товаров
        int totalSum = 0;
        for (String itemPrice: itemPricesExpected) {
            totalSum += Integer.parseInt(itemPrice.substring(0, itemPrice.length()-2));
        }
        String totalSumActual = basket.getTotalPrice().getText().replaceAll("\\s", "");
        assertEquals(totalSum, Integer.parseInt(totalSumActual.substring(0, totalSumActual.length()-1)));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}