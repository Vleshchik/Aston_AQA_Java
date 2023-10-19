import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Установите путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Инициализация драйвера Selenium
        WebDriver driver = new ChromeDriver();

        // Открытие страницы сайта
        driver.get("https://www.postman.com");

        // Логин (если необходимо)
        // ...

        try {
            // Чтение JSON-файла с методами
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/Postman Echo.postman_collection.json"));

            if (obj instanceof JSONArray) {
                JSONArray methodsArray = (JSONArray) obj;

                // Цикл по методам
                for (Object method : methodsArray) {
                    JSONObject methodObj = (JSONObject) method;
                    String url = (String) methodObj.get("url");

                    // Клик по методу
                    WebElement methodElement = driver.findElement(By.xpath("//a[@href='" + url + "']"));
                    methodElement.click();

                    // Ожидание загрузки страницы с результатами
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    // Получение тела ответа
                    WebElement responseBody = driver.findElement(By.xpath("//pre[@class='response']"));

                    // Получение кода ответа
                    WebElement responseCode = driver.findElement(By.xpath("//span[@class='code']"));

                    // Проверка тела ответа с использованием REST Assured
                    Response response = RestAssured.get(url);
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
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Закрытие браузера
        driver.quit();
    }
}