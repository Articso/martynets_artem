import java.io.Serializable;
/**
 * Represents a two-dimensional item that stores input along with the number of hexadecimal and octal digits.
 */
public class Item2d implements Serializable {
    /**
     * The input value of the item.
     */
    private double input;
    /**
     * The number of hexadecimal digits in the item.
     */
    private int hex;
    /**
     * The number of octal digits in the item.
     */
    private int oct;
    /**
     * Constructs a new Item2d with default values of input, hex, and oct.
     */
    public Item2d() {}
    /**
     * Constructs a new Item2d with specified values for input, hex, and oct.
     *
     * @param input The input value of the item.
     * @param hex The number of hexadecimal digits in the item.
     * @param oct The number of octal digits in the item.
     */
    public Item2d(double input, int hex, int oct) {
        this.input = input;
        this.hex= hex;
        this.oct = oct;
    }
    /**
     * Gets the input value of the item.
     *
     * @return The input value of the item.
     */
    public double getInput() {
        return input;
    }
    /**
     * Sets the input value of the item.
     *
     * @param input The input value of the item.
     */
    public void setInput(double input) {
        this.input = input;
    }
    /**
     * Gets the number of hexadecimal digits in the item.
     *
     * @return The number of hexadecimal digits in the item.
     */
    public int getHex() {
        return oct;
    }
    /**
     * Sets the number of hexadecimal digits in the item.
     *
     * @param hex The number of hexadecimal digits in the item.
     */
    public void setHex(int hex) {
        this.hex = hex;
    }
    /**
     * Gets the number of octal digits in the item.
     *
     * @return The number of octal digits in the item.
     */
    public int getOct() {
        return oct;
    }
    /**
     * Sets the number of octal digits in the item.
     *
     * @param oct The number of octal digits in the item.
     */
    public void setOct(int oct) {
        this.oct = oct;
    }
    /**
     * Returns a string representation of the item.
     *
     * @return A string representation of the item.
     */
    @Override
    public String toString() {
        return "Input: " + input + ", Number of hexadecimal digits: " + hex +
                ", Number of octal digits: " + oct;
    }
}