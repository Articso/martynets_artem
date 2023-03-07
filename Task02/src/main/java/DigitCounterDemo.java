import java.io.*;

import javax.swing.JOptionPane;

/**
 * A class to demonstrate saving and restoring the state of a DigitCounterResult object using serialization.
 */
public class DigitCounterDemo {

    private static final String SAVE_FILE_NAME = "digitCounterResult.ser"; // file name to save serialized object

    public static void main(String[] args) {
        int decimalValue = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a decimal value:"));

        DigitCounter digitCounter = new DigitCounter(decimalValue);
        int numHexDigits = digitCounter.countHexDigits();
        int numDecimalDigits = digitCounter.countDecimalDigits();

        DigitCounterResult result = new DigitCounterResult(decimalValue, numHexDigits, numDecimalDigits);

        saveResult(result);

        DigitCounterResult restoredResult = restoreResult();

        String message = "Decimal value: " + restoredResult.getDecimalValue() + "\n"
                + "Number of hexadecimal digits: " + restoredResult.getNumHexDigits() + "\n"
                + "Number of 8-decimal digits: " + restoredResult.getNumDecimalDigits();

        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Saves a DigitCounterResult object to a file using serialization.
     *
     * @param result the result object to save
     */
    private static void saveResult(DigitCounterResult result) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_NAME))) {
            oos.writeObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Restores a DigitCounterResult object from a file using serialization.
     *
     * @return the restored result object
     */
    private static DigitCounterResult restoreResult() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE_NAME))) {
            return (DigitCounterResult) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}