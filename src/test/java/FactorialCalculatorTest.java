import Aston.main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    @Test
    void testCalculateFactorialForPositiveNumber() {
        int number = 5;
        long expectedFactorial = 120;

        long actualFactorial = Main.calculateFactorial(number);

        Assertions.assertEquals(expectedFactorial, actualFactorial);
    }

    @Test
    void testCalculateFactorialForZero() {
        int number = 0;
        long expectedFactorial = 1;

        long actualFactorial = Main.calculateFactorial(number);

        Assertions.assertEquals(expectedFactorial, actualFactorial);
    }

    @Test
    void testCalculateFactorialForNegativeNumber() {
        int number = -5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFactorial(number);
        });
    }
}