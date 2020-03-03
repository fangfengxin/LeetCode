package problem_039_CombinationSum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CombinationSumTest {
    private CombinationSum solution;
    private int[] candidates;
    private int target;
    private List<List<Integer>> expected;

    @Before
    public void init() {
        solution = new CombinationSum();
        /*candidates = new int[]{2, 3, 6, 7};
        target = 7;
        expected = Arrays.asList(List.of(7), List.of(2, 2, 3));*/
        candidates = new int[]{2, 3, 5};
        target = 8;
        expected = Arrays.asList(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));
    }

    @Test
    public void testCombinationSum() {
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        Assert.assertEquals(expected, result);
    }
}
