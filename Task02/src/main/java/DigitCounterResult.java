import java.io.Serializable;

/**
 * A serializable class to store parameters and calculation results for digit counting.
 */
public class DigitCounterResult implements Serializable {

    private static final long serialVersionUID = 1L; // to ensure backwards compatibility

    private int decimalValue;
    private int numHexDigits;
    private int numDecimalDigits;

    /**
     * Constructs a new DigitCounterResult object with the specified parameters and calculation results.
     *
     * @param decimalValue the decimal value that was counted
     * @param numHexDigits the number of hexadecimal digits in the decimal value
     * @param numDecimalDigits the number of 8-decimal digits in the decimal value
     */
    public DigitCounterResult(int decimalValue, int numHexDigits, int numDecimalDigits) {
        this.decimalValue = decimalValue;
        this.numHexDigits = numHexDigits;
        this.numDecimalDigits = numDecimalDigits;
    }

    /**
     * Returns the decimal value that was counted.
     *
     * @return the decimal value
     */
    public int getDecimalValue() {
        return decimalValue;
    }

    /**
     * Returns the number of hexadecimal digits in the decimal value.
     *
     * @return the number of hexadecimal digits
     */
    public int getNumHexDigits() {
        return numHexDigits;
    }

    /**
     * Returns the number of 8-decimal digits in the decimal value.
     *
     * @return the number of 8-decimal digits
     */
    public int getNumDecimalDigits() {
        return numDecimalDigits;
    }

}