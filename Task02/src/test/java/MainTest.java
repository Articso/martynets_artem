import org.junit.Test;
import static org.junit.Assert.*;
/**
 * The MainTest class contains JUnit tests for the Calc class.
 */
public class MainTest {
    /**
     * Tests the calculation method of the Calc class.
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        Item2d result = calc.calc(15.5);
        assertEquals(15.5, result.getInput(), 0.001);
        assertEquals(2, result.getHex());
        assertEquals(2, result.getOct());
    }
    /**
     * Tests the initialization method of the Calc class.
     */
    @Test
    public void testInit() {
        Calc calc = new Calc();
        calc.init(20.25);
        Item2d result = calc.getResult();
        assertEquals(20.25, result.getInput(), 0.001);
        assertEquals(2, result.getHex());
        assertEquals(2, result.getOct());
    }
    /**
     * Tests the save and restore methods of the Calc class.
     */
    @Test
    public void testSaveAndRestore() {
        Calc calc = new Calc();
        calc.init(10.0);
        try {
            calc.save();
            calc.restore();
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
        Item2d result = calc.getResult();
        assertEquals(10.0, result.getInput(), 0.001);
        assertEquals(2, result.getHex());
        assertEquals(2, result.getOct());
    }
}