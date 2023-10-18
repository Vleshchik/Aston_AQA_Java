import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Установите путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Инициализация драйвера Selenium
        WebDriver driver = new ChromeDriver();

        // Открытие страницы сайта
        driver.get("https://www.postman.com");

        // Логин (если необходимо)
        // ...

        // Получение списка методов из папки Request Methods
        String[] methods = {"get", "post", "put", "patch", "delete"};

        // Цикл по методам
        for (String method : methods) {
            // Клик по методу
            WebElement methodElement = driver.findElement(By.xpath("//a[@href='https://postman-echo.com/" + method + "']"));
            methodElement.click();

            // Ожидание загрузки страницы с результатами
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Получение тела ответа
            WebElement responseBody = driver.findElement(By.xpath("//pre[@class='response']"));

            // Получение кода ответа
            WebElement responseCode = driver.findElement(By.xpath("//span[@class='code']"));

            // Проверка тела ответа с использованием REST Assured
            Response response = RestAssured.request(method, "https://postman-echo.com/" + method);
            String expectedResponseBody = response.getBody().asString();
            String actualResponseBody = responseBody.getText();
            Assert.assertEquals(expectedResponseBody, actualResponseBody);

            // Проверка кода ответа с использованием REST Assured
            int expectedResponseCode = response.getStatusCode();
            int actualResponseCode = Integer.parseInt(responseCode.getText());
            Assert.assertEquals(expectedResponseCode, actualResponseCode);

            // Возврат на страницу с методами
            driver.navigate().back();
        }

        // Закрытие браузера
        driver.quit();
    }
}