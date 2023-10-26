
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen extends Elements {
    private static AndroidDriver<AndroidElement> driver;
    private String expr;
    private String exprRes;
    public MainScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
        this.driver = driver;
    }
    public MainScreen plus() {
        waitVisible(driver, getPlus()).click();
        return this;
    }
    public MainScreen sub() {
        waitVisible(driver, getMinus()).click();
        return this;
    }
    public MainScreen multiply() {
        waitVisible(driver, getMultiply()).click();
        return this;
    }
    public MainScreen divide() {
        waitVisible(driver, getDivide()).click();
        return this;
    }

    public MainScreen equal() {
        waitVisible(driver, getEqual()).click();
        return this;
    }
    public MainScreen zero() {
        waitVisible(driver, getZero()).click();
        return this;
    }
    public MainScreen one() {
        waitVisible(driver, getOne()).click();
        return this;
    }
    public MainScreen two() {
        waitVisible(driver, getTwo()).click();
        return this;
    }
    public MainScreen three() {
        waitVisible(driver, getThree()).click();
        return this;
    }
    public MainScreen four() {
        waitVisible(driver, getFour()).click();
        return this;
    }
    public MainScreen five() {
        waitVisible(driver, getFive()).click();
        return this;
    }
    public MainScreen six() {
        waitVisible(driver, getSix()).click();
        return this;
    }
    public MainScreen seven() {
        waitVisible(driver, getSeven()).click();
        return this;
    }
    public MainScreen eight() {
        waitVisible(driver, getEight()).click();
        return this;
    }
    public MainScreen nine() {
        waitVisible(driver, getNine()).click();
        return this;
    }
    public MainScreen clear() {
        waitVisible(driver, getClear()).click();
        return this;
    }
    public String getExpr() {
        expr = waitVisible(driver, getExpression()).getAttribute("content-desc");;
        return expr;
    }
    public String getExprRes() {
        exprRes = waitVisible(driver, getResult()).getText();
        return exprRes;
    }
    public static void closeApp() {
        driver.quit();
    }
}