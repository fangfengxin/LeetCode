package problem_0032_LongestValidParentheses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestValidParenthesesTest {
    private LongestValidParentheses solution;
    private String[] strs;
    private int[] expected;

    @Before
    public void init() {
        solution = new LongestValidParentheses();
        strs = new String[]{"(()", ")()())", "(()())", "())"};
        expected = new int[]{2, 4, 6, 2};
    }

    @Test
    public void testLongestValidParentheses1() {
        int[] result = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            result[i] = solution.longestValidParentheses1(strs[i]);
        }
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testLongestValidParentheses2() {
        int[] result = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            result[i] = solution.longestValidParentheses2(strs[i]);
        }
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testLongestValidParentheses3() {
        int[] result = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            result[i] = solution.longestValidParentheses3(strs[i]);
        }
        Assert.assertArrayEquals(expected, result);
    }
}
