import Aston.main.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorialForPositiveNumber() {
        int number = 5;
        long expectedFactorial = 120;

        long actualFactorial = Main.calculateFactorial(number);

        Assert.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test
    public void testCalculateFactorialForZero() {
        int number = 0;
        long expectedFactorial = 1;

        long actualFactorial = Main.calculateFactorial(number);

        Assert.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialForNegativeNumber() {
        int number = -5;

        Main.calculateFactorial(number);
    }
}