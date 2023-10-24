import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleCalculatorTest {
    private static AndroidDriver driver;
    private static MainScreen calc;
    private String expectedExpr;
    private String expectedRes;
    private String actualExpr;
    private String actualRes;
    @BeforeAll
    public static void setup() {
        driver = DeviceSettings.getAndroidDriver();
        calc = new MainScreen(driver);
        calc.clear().clear();
    }
    @AfterEach
    public void tearDown() {
        calc.clear().clear();
        System.out.println("_____________________________________________________________");
    }
    @AfterAll
    public static void teardown() {
        calc.closeApp();
    }
    @Test
    public void additionTest() {
        calc.six().seven().plus().nine().equal();
        actualExpr = calc.getExpr();
        actualRes = calc.getExprRes();
        expectedExpr = "67+9";
        expectedRes = "76";
        assertAll(
                () -> assertEquals(expectedExpr, actualExpr),
                () -> assertEquals(expectedRes, actualRes)
        );
    }
    @Test
    public void subtractionTest() {
        calc.one().nine().eight().sub().nine().nine().equal();
        actualExpr = calc.getExpr();
        actualRes = calc.getExprRes();
        expectedExpr = "198-99";
        expectedRes = "99";
        assertAll(
                () -> assertEquals(expectedExpr, actualExpr),
                () -> assertEquals(expectedRes, actualRes)
        );
    }
    @Test
    public void multiplicationTest() {
        calc.one().five().multiply().three().equal();
        actualExpr = calc.getExpr();
        actualRes = calc.getExprRes();
        expectedExpr = "15×3";
        expectedRes = "45";
        assertAll(
                () -> assertEquals(expectedExpr, actualExpr),
                () -> assertEquals(expectedRes, actualRes)
        );
    }

    @Test
    public void divisionTest() {
        calc.two().four().divide().three().equal();
        actualExpr = calc.getExpr();
        actualRes = calc.getExprRes();
        expectedExpr = "24÷3";
        expectedRes = "8";
        assertAll(
                () -> assertEquals(expectedExpr, actualExpr),
                () -> assertEquals(expectedRes, actualRes)
        );
    }
}





