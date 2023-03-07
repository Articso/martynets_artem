/**
 * A class to count the number of hexadecimal and 8-decimal digits in a given decimal value.
 */
public class DigitCounter {

    private int decimalValue;

    /**
     * Constructs a new DigitCounter object with the specified decimal value.
     *
     * @param decimalValue the decimal value to count digits in
     */
    public DigitCounter(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    /**
     * Returns the number of hexadecimal digits in the decimal value.
     *
     * @return the number of hexadecimal digits
     */
    public int countHexDigits() {
        String hexString = Integer.toHexString(decimalValue);
        return hexString.length();
    }

    /**
     * Returns the number of 8-decimal digits in the decimal value.
     *
     * @return the number of 8-decimal digits
     */
    public int countDecimalDigits() {
        String decimalString = Integer.toString(decimalValue);
        int numDigits = decimalString.length();
        int numEights = (numDigits + 7) / 8; // round up to nearest multiple of 8
        return numEights * 8;
    }

}