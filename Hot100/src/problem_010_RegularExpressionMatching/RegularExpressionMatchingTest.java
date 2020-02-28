package problem_010_RegularExpressionMatching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem_010_RegularExpressionMatching.RegularExpressionMatching;

public class RegularExpressionMatchingTest {
    private RegularExpressionMatching solution;
    private String[] text;
    private String[] pattern;
    private boolean[] expected;

    @Before
    public void init() {
        solution = new RegularExpressionMatching();
        text = new String[]{"aa", "aa", "ab", "aab", "mississippi"};
        pattern = new String[]{"a", "a*", ".*", "c*a*b", "mis*is*p*."};
        expected = new boolean[]{false, true, true, true, false};
    }

    @Test
    public void testIsMatch1() {
        for (int i = 0; i < text.length; i++) {
            boolean result = solution.isMatch1(text[i], pattern[i]);
            System.out.println("test" + i + ":" + result);
            Assert.assertEquals(expected[i], result);
        }
    }

    @Test
    public void testIsMatch2() {
        for (int i = 0; i < text.length; i++) {
            boolean result = solution.isMatch2(text[i], pattern[i]);
            System.out.println("test" + i + ":" + result);
            Assert.assertEquals(expected[i], result);
        }
    }
}
