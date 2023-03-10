package ex04;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ex02.ViewResult;
import ex02.Item2d;
/**
 The MainTest class contains JUnit tests for the ViewResult class.
 @author xone
 @version 1.0
 @since 10.03.2023
 */
public class MainTest {
    private ViewResult viewResult;
    /**
     * Sets up a new ViewResult object with 2 items for testing before each test.
     */
    @Before
    public void setUp() {
        // create a new ViewResult object with 2 items for testing
        viewResult = new ViewResult(2);
    }
    /**
     * Tests the calc() method of the ViewResult class by providing an input value of 10.0.
     * The method calculates the hex and oct values for the input value and returns a map.
     * The expected result is compared to the actual result using the assertEquals method.
     */
    @Test
    public void testCalc() {
        // test the calc() method with an input value of 10.0
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("hex", 1);
        expected.put("oct", 2);
        assertEquals(expected, viewResult.calc(10.0));
    }
    /**
     * Tests the init() method of the ViewResult class by checking the input, hex, and oct values of the first item
     * after initializing it with an input value of 0.5. The expected values are compared to the actual values using the
     * assertEquals method.
     */
    @Test
    public void testInit() {
        // test the init() method by checking the input and hex/oct values of the first item
        viewResult.init(0.5);
        Item2d item = viewResult.getItems().get(0);
        assertEquals(0.0, item.getInput(), 0.0);
        assertEquals(0, item.getHex());
        assertEquals(0, item.getOct());
    }
    /**
     * Cleans up after each test by setting the ViewResult object to null.
     */
    @After
    public void tearDown() {
        // clean up after each test by setting the viewResult object to null
        viewResult = null;
    }
}