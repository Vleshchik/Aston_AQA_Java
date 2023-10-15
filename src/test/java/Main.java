import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @Test
    public void testAddToCart() {
        // Открытие главной страницы
        homePage.open();

        // Добавление товара в корзину
        homePage.addToCart("Название товара 1");
        homePage.addToCart("Название товара 2");
        homePage.addToCart("Название товара 3");

        // Переход в корзину
        homePage.goToCart();

        // Проверка названий товаров в корзине
        Assert.assertTrue(cartPage.isProductInCart("Название товара 1"));
        Assert.assertTrue(cartPage.isProductInCart("Название товара 2"));
        Assert.assertTrue(cartPage.isProductInCart("Название товара 3"));

        // Проверка количества товаров в корзине
        Assert.assertEquals(cartPage.getProductsCount(), 3);

        // Проверка цены каждого товара в корзине
        Assert.assertEquals(cartPage.getProductPrice("Название товара 1"), "1000 руб.");
        Assert.assertEquals(cartPage.getProductPrice("Название товара 2"), "2000 руб.");
        Assert.assertEquals(cartPage.getProductPrice("Название товара 3"), "3000 руб.");

        // Проверка общей суммы товаров в корзине
        Assert.assertEquals(cartPage.getTotalPrice(), "6000 руб.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


