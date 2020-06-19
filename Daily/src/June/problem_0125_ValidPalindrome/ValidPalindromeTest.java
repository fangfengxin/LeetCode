package June.problem_0125_ValidPalindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/19 11:59
 */
class ValidPalindromeTest {
    private ValidPalindrome solution;
    private String s;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new ValidPalindrome();
        s = "A man, a plan, a canal: Panama";
        expected = true;
    }

    @Test
    void isPalindrome1() {
        boolean result = solution.isPalindrome1(s);
        assertEquals(expected, result);
    }

    @Test
    void isPalindrome2() {
        boolean result = solution.isPalindrome2(s);
        assertEquals(expected, result);
    }
}