import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The Calc class provides methods for performing calculations on a given input,
 * storing and retrieving the result, and saving and restoring the result to/from a file.
 */
public class Calc {

    /** The filename to use for saving and restoring the result. */
    private static final String FILENAME = "Save.bin";

    /** The current result of the calculation. */
    private Item2d result;

    /**
     * Constructs a new Calc object with an initial result of 0.
     */
    public Calc() {
        result = new Item2d();
    }

    /**
     * Sets the current result of the calculation to the specified value.
     *
     * @param result the new result to set
     */
    public void setResult(Item2d result) {
        this.result = result;
    }

    /**
     * Returns the current result of the calculation.
     *
     * @return the current result
     */
    public Item2d getResult() {
        return result;
    }

    /**
     * Performs a calculation on the specified input and returns the result.
     *
     * @param input the input value to use for the calculation
     * @return the result of the calculation
     */
    public Item2d calc(double input) {
        int hex = Integer.toHexString((int) input).length();
        int oct = Integer.toOctalString((int) input).length();

        return new Item2d(input, hex, oct);
    }

    /**
     * Initializes the calculator with the result of performing a calculation on the specified input.
     *
     * @param input the input value to use for the calculation
     */
    public void init(double input) {
        setResult(calc(input));
    }

    /**
     * Prints the current result of the calculation to the console.
     */
    public void show() {
        System.out.println(getResult());
    }

    /**
     * Saves the current result to a file.
     *
     * @throws IOException if an error occurs while writing to the file
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Restores the current result from a file.
     *
     * @throws Exception if an error occurs while reading from the file
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}