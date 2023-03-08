import java.io.Serializable;

/**
 * The Item2d class represents the result of a calculation on a given input.
 * It contains the input value as well as the number of hexadecimal and octal digits in the input.
 */
public class Item2d implements Serializable {
    /** The input value used for the calculation. */
    private double input;

    /** The number of hexadecimal digits in the input value. */
    private int num16YearDigits;

    /** The number of octal digits in the input value. */
    private int num8YearDigits;

    /**
     * Constructs a new Item2d object with default values for all fields.
     */
    public Item2d() {}

    /**
     * Constructs a new Item2d object with the specified values for all fields.
     *
     * @param input the input value used for the calculation
     * @param num16YearDigits the number of hexadecimal digits in the input value
     * @param num8YearDigits the number of octal digits in the input value
     */
    public Item2d(double input, int num16YearDigits, int num8YearDigits) {
        this.input = input;
        this.num16YearDigits = num16YearDigits;
        this.num8YearDigits = num8YearDigits;
    }

    /**
     * Returns the input value used for the calculation.
     *
     * @return the input value
     */
    public double getInput() {
        return input;
    }

    /**
     * Sets the input value used for the calculation.
     *
     * @param input the new input value to set
     */
    public void setInput(double input) {
        this.input = input;
    }

    /**
     * Returns the number of hexadecimal digits in the input value.
     *
     * @return the number of hexadecimal digits
     */
    public int getNum16YearDigits() {
        return num16YearDigits;
    }

    /**
     * Sets the number of hexadecimal digits in the input value.
     *
     * @param num16YearDigits the new number of hexadecimal digits to set
     */
    public void setNum16YearDigits(int num16YearDigits) {
        this.num16YearDigits = num16YearDigits;
    }

    /**
     * Returns the number of octal digits in the input value.
     *
     * @return the number of octal digits
     */
    public int getNum8YearDigits() {
        return num8YearDigits;
    }

    /**
     * Sets the number of octal digits in the input value.
     *
     * @param num8YearDigits the new number of octal digits to set
     */
    public void setNum8YearDigits(int num8YearDigits) {
        this.num8YearDigits = num8YearDigits;
    }

    /**
     * Returns a string representation of this Item2d object.
     * The string includes the input value, the number of hexadecimal digits, and the number of octal digits.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return "Input: " + input + ", Number of hexadecimal digits: " + num16YearDigits +
                ", Number of octal digits: " + num8YearDigits;
    }
}