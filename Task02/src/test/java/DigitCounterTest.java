import org.junit.Test;

import static org.junit.Assert.*;
/**
 * The DigitCounterTest class tests the correctness of the DigitCounter and DigitCounterResult classes.
 */
public class DigitCounterTest {

    /**
     * Tests the countHexDigits method of the DigitCounter class.
     * Compares the expected and actual number of hexadecimal digits for various input values.
     */
    @Test
    public void countHexDigits() {
        DigitCounter digitCounter = new DigitCounter(255);
        int expected = 2;
        int actual = digitCounter.countHexDigits();
        assertEquals(expected, actual);

        digitCounter = new DigitCounter(65535);
        expected = 4;
        actual = digitCounter.countHexDigits();
        assertEquals(expected, actual);

        digitCounter = new DigitCounter(16777215);
        expected = 6;
        actual = digitCounter.countHexDigits();
        assertEquals(expected, actual);
    }

    /**
     * Tests the countDecimalDigits method of the DigitCounter class.
     * Compares the expected and actual number of decimal digits for various input values.
     */
    @Test
    public void countDecimalDigits() {
        DigitCounter digitCounter = new DigitCounter(255);
        int expected = 3;
        int actual = digitCounter.countDecimalDigits();
        assertEquals(expected, actual);

        digitCounter = new DigitCounter(65535);
        expected = 5;
        actual = digitCounter.countDecimalDigits();
        assertEquals(expected, actual);

        digitCounter = new DigitCounter(16777215);
        expected = 8;
        actual = digitCounter.countDecimalDigits();
        assertEquals(expected, actual);
    }

    /**
     * Tests the DigitCounterResult class.
     * Creates DigitCounterResult objects with various input values and tests the getDecimalValue,
     * getNumHexDigits, and getNumDecimalDigits methods.
     */
    @Test
    public void testDigitCounterResult() {
        DigitCounterResult result = new DigitCounterResult(255, 2, 3);
        assertEquals(255, result.getDecimalValue());
        assertEquals(2, result.getNumHexDigits());
        assertEquals(3, result.getNumDecimalDigits());

        result = new DigitCounterResult(65535, 4, 5);
        assertEquals(65535, result.getDecimalValue());
        assertEquals(4, result.getNumHexDigits());
        assertEquals(5, result.getNumDecimalDigits());

        result = new DigitCounterResult(16777215, 6, 8);
        assertEquals(16777215, result.getDecimalValue());
        assertEquals(6, result.getNumHexDigits());
        assertEquals(8, result.getNumDecimalDigits());
    }
}