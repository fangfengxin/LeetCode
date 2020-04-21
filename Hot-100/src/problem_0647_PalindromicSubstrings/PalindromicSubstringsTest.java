package problem_0647_PalindromicSubstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/21 19:35
 */
class PalindromicSubstringsTest {
    private PalindromicSubstrings solution;
    private String s;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new PalindromicSubstrings();
        s = "aaa";
        expected = 6;
    }

    @Test
    void countSubstrings1() {
        int result = solution.countSubstrings1(s);
        assertEquals(expected, result);
    }

    @Test
    void countSubstrings2() {
        int result = solution.countSubstrings2(s);
        assertEquals(expected, result);
    }

    @Test
    void countSubstrings3() {
        int result = solution.countSubstrings3(s);
        assertEquals(expected, result);
    }
}