package July.problem_0032_LongestValidParenthese;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/4 11:12
 */
class LongestValidParenthesesTest {
    private LongestValidParentheses solution;
    private String s;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new LongestValidParentheses();
        s = ")()())";
        expected = 4;
    }

    @Test
    void longestValidParentheses1() {
        int result = solution.longestValidParentheses1(s);
        assertEquals(expected, result);
    }

    @Test
    void longestValidParentheses2() {
        int result = solution.longestValidParentheses2(s);
        assertEquals(expected, result);
    }

    @Test
    void longestValidParentheses3() {
        int result = solution.longestValidParentheses3(s);
        assertEquals(expected, result);
    }
}