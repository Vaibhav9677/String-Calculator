
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("Empty string should return 0")
    void testEmptyString() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }

    @Test
    @DisplayName("String with number 1 and 2")
    void testStringWith1_2Number() {
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("1,2"));
    }

    @Test
    @DisplayName("Unknown amount of numbers should be summed")
    void testUnknownAmountOfNumbers() {
        StringCalculator sc = new StringCalculator();
        assertEquals(10, sc.add("1,2,3,4"));
    }

    @Test
    @DisplayName("Numbers separated by newlines should be summed")
    void testNewlineAsDelimiter() {
        StringCalculator sc = new StringCalculator();
        assertEquals(6, sc.add("1\n2,3"));
    }
}
