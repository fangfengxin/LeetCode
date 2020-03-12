package problem_1071_GreatestCommonDivisorOfStrings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreatestCommonDivisorOfStringsTest {
    GreatestCommonDivisorOfStrings solution;
    String str1;
    String str2;
    String expected;

    @Before
    public void setUp() {
        solution = new GreatestCommonDivisorOfStrings();
        str1 = "ABCABC";
        str2 = "ABC";
        expected = "ABC";
    }

    @Test
    public void gcdOfStrings() {
        String result = solution.gcdOfStrings(str1, str2);
        assertEquals(expected, result);
    }
}