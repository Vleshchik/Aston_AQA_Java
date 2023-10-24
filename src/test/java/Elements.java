import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Elements {
    @FindBy (id = "Calculator")
    private AndroidElement calculator;
    @FindBy(id = "com.google.android.calculator:id/op_add")
    private AndroidElement plus;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    private AndroidElement minus;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    private AndroidElement multiply;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"divide\"]")
    private AndroidElement divide;
    @FindBy(id = "com.google.android.calculator:id/eq")
    private AndroidElement equal;
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.google.android.calculator:id/formula\"]")
    private AndroidElement expression;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    private AndroidElement result;
    @FindBy(id = "com.google.android.calculator:id/clr")
    private AndroidElement clear;
    @FindBy(id = "com.google.android.calculator:id/digit_0")
    private AndroidElement zero;
    @FindBy(id = "com.google.android.calculator:id/digit_1")
    private AndroidElement one;
    @FindBy(id = "com.google.android.calculator:id/digit_2")
    private AndroidElement two;
    @FindBy(id = "com.google.android.calculator:id/digit_3")
    private AndroidElement three;
    @FindBy(id = "com.google.android.calculator:id/digit_4")
    private AndroidElement four;
    @FindBy(id = "com.google.android.calculator:id/digit_5")
    private AndroidElement five;
    @FindBy(id = "com.google.android.calculator:id/digit_6")
    private AndroidElement six;
    @FindBy(id = "com.google.android.calculator:id/digit_7")
    private AndroidElement seven;
    @FindBy(id = "com.google.android.calculator:id/digit_8")
    private AndroidElement eight;
    @FindBy(id = "com.google.android.calculator:id/digit_9")
    private AndroidElement nine;
    public AndroidElement getCalculator() {
        return calculator;
    }
    public AndroidElement getEqual() {
        return equal;
    }
    public AndroidElement getPlus() {
        return plus;
    }
    public AndroidElement getMinus() {
        return minus;
    }
    public AndroidElement getMultiply() {
        return multiply;
    }
    public AndroidElement getDivide() {
        return divide;
    }
    public AndroidElement getOne() {
        return one;
    }
    public AndroidElement getTwo() {
        return two;
    }
    public AndroidElement getThree() {
        return three;
    }
    public AndroidElement getFour() {
        return four;
    }
    public AndroidElement getFive() {
        return five;
    }
    public AndroidElement getSix() {
        return six;
    }
    public AndroidElement getSeven() {
        return seven;
    }
    public AndroidElement getEight() {
        return eight;
    }
    public AndroidElement getNine() {
        return nine;
    }
    public AndroidElement getZero() {
        return zero;
    }
    public AndroidElement getResult() {
        return result;
    }
    public AndroidElement getExpression() {
        return expression;
    }
    public AndroidElement getClear() {
        return clear;
    }
    public WebElement waitVisible(AndroidDriver<AndroidElement> driver, AndroidElement element) {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }
}