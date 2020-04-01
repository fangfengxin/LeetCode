package April.problem_1111_MaximumNestingDepthOfTwoValidParenthesesStrings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaximumNestingDepthOfTwoValidParenthesesStringsTest {
    MaximumNestingDepthOfTwoValidParenthesesStrings solution;
    String seq;
    int[] expected;

    @Before
    public void setUp() {
        solution = new MaximumNestingDepthOfTwoValidParenthesesStrings();
        seq = "()(())()";
        expected = new int[]{1, 1, 1, 0, 0, 1, 1, 1};
        /*seq = "(()())";
        expected = new int[]{1, 0, 0, 0, 0, 1};*/
    }

    @Test
    public void testMaxDepthAfterSplit1() {
        int[] result = solution.maxDepthAfterSplit1(seq);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxDepthAfterSplit2() {
        int[] result = solution.maxDepthAfterSplit2(seq);
        assertArrayEquals(expected, result);
    }
}