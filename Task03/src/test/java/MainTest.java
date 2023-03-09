import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

    Item2d item;

    View view;

    @Before
    public void setUp() {
        item = new Item2d(123.456, 3, 5);
        view = new ViewResult();
    }

    @Test
    public void testCalc() {
        assertEquals(123.456, item.getInput(), 0.001);
        assertEquals(5, item.getHex());
        assertEquals(5, item.getOct());
        item.setInput(789.123);
        item.setHex(4);
        item.setOct(6);
        assertEquals(789.123, item.getInput(), 0.001);
        assertEquals(6, item.getHex());
        assertEquals(6, item.getOct());
        assertNotNull(item.toString());
    }

    @Test
    public void testViewableResult() {
        assertNotNull(new ViewableResult().getView());
    }

    @Test
    public void testViewable() {
        assertNotNull(new ViewableResult().getView());
    }

}