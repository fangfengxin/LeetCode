package problem_0033_SearchInRotatedSortedArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
    private SearchInRotatedSortedArray solution;
    private int[][] nums;
    private int[] targets;
    private int[] expects;

    @Before
    public void init() {
        solution = new SearchInRotatedSortedArray();
        nums = new int[][]{
                {4, 5, 6, 7, 0, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {5, 1, 3}
        };
        targets = new int[]{0, 3, 5};
        expects = new int[]{4, -1, 0};
    }

    @Test
    public void testSearch() {
        int[] results = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            results[i] = solution.search(nums[i], targets[i]);
        }
        Assert.assertArrayEquals(expects, results);
    }
}
