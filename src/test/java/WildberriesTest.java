import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WildberriesTest {
    static WebDriver driver;
    public List<String> itemNamesExpected;
    public List<String> itemPricesExpected;
    public List<String> itemPricesActual;
    public List<String> itemNamesActual;
    public static int totalSum;
    private static Basket basket;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basket = new Basket(driver);
    }
    @Test
    @Order(1)
    public void selectProductsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.initElements();
        homePage.addItem(0);
        homePage.addItem(1);
        homePage.addItem(2);
        itemNamesExpected = homePage.getItemNames().stream().map(WebElement -> WebElement.getText().substring(2)).collect(Collectors.toList());
        itemPricesExpected = homePage.getItemPrices().stream().map(WebElement::getText).collect(Collectors.toList());
        totalSum(itemPricesExpected);
        homePage.openBasket();
        itemNamesActual = basket.getItemNames().stream().map(WebElement::getText).collect(Collectors.toList());
        itemPricesActual = basket.getItemPrices().stream().map(WebElement::getText).collect(Collectors.toList());
    }
    @Test
    @Order(2)
    public void comparisonGoodsNames() {
        assertEquals(itemNamesExpected, itemNamesActual);
        assertEquals(itemPricesExpected, itemPricesActual);
    }
    @Test
    @Order(3)
    public void comparisonGoodsPrices() {
        assertEquals(itemPricesExpected, itemPricesActual);
    }
    @Test
    @Order(4)
    public void comparisonGoodsQuantity() {
        assertEquals("Товары, 3 шт.", basket.getTotalQuantity().getText());
    }
    @Test
    @Order(5)
    public void comparisonGoodsTotalPrices() {
        String totalSumActual = basket.getTotalPrice().getText().replaceAll("\\s", "");
        assertEquals(totalSum, Integer.parseInt(totalSumActual.substring(0, totalSumActual.length()-1)));
    }
    @AfterAll
    static void teardown() {
        driver.quit();
    }
    public static void totalSum(List<String> prices) {
        totalSum = 0;
        for (String price : prices) {
            String priceWithoutSymbol = price.replace(" ₽", "");
            int priceValue = Integer.parseInt(priceWithoutSymbol);
            totalSum += priceValue;
        }
    }
}