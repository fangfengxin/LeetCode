package April.problem_0008_StringToInteger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToIntegerTest {
    StringToInteger solution;
    String str;
    int expected;

    @Before
    public void setUp() {
        solution = new StringToInteger();
        str = "      -11919730356x";
        expected = -2147483648;
    }

    @Test
    public void testMyAtoi1() {
        int result = solution.myAtoi1(str);
        assertEquals(expected, result);
    }

    @Test
    public void testMyAtoi2() {
        int result = solution.myAtoi2(str);
        assertEquals(expected, result);
    }
}