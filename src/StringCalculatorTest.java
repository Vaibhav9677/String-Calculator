// Import JUnit 5 APIs
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Test class for StringCalculator
public class StringCalculatorTest {

    // local variable to check how many times Add() was invoked
    int icount = 0;

    //------------------------------Basic Tests------------------------------------------------
    @Test
    @DisplayName("Empty string should return 0")
    void testEmptyString() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));                    // "" => 0
    }

    @Test
    @DisplayName("String with number 1 and 2")
    void testStringWith1_2Number() {
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("1,2"));                 // "1,2" => 3
    }

    @Test
    @DisplayName("Unknown amount of numbers should be summed")
    void testUnknownAmountOfNumbers() {
        StringCalculator sc = new StringCalculator();
        assertEquals(10, sc.add("1,2,3,4"));            // "1,2,3,4" => 10
    }


    // ---------------- HANDLING CUSTOM DELIMITERS ----------------
    @Test
    @DisplayName("Numbers separated by newlines should be summed")
    void testNewlineAsDelimiter() {
        StringCalculator sc = new StringCalculator();
        assertEquals(6, sc.add("1\n2,3"));               // supports both \n and ,
    }   

    @Test
    @DisplayName("Custom delimiter should be supported")
    void testCustomDelimiter() {
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("//;\n1;2"));             // custom delimiter ";" => 3
    }


    // ---------------- NEGATIVE NUMBERS ---------------------------------
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

    // ---------------- COUNT OF add()  CALLED  ----------------
    @Test
    @DisplayName("how many times Add() was invoked")
    void testCountaddinvked() {
        StringCalculator sc = new StringCalculator();
        icount = StringCalculator.count;
        assertEquals(icount, sc.GetCalledCount());
    }

    // ---------------- BIG NUMBERS ----------------
    @Test
    @DisplayName("Numbers bigger than 1000 should be ignored")
    void testNumberBiggerthan1000Ignore() {
        StringCalculator sc = new StringCalculator();
        assertEquals(12, sc.add("//,\n1001,2,10"));         /// 2 + 10 => 12
    }

    // ---------------- MULTI-CHAR DELIMITERS ----------------

    @Test
    @DisplayName("Delimiter of any length should be supported")
    void testMultiCharacterDelimiter() {
    StringCalculator sc = new StringCalculator();
    assertEquals(6, sc.add("//[***]\n1***2***3"));
    }

    @Test
    @DisplayName("Multiple delimiters should be supported")
    void testMultipleDelimiters() {
        StringCalculator sc = new StringCalculator();
        assertEquals(6, sc.add("//[*][%]\n1*2%3"));
    }

    @Test
    @DisplayName("Multiple delimiters with length longer than one char should be supported")
    void testMultipleMultiCharDelimiters() {
        StringCalculator sc = new StringCalculator();
        assertEquals(15, sc.add("//[###][@@]\n4###5@@6"));
        assertEquals(6, sc.add("//[**][%%]\n1**2%%3"));
        
    }
}
