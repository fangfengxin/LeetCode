package problem_0031_NextPermutation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NextPermutationTest {
    private NextPermutation solution;
    private int[][] nums;
    private int[][] expected;

    @Before
    public void init() {
        solution = new NextPermutation();
        nums = new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {1, 3, 2}, {2, 3, 1}};
        expected = new int[][]{{1, 3, 2}, {1, 2, 3}, {1, 5, 1}, {2, 1, 3}, {3, 1, 2}};
    }

    @Test
    public void testNextPermutation() {
        for (int[] num : nums) {
            solution.nextPermutation(num);
        }
        Assert.assertArrayEquals(expected, nums);
    }
}
