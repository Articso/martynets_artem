package ex05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ex02.ViewResult;
import ex02.Item2d;
/**
 * The MainTest class tests the methods in ViewResult class.
 */
public class MainTest {
    private static final String FILENAME = "items.bin";

    private ViewResult viewResult;
    /**
     * Initializes a new ViewResult object before each test case.
     * @throws Exception if an exception occurs
     */
    @Before
    public void setUp() throws Exception {
        viewResult = new ViewResult(10);
        viewResult.viewInit();
    }
    /**
     * Deletes the file "items.bin" after each test case if it exists.
     * @throws Exception if an exception occurs
     */
    @After
    public void tearDown() throws Exception {
        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }
    /**
     * Tests the getItems method in ViewResult class.
     * Checks if the list of items returned by getItems is not null and has size of 10.
     * @throws Exception if an exception occurs
     */
    @Test
    public void testGetItems() throws Exception {
        ArrayList<Item2d> items = viewResult.getItems();
        assertNotNull(items);
        assertEquals(10, items.size());
    }
    /**
     * Tests the calc method in ViewResult class.
     * Checks if the map returned by calc is not null and has the expected values for "hex" and "oct".
     * @throws Exception if an exception occurs
     */
    @Test
    public void testCalc() throws Exception {
        Map<String, Integer> map = viewResult.calc(255.0);
        assertNotNull(map);
        assertEquals(6, map.get("hex").intValue());
        assertEquals(3, map.get("oct").intValue());
    }
    /**
     * Tests the viewSave and viewRestore methods in ViewResult class.
     * Saves the current state of viewResult using viewSave, restores it using viewRestore, and then checks if the restored items match the original items.
     * @throws Exception if an exception occurs
     */
    @Test
    public void testViewSaveAndRestore() throws Exception {
        viewResult.viewSave();

        ViewResult restoredViewResult = new ViewResult();
        restoredViewResult.viewRestore();

        ArrayList<Item2d> originalItems = viewResult.getItems();
        ArrayList<Item2d> restoredItems = restoredViewResult.getItems();

        assertNotNull(restoredItems);
        assertEquals(originalItems.size(), restoredItems.size());

        for (int i = 0; i < originalItems.size(); i++) {
            Item2d originalItem = originalItems.get(i);
            Item2d restoredItem = restoredItems.get(i);

            assertEquals(originalItem.getInput(), restoredItem.getInput(), 0.0);
            assertEquals(originalItem.getHex(), restoredItem.getHex());
            assertEquals(originalItem.getOct(), restoredItem.getOct());
        }
    }
}