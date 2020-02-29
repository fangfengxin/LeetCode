package problem_020_ValidParentheses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidParenthesesTest {
    private ValidParentheses solution;
    private String[] s;
    private boolean[] expected;
    private boolean[] result;

    @Before
    public void init() {
        solution = new ValidParentheses();
        s = new String[]{"[", "()", "()[]{}", "(]", "([)]", "{[]}"};
        expected = new boolean[]{false, true, true, false, false, true};
        result = new boolean[s.length];
    }

    @Test
    public void testIsValid() {
        for (int i = 0; i < s.length; i++) {
            result[i] = solution.isValid(s[i]);
        }
        Assert.assertArrayEquals(expected, result);
    }
}
