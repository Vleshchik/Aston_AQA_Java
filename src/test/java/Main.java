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
        System.setProperty("webdriver.chrome.driver", "путь_к_драйверу/chromedriver.exe");
        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();
        // Создание объекта Actions для выполнения действий с мышью
        Actions actions = new Actions(driver);
        // Создание объекта WebDriverWait с таймаутом 10 секунд
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Открытие сайта mts.by
        driver.get("https://www.mts.by/");
        // Ожидание загрузки страницы
        wait.until(ExpectedConditions.titleContains("MTS"));
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
        // Проверка надписей в незаполненных полях каждого варианта оплаты услуг
        WebElement servicePaymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("servicePaymentForm")));
        scrollToCenter(driver, servicePaymentForm, actions);
        System.out.println("Надписи в незаполненных полях для варианта 'Услуги связи':");
        checkEmptyFieldLabels(servicePaymentForm);
        // Заполнение полей и проверка работы кнопки "Продолжить" для варианта "Услуги связи"
        WebElement cardNumberInput = driver.findElement(By.id("cardNumber"));
        cardNumberInput.sendKeys("1234567890123456");
        WebElement expirationInput = driver.findElement(By.id("expiration"));
        expirationInput.sendKeys("12/25");
        WebElement cvvInput = driver.findElement(By.id("cvv"));
        cvvInput.sendKeys("123");
        WebElement continueButton2 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        scrollToCenter(driver, continueButton2, actions);
        continueButton2.click();
        // Проверка корректности отображения суммы, номера телефона и надписей в незаполненных полях в появившемся окне
        WebElement paymentSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentSummary")));
        scrollToCenter(driver, paymentSummary, actions);
        System.out.println("Сумма: " + paymentSummary.findElement(By.id("amount")).getText());
        System.out.println("Номер телефона: " + paymentSummary.findElement(By.id("phoneNumber")).getText());
        System.out.println("Надписи в незаполненных полях для ввода реквизитов карты:");
        checkEmptyFieldLabels(paymentSummary);
        // Проверка наличия иконок платежных систем
        WebElement paymentLogos2 = paymentSummary.findElement(By.className("payment-logos"));
        if (paymentLogos2.isDisplayed()) {
            System.out.println("Иконки платежных систем отображены");
        } else {
            System.out.println("Иконки платежных систем не отображены");
        }
        // Закрытие браузера
        driver.quit();
    }
    // Метод для прокрутки элемента в центр видимой области
    public static void scrollToCenter(WebDriver driver, WebElement element, Actions actions) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
    // Метод для проверки надписей в незаполненных полях
    public static void checkEmptyFieldLabels(WebElement form) {
        java.util.List<WebElement> emptyFields = form.findElements(By.xpath(".//input[@required and @value='']"));
        for (WebElement field : emptyFields) {
            String labelText = field.getAttribute("aria-labelledby");
            WebElement label = form.findElement(By.id(labelText));
            System.out.println(label.getText());
        }
    }
}