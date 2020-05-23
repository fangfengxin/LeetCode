package May.problem_0076_MinimumWindowSubstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/23 10:20
 */
class MinimumWindowSubstringTest {
    private MinimumWindowSubstring solution;
    private String s;
    private String t;
    private String expected;

    @BeforeEach
    void setUp() {
        solution = new MinimumWindowSubstring();
        s = "ADOBECODEBANC";
        t = "ABC";
        expected = "BANC";
    }

    @Test
    void minWindow() {
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }
}