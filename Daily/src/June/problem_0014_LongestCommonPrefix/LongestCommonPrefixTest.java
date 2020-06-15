package June.problem_0014_LongestCommonPrefix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/15 0:02
 */
class LongestCommonPrefixTest {
    private LongestCommonPrefix solution;
    private String[] strs;
    private String expected;

    @BeforeEach
    void setUp() {
        solution = new LongestCommonPrefix();
        strs = new String[]{"flower", "flow", "flight"};
        expected = "fl";
    }

    @Test
    void longestCommonPrefix1() {
        String result = solution.longestCommonPrefix1(strs);
        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix2() {
        String result = solution.longestCommonPrefix2(strs);
        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix3() {
        String result = solution.longestCommonPrefix3(strs);
        assertEquals(expected, result);
    }
}