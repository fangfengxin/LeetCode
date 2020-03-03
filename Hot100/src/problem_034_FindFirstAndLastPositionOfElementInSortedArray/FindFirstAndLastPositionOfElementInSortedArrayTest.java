package problem_034_FindFirstAndLastPositionOfElementInSortedArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {
    private FindFirstAndLastPositionOfElementInSortedArray solution;
    private int[][] nums;
    private int[] targets;
    private int[][] expects;

    @Before
    public void init() {
        solution = new FindFirstAndLastPositionOfElementInSortedArray();
        nums = new int[][]{{5, 7, 7, 8, 8, 10}, {5, 7, 7, 8, 8, 10}, {}, {1}};
        targets = new int[]{8, 6, 0, 1};
        expects = new int[][]{{3, 4}, {-1, -1}, {-1, -1}, {0, 0}};
    }

    @Test
    public void testSearch1() {
        int[][] results = new int[expects.length][expects[0].length];
        for (int i = 0; i < targets.length; i++) {
            results[i] = solution.searchRange1(nums[i], targets[i]);
        }
        Assert.assertArrayEquals(expects, results);
    }

    @Test
    public void testSearch2() {
        int[][] results = new int[expects.length][expects[0].length];
        for (int i = 0; i < targets.length; i++) {
            results[i] = solution.searchRange2(nums[i], targets[i]);
        }
        Assert.assertArrayEquals(expects, results);
    }
}
