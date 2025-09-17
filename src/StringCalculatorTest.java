
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("Empty string should return 0")
    void testEmptyString() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }
}
