package problem_003_LengthOfLongestSubstring.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem_003_LengthOfLongestSubstring.code.LengthOfLongestSubstring;

public class LengthOfLongestSubstringTest {
    private LengthOfLongestSubstring solution;
    private String[] str;
    private int[] expected;

    @Before
    public void init() {
        solution = new LengthOfLongestSubstring();
        str = new String[]{"abcabcbb", "bbbbb", "pwwkew", " "};
        expected = new int[]{3, 1, 3, 1};
    }

    @Test
    public void testLengthOfLongestSubstring1() {
        for (int i = 0; i < str.length; i++) {
            int result = solution.lengthOfLongestSubstring1(str[i]);
            Assert.assertEquals(expected[i], result);
        }
    }

    @Test
    public void testLengthOfLongestSubstring2() {
        for (int i = 0; i < str.length; i++) {
            int result = solution.lengthOfLongestSubstring2(str[i]);
            Assert.assertEquals(expected[i], result);
        }
    }

    @Test
    public void testLengthOfLongestSubstring3() {
        for (int i = 0; i < str.length; i++) {
            int result = solution.lengthOfLongestSubstring3(str[i]);
            Assert.assertEquals(expected[i], result);
        }
    }

    @Test
    public void testLengthOfLongestSubstring4() {
        for (int i = 0; i < str.length; i++) {
            int result = solution.lengthOfLongestSubstring4(str[i]);
            Assert.assertEquals(expected[i], result);
        }
    }
}
