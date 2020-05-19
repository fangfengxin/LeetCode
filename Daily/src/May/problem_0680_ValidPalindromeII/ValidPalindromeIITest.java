package May.problem_0680_ValidPalindromeII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/19 14:57
 */
class ValidPalindromeIITest {
    private ValidPalindromeII solution;
    private String s;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new ValidPalindromeII();
        s = "abca";
        expected = true;
    }

    @Test
    void validPalindrome() {
        boolean result = solution.validPalindrome(s);
        assertEquals(expected, result);
    }
}