package club;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest {

    @Test
    public void testNonLeapYear() {
        Date test1 = new Date("2/29/2011");
        assertFalse(test1.isValid());
    }

    @Test
    public void testZeroMonth() {
        Date test2 = new Date("0/24/2014");
        assertFalse(test2.isValid());
    }

    @Test
    public void testBefore1900() {
        Date test3 = new Date("4/2/1880");
        assertFalse(test3.isValid());
    }

    @Test
    public void testOutOfBoundsDay() {
        Date test4 = new Date("4/31/2011");
        assertFalse(test4.isValid());
    }

    @Test
    public void testOutOfBoundsMonth() {
        Date test5 = new Date("13/29/2011");
        assertFalse(test5.isValid());
    }

    @Test
    public void testValidLeapYear() {
        Date test6 = new Date("2/29/2016");
        assertTrue(test6.isValid());
    }

    @Test
    public void testRegularDate() {
        Date test7 = new Date("12/14/2003");
        assertTrue(test7.isValid());
    }
}
