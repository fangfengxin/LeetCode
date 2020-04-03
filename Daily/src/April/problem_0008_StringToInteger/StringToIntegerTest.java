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
        str = "42";
        expected = 42;
    }

    @Test
    public void myAtoi() {
        int result = solution.myAtoi(str);
        assertEquals(expected, result);
    }
}