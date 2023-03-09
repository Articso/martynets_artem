import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
/**
 * ViewResult is a class that implements the View interface and displays results in a formatted way.
 */
public class ViewResult implements View {

    private static final String FILENAME = "items.bin";

    private static final int DEFAULT_NUM = 10;

    private ArrayList<Item2d> items = new ArrayList<Item2d>();
    /**
     * Constructs a ViewResult object with the default number of items to display.
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    /**
     * Constructs a ViewResult object with the specified number of items to display.
     * @param n The number of items to display.
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }
    /**
     * Returns the ArrayList of Item2d objects.
     * @return The ArrayList of Item2d objects.
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }
    /**
     * Calculates the hexadecimal and octal representations of the input value.
     * @param input The input value.
     * @return A Map object containing the hexadecimal and octal counts.
     */
    public Map<String, Integer> calc(double input) {
        int decimalValue = (int) input;

        String hexString = "0123456789ABCDEF";
        String octString = "01234567";

        int hexCount = 0;
        while (decimalValue > 0) {
            int remainder = decimalValue % 16;
            if (hexString.charAt(remainder) != '\0') {
                hexCount++;
            }
            decimalValue /= 16;
        }

        decimalValue = 0;
        decimalValue = (int) input;

        int octCount = 0;
        while (decimalValue > 0) {
            int remainder = decimalValue % 8;
            if (octString.charAt(remainder) != '\0') {
                octCount++;
            }
            decimalValue /= 8;
        }

        return Map.ofEntries(entry("hex", hexCount),entry("oct", octCount));
    }
    /**
     * Initializes the Item2d objects with input values and their corresponding hexadecimal and octal counts.
     * @param stepInput The step input value to increment the input value for each Item2d object.
     */
    public void init(double stepInput) {
        double input = 0.0;
        for(Item2d item : items) {
            Map<String, Integer> calcMap = calc(input);
            item.setInput(input);
            item.setHex(calcMap.get("hex"));
            item.setOct(calcMap.get("oct"));
            input += stepInput;
        }
    }
    /**
     * Initializes the ViewResult object with a randomly generated step input value and initializes the Item2d objects.
     */
    @Override
    public void viewInit() {
        init(Math.random() * 100.0);
    }
    /**
     * Saves the Item2d objects to a binary file.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
    /** Implementation of the {@linkplain View#viewRestore()}<br> method
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }
    /** Implementation of the {@linkplain View#viewHeader()}<br> method
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }
    /** Implementation of the {@linkplain View#viewBody()}<br> method
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for(Item2d item : items) {
            System.out.printf("<%.2f; %d; %d> ", item.getInput(), item.getHex(), item.getOct());
        }
        System.out.println();
    }
    /** Implementation of the {@linkplain View#viewFooter()}<br> method
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }
    /** Implementation of the {@linkplain View#viewShow()}<br> method
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}