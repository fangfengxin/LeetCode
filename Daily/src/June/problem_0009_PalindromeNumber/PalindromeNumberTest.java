package June.problem_0009_PalindromeNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/10 9:54
 */
class PalindromeNumberTest {
    private PalindromeNumber solution;
    private int x;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new PalindromeNumber();
        x = 10;
        expected = false;
    }

    @Test
    void isPalindrome() {
        boolean result = solution.isPalindrome(x);
        assertEquals(expected, result);
    }
}