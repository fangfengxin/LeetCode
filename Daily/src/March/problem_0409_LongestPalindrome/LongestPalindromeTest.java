package March.problem_0409_LongestPalindrome;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromeTest {
    LongestPalindrome solution;
    String s;
    int expected;

    @Before
    public void setUp() {
        solution = new LongestPalindrome();
        s = "abccccdd";
        expected = 7;
    }

    @Test
    public void testLongestPalindrome1() {
        int result = solution.longestPalindrome1(s);
        assertEquals(expected, result);
    }

    @Test
    public void testLongestPalindrome2() {
        int result = solution.longestPalindrome2(s);
        assertEquals(expected, result);
    }
}