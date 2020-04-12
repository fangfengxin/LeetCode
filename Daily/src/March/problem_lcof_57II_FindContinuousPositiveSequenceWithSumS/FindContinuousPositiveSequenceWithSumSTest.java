package March.problem_lcof_57II_FindContinuousPositiveSequenceWithSumS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindContinuousPositiveSequenceWithSumSTest {
    private FindContinuousPositiveSequenceWithSumS solution;
    private int[] target;
    private int[][][] expected;

    @Before
    public void init() {
        solution = new FindContinuousPositiveSequenceWithSumS();
        target = new int[]{9, 15};
        expected = new int[][][]{
                {{2, 3, 4}, {4, 5}},
                {{1, 2, 3, 4, 5}, {4, 5, 6}, {7, 8}}
        };
    }

    @Test
    public void testFindContinuousSequence() {
        for (int i = 0; i < target.length; i++) {
            int[][] result = solution.findContinuousSequence(target[i]);
            Assert.assertArrayEquals(expected[i], result);
        }
    }
}
