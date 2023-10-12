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
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        scrollToCenter(driver, continueButton, actions);
        continueButton.click();
        //Надписи в поле Услуги связи //input[contains(@placeholder,'Номер телефона')]
        WebElement blockTitle = driver.findElement(By.id("connection-phone"));
        scrollToCenter(driver, blockTitle, actions);
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle.getText());
        WebElement blockTitle_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///input[@id='connection-sum']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_2.getText());
        WebElement blockTitle_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='E-mail для отправки чека']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_3.getText());
        //Надписи в поле Домашний интернет
        WebElement blockTitle = driver.findElement(By.id("connection-phone"));
        scrollToCenter(driver, blockTitle, actions);
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle.getText());
        WebElement blockTitle_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///input[@id='connection-sum']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_2.getText());
        WebElement blockTitle_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='E-mail для отправки чека']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_3.getText());
        //Надписи в поле Рассрочка
        WebElement blockTitle = driver.findElement(By.id("connection-phone"));
        scrollToCenter(driver, blockTitle, actions);
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle.getText());
        WebElement blockTitle_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///input[@id='connection-sum']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_2.getText());
        WebElement blockTitle_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='E-mail для отправки чека']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_3.getText());
        //Надписи в поле Задолженность
        WebElement blockTitle = driver.findElement(By.id("connection-phone"));
        scrollToCenter(driver, blockTitle, actions);
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle.getText());
        WebElement blockTitle_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///input[@id='connection-sum']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_2.getText());
        WebElement blockTitle_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='E-mail для отправки чека']")));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitle_3.getText());
/*
        //задание 2
        WebElement serviceRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__form']")));
        scrollToCenter(driver, serviceRadio, actions);

        serviceRadio.click();
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");
        WebElement sumOfPaymentInput = driver.findElement(By.xpath("///input[@id='connection-sum']"));
        sumOfPaymentInput.sendKeys("10");
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(@class,'button button__default')]"));
        scrollToCenter(driver, continueButton, actions);
        continueButton.click();
        System.out.println("Click!");
        System.out.println("Текущая страница: " + driver.getCurrentUrl());

        WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__partners']")));
        scrollToCenter(driver, paymentLogos, actions);

        if (paymentLogos.isDisplayed()) {
            System.out.println("Логотипы платежных систем отображены");
        } else {
            System.out.println("Логотипы платежных систем не отображены");
        }


        driver.quit();*/
    }


    public static void scrollToCenter(WebDriver driver, WebElement element, Actions actions) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
    // Метод для проверки надписей в незаполненных полях

}