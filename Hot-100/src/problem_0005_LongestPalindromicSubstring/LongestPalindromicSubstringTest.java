package problem_0005_LongestPalindromicSubstring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring solution;
    private String str;
    private String expected;

    @Before
    public void init() {
        solution = new LongestPalindromicSubstring();
        str = "cbbd";
        expected = "bb";
    }

    @Test
    public void testLongestPalindrome1() {
        String result = solution.longestPalindrome1(str);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLongestPalindrome2() {
        String result = solution.longestPalindrome2(str);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLongestPalindrome3() {
        String result = solution.longestPalindrome3(str);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLongestPalindrome4() {
        String result = solution.longestPalindrome4(str);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLongestPalindrome5() {
        String result = solution.longestPalindrome5(str);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLongestPalindrome6() {
        String result = solution.longestPalindrome6(str);
        Assert.assertEquals(expected, result);
    }
}
