
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    int icount = 0;

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

    @Test
    @DisplayName("Custom delimiter should be supported")
    void testCustomDelimiter() {
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("//;\n1;2")); // using ; as delimiter
    }

    @Test
    @DisplayName("Negative number should throw exception with message")
    void testNegativeNumberThrowsException() {
        StringCalculator sc = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sc.add("1,-2,3");
        });

        assertEquals("negatives not allowed: -2", exception.getMessage());
    }

    @Test
    @DisplayName("Multiple negatives should show all in exception message")
    void testMultipleNegativesThrowsException() {
        StringCalculator sc = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sc.add("1,-2,-4,5,-6");
        });

        assertEquals("negatives not allowed: -2,-4,-6", exception.getMessage());
    }

    @Test
    @DisplayName("how many times Add() was invoked")
    void testCountaddinvked() {
        StringCalculator sc = new StringCalculator();
        icount = StringCalculator.count;
        assertEquals(icount, sc.GetCalledCount());
    }

    @Test
    @DisplayName("Numbers bigger than 1000 should be ignored")
    void testNumberBiggerthan1000Ignore() {
        StringCalculator sc = new StringCalculator();
        assertEquals(2, sc.add("//,\n1001,2"));
    }
}
