import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    /**
     * Test the calculation method of the Calc class.
     *
     * This method tests the calc() method of the Calc class by creating a new instance of Calc,
     * calculating the result for a given input value, and then verifying the result contains the
     * expected values.
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        Item2d result = calc.calc(12345.6789);
        assertNotNull(result);
        assertEquals(12345.6789, result.getInput(), 0.0001);
        assertEquals(3, result.getNum16YearDigits());
        assertEquals(5, result.getNum8YearDigits());
    }

    /**
     * Test the save and restore methods of the Calc class.
     *
     * This method tests the save() and restore() methods of the Calc class by creating a new instance
     * of Calc, initializing it with a value, saving the result to a file, creating a new instance of
     * Calc, restoring the saved result, and then verifying that the restored result matches the original.
     */
    @Test
    public void testSaveRestore() {
        Calc calc1 = new Calc();
        calc1.init(9876.5432);
        try {
            calc1.save();
        } catch (Exception e) {
            fail("Serialization error: " + e);
        }
        Calc calc2 = new Calc();
        try {
            calc2.restore();
        } catch (Exception e) {
            fail("Deserialization error: " + e);
        }
        Item2d result1 = calc1.getResult();
        Item2d result2 = calc2.getResult();
        assertNotNull(result1);
        assertNotNull(result2);
        assertEquals(result1.getInput(), result2.getInput(), 0.0001);
        assertEquals(result1.getNum16YearDigits(), result2.getNum16YearDigits());
        assertEquals(result1.getNum8YearDigits(), result2.getNum8YearDigits());
    }
}