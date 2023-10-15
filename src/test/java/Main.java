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
        WebElement cookieButton = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        scrollToCenter(driver, cookieButton, actions);
        cookieButton.click();
        //Надписи в поле Услуги связи
        WebElement blockTitlePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Номер телефона']")));
        scrollToCenter(driver, blockTitlePhone, actions);
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitlePhone.getAttribute("placeholder"));
        WebElement blockTitlePhone_2 = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitlePhone_2.getAttribute("placeholder"));
        WebElement blockTitlePhone_3 = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        System.out.println("Надпись в незаполненном поле Услуги связи: " + blockTitlePhone_3.getAttribute("placeholder"));
        System.out.println("___________________________________________________________________");
        //Надписи в поле Домашний интернет
        WebElement blockTitleHomeInternet_1 = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        System.out.println("Надпись в незаполненном поле Домашний интернет: " + blockTitleHomeInternet_1.getAttribute("placeholder"));
        WebElement blockTitleHomeInternet_2 = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        System.out.println("Надпись в незаполненном поле Домашний интернет: " + blockTitleHomeInternet_2.getAttribute("placeholder"));
        WebElement blockTitleHomeInternet_3 = driver.findElement(By.xpath("//input[@id='internet-email']"));
        System.out.println("Надпись в незаполненном поле Домашний интернет: " + blockTitleHomeInternet_3.getAttribute("placeholder"));
        System.out.println("___________________________________________________________________");
        //Надписи в поле Рассрочка
        WebElement blockTitleInstalment_1 = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        System.out.println("Надпись в незаполненном поле Рассрочка: " + blockTitleInstalment_1.getAttribute("placeholder"));
        WebElement blockTitleInstalment_2 = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        System.out.println("Надпись в незаполненном поле Рассрочка: " + blockTitleInstalment_2.getAttribute("placeholder"));
        WebElement blockTitleInstalment_3 = driver.findElement(By.xpath("//input[@id='instalment-email']"));
        System.out.println("Надпись в незаполненном поле Рассрочка: " + blockTitleInstalment_3.getAttribute("placeholder"));
        System.out.println("___________________________________________________________________");
        //Надписи в поле Задолженность
        WebElement blockTitleArrears_1 = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        System.out.println("Надпись в незаполненном поле Задолженность: " + blockTitleArrears_1.getAttribute("placeholder"));
        WebElement blockTitleArrears_2 = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        System.out.println("Надпись в незаполненном поле Задолженность: " + blockTitleArrears_2.getAttribute("placeholder"));
        WebElement blockTitleArrears_3 = driver.findElement(By.xpath("//input[@id='arrears-email']"));
        System.out.println("Надпись в незаполненном поле Задолженность: " + blockTitleArrears_3.getAttribute("placeholder"));
        System.out.println("___________________________________________________________________");

        //задание 2
        WebElement serviceRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__form']")));
        scrollToCenter(driver, serviceRadio, actions);

        serviceRadio.click();
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");
        WebElement sumOfPaymentInput = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumOfPaymentInput.sendKeys("10");
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(@class,'button button__default')]"));
        scrollToCenter(driver, continueButton, actions);
        continueButton.click();
        System.out.println("Click!");
        WebElement checkSumOfPaymentInput = driver.findElement(By.xpath("//p[contains(class,'header__payment-amount')]"));
        System.out.println("Введенная сумма: 10. Отображаемая в шапке сумма: " + checkSumOfPaymentInput.getText());
        WebElement payButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(@class, 'colored disabled ng-star-inserted')]"));
        System.out.println("Введенная сумма: 10. Отображаемая на кнопке сумма: " + payButton.getText());
        WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__partners']")));
        scrollToCenter(driver, paymentLogos, actions);
        if (paymentLogos.isDisplayed()) {
            System.out.println("Логотипы платежных систем отображены");
        } else {
            System.out.println("Логотипы платежных систем не отображены");
        }
        driver.quit();
    }
    public static void scrollToCenter(WebDriver driver, WebElement element, Actions actions) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        actions.moveToElement(element).perform();
    }
    // Метод для проверки надписей в незаполненных полях

}