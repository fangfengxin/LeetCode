package May.problem_0005_LongestPalindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/21 0:17
 */
class LongestPalindromeTest {
    private LongestPalindrome solution;
    private String s;
    private String expected;

    @BeforeEach
    void setUp() {
        solution = new LongestPalindrome();
        s = "cbbd";
        expected = "bb";
    }

    @Test
    void longestPalindrome1() {
        String result = solution.longestPalindrome1(s);
        assertEquals(expected, result);
    }

    @Test
    void longestPalindrome2() {
        String result = solution.longestPalindrome2(s);
        assertEquals(expected, result);
    }

    @Test
    void longestPalindrome3() {
        String result = solution.longestPalindrome3(s);
        assertEquals(expected, result);
    }
}