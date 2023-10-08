import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();
        // Создание объекта Actions для выполнения действий с мышью
        Actions actions = new Actions(driver);
        // Создание объекта WebDriverWait с таймаутом 10 секунд
        WebDriverWait wait = new WebDriverWait(driver,10);
        // Открытие сайта mts.by
        driver.get("https://www.mts.by/");
        // Ожидание загрузки страницы
        wait.until(ExpectedConditions.titleContains("МТС – мобильный оператор в Беларуси"));
        // Прокрутка страницы до блока "Онлайн пополнение без комиссии"
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Онлайн пополнение без комиссии']")));
        scrollToCenter(driver, blockTitle, actions);

        // Проверка названия блока "Онлайн пополнение без комиссии"
        System.out.println("Название блока: " + blockTitle.getText());

        // Прокрутка страницы до логотипов платежных систем
        WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-logos")));
        scrollToCenter(driver, paymentLogos, actions);

        // Проверка наличия логотипов платежных систем
        if (paymentLogos.isDisplayed()) {
            System.out.println("Логотипы платежных систем отображены");
        } else {
            System.out.println("Логотипы платежных систем не отображены");
        }

        // Прокрутка страницы до ссылки "Подробнее о сервисе"
        WebElement learnMoreLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Подробнее о сервисе")));
        scrollToCenter(driver, learnMoreLink, actions);

        // Проверка работы ссылки "Подробнее о сервисе"
        learnMoreLink.click();
        System.out.println("Текущая страница: " + driver.getCurrentUrl());

        // Возврат на предыдущую страницу
        driver.navigate().back();

        // Прокрутка страницы до полей и кнопки "Продолжить"
        WebElement serviceRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("services")));
        scrollToCenter(driver, serviceRadio, actions);

        // Заполнение полей и проверка работы кнопки "Продолжить"
        serviceRadio.click();

        WebElement phoneNumberInput = driver.findElement(By.id("phoneNumber"));
        phoneNumberInput.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        scrollToCenter(driver, continueButton, actions);
        continueButton.click();

        // Закрытие браузера
        driver.quit();
    }

    // Метод для прокрутки элемента в центр видимой области
    public static void scrollToCenter(WebDriver driver, WebElement element, Actions actions) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
}