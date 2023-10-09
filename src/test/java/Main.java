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
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("https://www.mts.by/");
        wait.until(ExpectedConditions.titleContains("МТС – мобильный оператор в Беларуси"));
        // Прокрутка страницы до блока "Онлайн пополнение без комиссии"
        //WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/h2")));
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']//h2")));
        // Проверка названия блока "Онлайн пополнение без комиссии"
        System.out.println("Название блока: " + blockTitle.getText());

        // Прокрутка страницы до логотипов платежных систем
        WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__partners']")));
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
        WebElement serviceRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__form']")));
        scrollToCenter(driver, serviceRadio, actions);

        // Заполнение полей и проверка работы кнопки "Продолжить"
        serviceRadio.click();

        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(@class,'button button__default')]"));
        scrollToCenter(driver, continueButton, actions);
        continueButton.click();
        System.out.println("Click!");

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